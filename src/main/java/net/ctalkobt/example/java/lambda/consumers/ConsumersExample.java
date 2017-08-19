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
package net.ctalkobt.example.java.lambda.consumers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.apache.log4j.Logger;

public class ConsumersExample {
    private static final Logger log = Logger.getLogger(ConsumersExample.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> strs = Arrays.asList(1, 2, 3, 4, 5);
        
        Consumer<Integer> displayX = log::debug;
        Consumer<Integer> displayXSquared = x -> log.debug(" " + x*x);
        
        log.debug("Consumers.andThen");        
        strs.stream()
                .forEach(displayX.andThen(displayXSquared));
        
        log.debug("Consumers.accept:");
        strs.stream().forEach(displayXSquared::accept);
//        strs.stream().forEach(displayXSquared);  // alternate form - accept is default.
    }

}
