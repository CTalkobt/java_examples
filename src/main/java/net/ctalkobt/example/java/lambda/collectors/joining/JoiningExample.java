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

package net.ctalkobt.example.java.lambda.collectors.joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> presidents = Arrays.asList("Abraham Lincoln", "Zachary Taylor", "Grover Cleveland", "William Taft");
        
        String allNames = presidents.stream()
                .collect(Collectors.joining(", "));
        System.err.println("All presidents: "  + allNames);
    }

}
