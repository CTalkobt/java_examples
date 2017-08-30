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
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

public class ReducingExampleTest {
    private static final Logger LOG = Logger.getLogger(ReducingExampleTest.class);

    @Test
    public void testReducing() {
        List<Integer> intsToSum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Reduction 
        Integer sum1 = intsToSum.stream()
            .collect(Collectors.reducing((x1, x2) -> x1 + x2)).get();
        LOG.debug("Sum = " + sum1);
        Assert.assertEquals(55L, 0L + sum1);
        
        // Reduction w/ default value of 42.
        List<Integer> intsToSum2 = Arrays.asList();
        Integer sum2 = intsToSum2.stream().collect(Collectors.reducing(42, (x1,x2) -> x1+x2));
        Assert.assertEquals(42L, 0L + sum2);
        LOG.debug("Sum2 = " + sum2);
    }

}
