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
package net.ctalkobt.example.java.lambda.collectors.tolist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

public class ToListExampleTest {
    private static final Logger LOG = Logger.getLogger(ToListExampleTest.class);
    
    @Test
    public void testToList() {
        List<String> strs = Arrays.asList("01", "02", "03", "04", "05", "06", "07");
        
        List<Integer> ints = strs.stream()
                .map(Integer::parseInt)
                .filter(intVal -> intVal < 3 )
                .collect(Collectors.toList());

        Assert.assertArrayEquals(
                Arrays.asList(1,2).toArray(),
                ints.toArray());
        ints.forEach(
                intVal -> LOG.debug("Value: " + intVal));        
    }

}
