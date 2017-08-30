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

package net.ctalkobt.example.java.lambda.collectors.partitioningby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class PartitioningByExampleTest {
    private static final Logger LOG = Logger.getLogger(PartitioningByExampleTest.class);

    @Test
    public void testPartioningBy() {
        List<String> abbreviations = Arrays.asList("laser", "xerox", "parc", "xsd", "xslt", "xml", "ibm", "www", "http");
        
        Map<Boolean, List<String>> abbrevMap = abbreviations.stream()
                .collect(Collectors.partitioningBy(x -> 
                        x.contains("a") || x.contains("e") || x.contains("i") || x.contains("o") ||
                        x.contains("u"))
                );
        
        abbrevMap.forEach( (key,abbrevList) -> 
                LOG.debug( (key ? "Vowels" : "Non-Vowels") + " - " + abbrevList));
        Assert.assertArrayEquals(
                Arrays.asList("xsd", "xslt", "xml", "www", "http").toArray(),
                abbrevMap.get(false).toArray());
        Assert.assertArrayEquals(
                Arrays.asList("laser", "xerox", "parc", "ibm").toArray(),
                abbrevMap.get(true).toArray());
        
    }

}
