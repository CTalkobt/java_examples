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
 */

package net.ctalkobt.example.java.lambda.Mapping.FlatMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> scientists = Arrays.asList("Ben Franklin","Isaac Newton", "Marie Caruie", "Albert Einstein");
        List<String> politicians = Arrays.asList("Napolean Bonaparte", "Ben Franklin", "Donald Trump", "John F Kennedy");
        
        Stream<List<String>> scientistsPoliticians = Stream.of(scientists, politicians);
        scientistsPoliticians
                .flatMap(Collection::stream)                // Turn list into a stream of Strings.
                .distinct()                                 // Remove duplicate Ben Franklin
                .forEach(x -> System.err.println(x));
                
    }

}
