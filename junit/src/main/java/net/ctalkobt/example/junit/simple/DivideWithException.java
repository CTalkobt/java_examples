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

public class DivideWithException extends Divider {

    public DivideWithException(Number n1, Number n2) {
        super(n1, n2);
    }

    public double divide() {
        if (Math.abs(n2.doubleValue()) < 0.000000001d) {
            throw new IllegalArgumentException("Division by zero exception");
        }
        return super.divide();
    }
    

}
