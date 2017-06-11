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

package net.ctalkobt.example.java.lambda.Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {

    static Integer doCalculate(Integer val1, Integer val2, BiFunction<Integer,Integer,Integer> fn) {
        return fn.apply(val1, val2);
    }
    
    static Integer doCalculate(Integer val1, Function<Integer,Integer> fn) {
        return fn.apply(val1);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Function<Integer,Integer> mathSquared = x -> x*x;
        BiFunction<Integer,Integer,Integer> mathPlus = (x,y) -> x+y;
        BiFunction<Integer,Integer,Integer> mathMinus = (x,y) -> x-y;
        
        System.err.println( "100 + 50 = " + doCalculate(100, 50, mathPlus));
        System.err.println( "100 - 50 = " + doCalculate(100, 50, mathMinus));
        System.err.println( "50 squared = " + doCalculate(50, mathSquared));
    }

}
