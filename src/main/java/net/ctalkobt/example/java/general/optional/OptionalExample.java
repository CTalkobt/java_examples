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

package net.ctalkobt.example.java.general.optional;

import java.util.Optional;
import org.apache.log4j.Logger;

/**
 *
 */
public class OptionalExample {
    private static final Logger log = Logger.getLogger(OptionalExample.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Optional<String> test = myFunction("one");

        Integer value = test
                .map(Integer::parseInt)
                .orElse(-1);
        
        log.debug("Output: " + value);
        log.debug("Type:" + value.getClass());
    }

    private static Optional myFunction(String parm) {
        if (!parm.equals("one")) {
            return Optional.empty();
        }
        return Optional.of("2");
    }

}
