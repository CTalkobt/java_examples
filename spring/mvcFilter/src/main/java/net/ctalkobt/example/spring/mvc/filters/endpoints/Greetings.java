/* 
 * Copyright (C) 2021 Craig Taylor <ctalkobt@ctalkobt.net>
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
 */

package net.ctalkobt.example.spring.mvc.filters.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import net.ctalkobt.example.spring.mvc.filters.filter.PrematchingRequestFilter;

/**
 * Define a /greetings/&lt;name&gt; endpoint that will echo back the
 * name path parameter.  Note that the /greetings endpoint itself is 
 * not defined and would usually return a 404 however the 
 * {@link PrematchingRequestFilter} performs a number of alterations to the
 * incoming request to allow that, and other forms to proceed. 
 */
@Path("/")
public class Greetings {
    @GET
    @Path("/greetings/{name}")
    public String getHelloGreeting(@PathParam("name") String name) {
        return "hello " + name;
    }
}
