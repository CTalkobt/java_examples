/*
 * Copyright (C) 2018 Craig Taylor <ctalkobt@ctalkobt.net>
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

package net.ctalkobt.example.junit.problems.privateMethods;

import org.junit.Test;
import org.junit.Assert;

/**
 *
 */
public class PackageMethodTest {
    
    @Test
    public void testPrivateMethod() {
        
        PackageMethod instance = new PackageMethod(5.0d, 6.0d);        

        String negResult = instance.internalOp(-5.0d);
        String zero = instance.internalOp(0d);
        String positive = instance.internalOp(12d);
        
        Assert.assertEquals("Negative", negResult);
        Assert.assertEquals("Non-negative", zero);
        Assert.assertEquals("Non-negative", positive);
    }
}
