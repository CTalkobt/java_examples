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

package net.ctalkobt.example.junit.simple;

import org.junit.Assert;
import org.junit.Test;

public class DivideWithExceptionTest {
    @Test
    public void divideTestNormal() {
        Divider instance = new DivideWithException(6, 2);
        Assert.assertEquals(3.0D, instance.divide(), 0.00001D);
    }

    @Test
    public void divideByZero() {
        try {
            Divider instance = new DivideWithException(6, 0);
            double result = instance.divide();
            Assert.assertFalse(false); // should never have reached here.
        } catch(IllegalArgumentException ex) {
            Assert.assertTrue(true);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideByZeroPreferred() {
        Divider instance = new DivideWithException(6, 0);
        double result = instance.divide();
        Assert.assertTrue(Double.isInfinite(result));
    }
    
}
