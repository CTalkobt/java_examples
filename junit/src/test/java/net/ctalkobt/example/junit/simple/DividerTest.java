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

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Ignore;

/**
 *
 * @author Craig Taylor <ctalkobt@ctalkobt.net>
 */
public class DividerTest {

    private Divider instance;
    
    public DividerTest() {
    }
    
    @Test
    // Note: method names should be more explicit in what they're testing.
    public void testDivide_1() {
        Divider d = new Divider(10,2); 
        Assert.assertEquals(5.0d, d.divide(), 0.00001);
    }
    
    @Before
    public void setUp() {
        instance = new Divider(10, 5);
    }

    /**
     * Test of divide method, of class Divider.
     */
//    @Ignore
    @Test
    public void testDivide_2() {
        
        Assert.assertEquals(2.0D, instance.divide(), 0.0001D);
    }
    
}
