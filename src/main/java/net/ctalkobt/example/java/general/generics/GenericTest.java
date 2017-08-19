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

package net.ctalkobt.example.java.general.generics;

import org.apache.log4j.Logger;

/**
 *
 */
class GenericTest {
    private static final Logger log = Logger.getLogger(GenericTest.class);

    public static void main(String[] args) {
        // Example: Diamond operator.
        // Note that use of generic type avoids chaving to create multiple classes.
        Parent<String> pStr = new Parent<>("String");
        Parent<Integer> pInt = new Parent<>(5);
        
        pStr.set("ABC");
//        pInt.set("abc"); // this will not compile - Incompatible types.
//        pStr.set(123); // Neither will this.
//
        log.debug("pInt=" + pInt );
        log.debug("pStr=" + pStr );
    }

}
