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
package net.ctalkobt.examples.junit.toSolve.simple.answer;


import net.ctalkobt.examples.junit.toSolve.simple.Calculator;
import net.ctalkobt.examples.junit.toSolve.simple.Calculator.Ops;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class CalculatorTest {

    private Calculator instance;
    
    public CalculatorTest() {
    }
    
    @Before
    public void setUp() {
        instance = new Calculator();
    }
    
    @Test
    public void doOp_multiple() {
        Double num1 = 8.0D;
        Double num2 = 2.0D;
        Double expected = num1*num2;
        
        Double result = instance.doOp(Ops.Multiply, num1, num2);
        Assert.assertEquals("Multiply doesn't work", expected, result);
    }
    
    @Test
    public void doOp_divide() {
        Double num1 = 8.0D;
        Double num2 = 2.0D;
        Double expected = num1/num2;
        
        Double result = instance.doOp(Ops.Divide, num1, num2);
        Assert.assertEquals("Divide doesn't work", expected, result);    }
    
    @Test
    public void doOp_divideByZero() {
        Double num1 = 8.0D;
        Double num2 = 0.0D;
        Double expected = num1/num2;
        
        Double result = instance.doOp(Ops.Divide, num1, num2);
        Assert.assertEquals("Divide by zero doesn't work", expected, result);    
        Assert.assertTrue(result.isInfinite());
    }
    

    @Test
    public void doOp_add() {
        Double num1 = 2.0D;
        Double num2 = 3.0D;
        Double expected = num1+num2;
        
        Double result = instance.doOp(Ops.Add, num1, num2);
        Assert.assertEquals("Add doesn't work", expected, result);    
    }

    @Test
    public void doOp_sub() {
        Double num1 = 2.0D;
        Double num2 = 3.0D;
        Double expected = num1-num2;
        
        Double result = instance.doOp(Ops.Subtract, num1, num2);
        Assert.assertEquals("Subtract doesn't work", expected, result);            
    }
    
    /** What other test should there be? */
    @Test(expected = NullPointerException.class)
    public void doOp_null() {
        Double num1 = 2.0D;
        Double num2 = 3.0D;
        
        Double result = instance.doOp(null, num1, num2);        
    }
    
}
