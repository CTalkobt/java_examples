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

package net.ctalkobt.example.java.lambda.Collectors.partitioningBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> abbreviations = Arrays.asList("laser", "xerox", "parc", "xsd", "xslt", "xml", "ibm", "www", "http");
        
        Map<Boolean, List<String>> abbrevMap = abbreviations.stream()
                .collect(Collectors.partitioningBy(x -> 
                        x.contains("a") || x.contains("e") || x.contains("i") || x.contains("o") ||
                        x.contains("u"))
                );
        
        abbrevMap.forEach( (key,abbrevList) -> 
                System.err.println( (key ? "Vowels" : "Non-Vowels") + " - " + abbrevList));
        
        
    }

}
