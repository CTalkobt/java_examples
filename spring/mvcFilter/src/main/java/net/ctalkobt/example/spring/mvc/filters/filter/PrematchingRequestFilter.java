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

package net.ctalkobt.example.spring.mvc.filters.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

/**
 * Shows example of altering incoming requests to allow performing 
 * various "trucks".  See {@link #filter(javax.ws.rs.container.ContainerRequestContext) } details for more information. 
 */
@Provider
@PreMatching
public class PrematchingRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext ctx) throws IOException {
        System.err.println("** Filter: " + ctx.getMethod() + " / " + ctx.getUriInfo().getPath());
        System.err.println("** Filter:: " + ctx.getUriInfo().getMatchedURIs() + " / " + ctx.getUriInfo().getPathParameters() + " / " + ctx.getUriInfo().getRequestUri());


        // For /greetings endpoint w/o a /name supply /someone.
        if (ctx.getUriInfo().getPath().equals("greetings")) {
            System.err.println("*** Filter2:" + ctx.getPropertyNames());

            // An earlier step in the request life-cycle has already used these 2 to indicate that this request has been
            // filtered out before final matching occurs.  Indicate that we should still proceed.
            ctx.removeProperty("requestContextFilter");
            ctx.removeProperty("characterEncodingFilter");

            // Use the current URI to append "/someone" so a name is provided.
            String name = "someone";

            // Howeever, if "override" request parameter is present, use that value instead.
            String override = ctx.getUriInfo().getQueryParameters().getFirst("override");
            if (override != null) {
                name = override;
            }

            // An example of encryption, -- Try adding ?_=Q3JhaWc=
            String encrypted = ctx.getUriInfo().getQueryParameters().getFirst("_");
            if (encrypted != null) {
                try {
                    name = new String(Base64.getDecoder().decode(encrypted), StandardCharsets.UTF_8);
                } catch(Exception ex) {
                    // Toss exception, presumably Base64 decode. Ignore end user error and return whatever other name has been established.
                }
            }

            ctx.setRequestUri(ctx.getUriInfo().getRequestUriBuilder().path("/"+ name ).build((Object) null));
        }
    }

}
