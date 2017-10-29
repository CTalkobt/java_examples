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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ListIteratorExample {
    private ArrayList<String> myList;

    @Before
    public void initialSetup() {
        myList = new ArrayList<>();
        myList.addAll(Arrays.asList("A", "E", "I", "O", "U", "Y"));
    }

    @Test
    public void reverseListIterator() {
        ListIterator<String> iterRev = myList.listIterator(myList.size());

        int index=myList.size();
        while (iterRev.hasPrevious()) {
            index--;
            String value = iterRev.previous();
            Assert.assertEquals("Value doesn't match.", myList.get(index), value);
            System.err.print(value);
        }
        System.err.println();
    }
}
