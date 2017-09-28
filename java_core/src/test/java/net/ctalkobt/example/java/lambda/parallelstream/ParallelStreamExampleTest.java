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

package net.ctalkobt.example.java.lambda.parallelstream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class ParallelStreamExampleTest {
    private static final Logger LOG = Logger.getLogger(ParallelStreamExampleTest.class);

    @Test
    public void testParallelStream() {
        List<Integer> intValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Integer, Integer> result = new HashMap<>(); 
        List<Integer> countHolder = Arrays.asList(0);
        
        for (int i=0; i < intValues.size(); i++) {
            result.put(i, 0);
        }
        
        intValues.parallelStream().forEach( (Integer x) -> {
            Integer count = countHolder.get(0);
            result.put(count, x);
            countHolder.set(0, count+1);
        });

        int numDiffs = 0;
        for (int i = 0; i< 10; i++) {
            if (result.get(i) != i+1) {
                numDiffs++;
            }
        }
        LOG.debug("After parallel: " + result + " / NumDiffs=" + numDiffs);

        Assert.assertTrue(numDiffs > 0);
    }

}
