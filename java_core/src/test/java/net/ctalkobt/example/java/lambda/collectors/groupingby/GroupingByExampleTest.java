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
package net.ctalkobt.example.java.lambda.collectors.groupingby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class GroupingByExampleTest {
    private static final Logger LOG = Logger.getLogger(GroupingByExampleTest.class);

    @Test
    public void testGroupingBy() {
        List<String> strs = Arrays.asList("01", "02", "03", "04", "05", "06", "07");

        Map<Boolean, List<Integer>> result = strs.stream()
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(x -> x % 2 == 0));
        result.keySet().forEach(key -> 
            LOG.debug("  " + (key ? "even" : "odd") + " : " + result.get(key))
        );
        
        Assert.assertArrayEquals(
                Arrays.asList(1, 3, 5, 7).toArray(),
                result.get(false).toArray());
        Assert.assertArrayEquals(
                Arrays.asList(2,4,6).toArray(),
                result.get(true).toArray());
    }

}
