/*
 * Copyright (C) 2017 Craig Taylor <ctalkobt@ctalkobt.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
**/

package net.ctalkobt.example.camel.eip.deadLetterChannel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DLQRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        /** @@TODO: This does not work _unless_ tracing is enabled.
         *  Needs further investigation to determine if possible Camel bug w/ this version.. 
        **/
        getContext().setTracing(true);
        
        from ("activemq://dlqExample?concurrentConsumers=5")
                .routeId("dlqIncoming")
                .setHeader("age", simple("${body.age}"))
                .errorHandler(deadLetterChannel("vm://dlqArchive").useOriginalMessage())
                .end()
                .choice()                   
                    .when(header("age").isLessThan(18))
                        .log("Is < 18 !!!!! : ${body}")
                        .throwException(DLQException.class, "Sending to DLQ")
                    .otherwise()
                        .log("Sent to dqlAdultsOnly")
                        .to("activemq://dlqAdultsOnly")
                .endChoice()                
                ;
                 
        from ("vm://dlqArchive")                
            .log("Saved in DLQ: ${body}")
            .setHeader("age", simple("${body.age}"))
            .setHeader("name", simple("${body.firstName} ${body.lastName}"))
            .to("activemq://dlqDeadLetterQueue");
    
        from ("activemq://dlqAdultsOnly")
            .log("Adults Only: ${body}")
            ;
                                
    }

}
