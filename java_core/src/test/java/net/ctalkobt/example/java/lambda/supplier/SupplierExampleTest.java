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

package net.ctalkobt.example.java.lambda.supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Assert;

public class SupplierExampleTest {
    private static final Logger LOG = Logger.getLogger(SupplierExampleTest.class);

    @Test
    public void testSupplier() {
        Iterator<Integer> itInts = Arrays.asList(1, 2, 3, 4, 5).iterator();
        Supplier<Integer> supplier = itInts::next;
        
        List<Integer> empty = new ArrayList<>();
        for (int i=1; i<=5; i++) {
            Integer result = empty.stream().findFirst().orElseGet(supplier);
            Assert.assertEquals((Integer) i, result); 
            LOG.debug(">> " + result);
        }
        
    }

}
