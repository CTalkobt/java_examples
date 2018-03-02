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
package net.ctalkobt.examples.junit.toSolve.simple;

/**
 *
 */
public class Calculator {
    public enum Ops { Multiply, Divide, Subtract, Add };
    
    public Double doOp(Ops op, Double num1, Double num2) {        
        switch (op) {
            case Add:
                return num1+num2;
            case Subtract:
                return num1 - num2;
            case Divide:
                return num1 / num2;
            case Multiply:
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }
}
