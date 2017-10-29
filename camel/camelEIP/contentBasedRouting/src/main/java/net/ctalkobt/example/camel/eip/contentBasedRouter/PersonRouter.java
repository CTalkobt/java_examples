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

package net.ctalkobt.example.camel.eip.contentBasedRouter;

import net.ctalkobt.examples.eipexamplelib.Person;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PersonRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from ("vm://person")
            .routeId("PersonRoute")
            .setHeader("age", body().convertTo(Person.class).method("getAge"))
            .choice()
                .when(header("age").isLessThanOrEqualTo(10))
                    .log("Young Person: ${body}")
                .when(header("age").isLessThan(100))
                    .log("Older Person: ${body}")
                .otherwise()
                    .log("Ancient Person: ${body}")
            .end();
    }

}
