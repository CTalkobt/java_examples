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

package net.ctalkobt.example.camel.eip.routingSlip;

import net.ctalkobt.examples.eipexamplelib.Person;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RoutingSlipRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        from("vm://routingSlipExample?concurrentConsumers=1")
                .log("Arrival: ${body.firstName}, ${body.lastName}, type=${body.type}")
                .process((Exchange exchange) -> {
                    Person peep = exchange.getIn().getBody(Person.class);
                    String routingSlip = "";
                    switch (peep.getType()) {
                        case Atypical:
                            routingSlip = "vm://Inspection,vm://Delay,vm://FullInspection,vm://Detention";
                            break;
                        case Normal:
                            routingSlip = "vm://Inspection,vm://Welcome";
                            break;
                        case SomewhatNormal:
                            routingSlip = "vm://FullInspection,vm://Welcome";
                            break;
                        case VisitorAnotherPlanet:
                            routingSlip = "vm://Detention";
                            break;
                        case WorthWeightInGold:
                            routingSlip = "vm://Welcome";
                            break;
                        default:
                            break;
                    }
                    exchange.getIn().setHeader("tsaStops", routingSlip);
                })
                .routingSlip().header("tsaStops");

        from("vm://Welcome").log("Welcome : ${body.firstName} ${body.lastName}");        
        from("vm://Inspection").log("Inspect: ${body.firstName}, ${body.lastName}");
        from("vm://Delay").log("Delay: ${body.firstName}, ${body.lastName}");
        from("vm://Detention").log("Detention: ${body.firstName}, ${body.lastName}");
        from("vm://FullInspection").log("Full Inspection: ${body.firstName}, ${body.lastName}");
    }

}
