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

package net.ctalkobt.example.java.basic;

import org.junit.Test;

/**
 *
 */
public class IfExample {
    @Test
    public void ifExample() { 
        int valueA = 100;
        int value100 = 100;
        
        if (valueA == value100) { 
            System.err.println("IfExample: ValueA is 100");
        }
    }
    
    @Test
    public void ifElseExample() {
        int valueB = 42;
        int value42 = 42;
        
        if (valueB == 100) {
            System.err.println("IfElseExample: ValueB is 100");
        } else if (valueB == value42) { 
            System.err.println("IfElseExample: ValueB is 42");
        }
    }

}
