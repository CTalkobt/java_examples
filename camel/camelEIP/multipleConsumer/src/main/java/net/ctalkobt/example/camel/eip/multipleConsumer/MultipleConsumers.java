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
package net.ctalkobt.example.camel.eip.multipleConsumer;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.ExpressionBuilder;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MultipleConsumers extends org.apache.camel.builder.RouteBuilder {
    static long mySendCount = 0;
                    
    @Override
    public void configure() throws Exception {
        int numCounsumer = 50;
        int sendDelay=3;
        
        from("timer://xyz?period=" + sendDelay)
            .process((Exchange exchange) -> {
                exchange.getIn().setHeader("count", mySendCount++);
            })
            .setBody(simple("Test: ${in.header.count}"))
            .to("activemq://test");
        
        for (int i = 1; i <= numCounsumer; i++) {
            from("activemq://test")
                    .setExchangePattern(ExchangePattern.InOnly)
                    .setProperty("consumerCount", ExpressionBuilder.constantExpression(i))
                    .to("vm://isPrime");
        }
        
        from ("vm://isPrime?concurrentConsumers=100")
            .process((Exchange exchange) -> {
//                Thread.sleep(100);
                long number = exchange.getIn().getHeader("count", Long.class); 
                LongPredicate isDivisible = index -> number % index == 0;
                boolean isPrime = number > 1 && LongStream.range(2, number -1).noneMatch(isDivisible);                
                exchange.setProperty("prime", isPrime);
             })
            .to ("vm://filterPrimes");
        
        from( "vm://filterPrimes")
            .filter().simple("${property.prime}")
            .log("Prime: ${in.header.count}");
    }
    
}
