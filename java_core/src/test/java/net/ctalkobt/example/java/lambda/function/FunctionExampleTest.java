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

package net.ctalkobt.example.java.lambda.function;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class FunctionExampleTest {
    private static final Logger LOG = Logger.getLogger(FunctionExampleTest.class);

    static Long doCalculate(Long val1, Long val2, BiFunction<Long,Long,Long> fn) {
        return fn.apply(val1, val2);
    }
    
    static Long doCalculate(Long val1, Function<Long,Long> fn) {
        return fn.apply(val1);
    }
    
    @Test
    public void testFunctionExample() {
        Function<Long,Long> mathSquared = x -> x*x;
        BiFunction<Long,Long,Long> mathPlus = (x,y) -> x+y;
        BiFunction<Long,Long,Long> mathMinus = (x,y) -> x-y;

        
        Assert.assertEquals(
                (Long) 150L, 
                doCalculate(100L, 50L, mathPlus));
        Assert.assertEquals(
            (Long) 25L,
            doCalculate(5L, mathSquared));

        LOG.debug( "100 + 50 = " + doCalculate(100l, 50l, mathPlus));
        LOG.debug( "100 - 50 = " + doCalculate(100l, 50l, mathMinus));
        LOG.debug( "50 squared = " + doCalculate(50l, mathSquared));
        
    }

}
