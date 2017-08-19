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

package net.ctalkobt.example.java.lambda.collectors.reducing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReducingExample {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> intsToSum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Reduction 
        intsToSum.stream()
            .collect(Collectors.reducing((x1, x2) -> x1 + x2))
            .ifPresent(x -> System.err.println("Sum = " + x));
        
        // Reduction w/ default value.
        List<Integer> intsToSum2 = Arrays.asList();
        System.err.println("Sum2 = " + intsToSum2.stream()
            .collect(Collectors.reducing(0, (x1,x2) -> x1+x2))
        );

    }

}
