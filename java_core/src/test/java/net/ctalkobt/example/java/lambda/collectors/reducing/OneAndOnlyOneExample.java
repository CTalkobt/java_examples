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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Shows way of using Collectors.reducing() to return 1 and only 1 
 * value from a list.  Any lists that are not of size 1 will return a
 * Optional.empty.
 */
public class OneAndOnlyOneExample {
    
    public static Optional<Integer> get1AndOnly1(List<Integer> values) {
        return values.stream().collect(Collectors.reducing( (a,b) -> null));
    }
    
    public static void main(String[] args) {
        List<List<Integer>> lysts = Arrays.asList(
            Arrays.asList(3, 4, 5),
            Arrays.asList(42),
            new ArrayList<>()
        );

        lysts.forEach((arr) -> {
            Optional<Integer> result = get1AndOnly1(arr);
            System.err.println("For size " + arr.size() + ": " + arr + " result = " + result.orElse(null));
        });
    }
}
