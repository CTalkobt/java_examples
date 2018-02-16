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

public class PackageMethod {
    private final Number n1;
    private final Number n2;
    private double result;

    public PackageMethod(Number d1, Number d2) {
        this.n1 = d1;
        this.n2 = d2;
    }

    public void doIt() {
        result = n1.doubleValue() / n2.doubleValue();
        System.err.println(internalOp(result));
    }


    /* package */ String internalOp(double result) {
        if (result < 0) {
            return "Negative";
        }
        return "Non-negative";
    }

}
