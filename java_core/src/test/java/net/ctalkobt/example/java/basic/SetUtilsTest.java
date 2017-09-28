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

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetUtilsTest {
    private Set<String> setPeople = null; 
    private Set<String> setFemales = null; 
    private Set<String> setMales = null;
    
    @Before
    public void initialConfig() {
        setPeople = new HashSet<>(Arrays.asList("John", "Joe", "Jack", "Anne", "Abbie", "Angela"));
        setFemales = setPeople.stream().filter(name -> name.startsWith("A")).collect(Collectors.toSet());
        setMales = setPeople.stream().filter(name -> name.startsWith("J")).collect(Collectors.toSet());
    }
    
    @Test
    public void intersectTest() { 
        Set<String> intersect = new HashSet<>(setPeople); 
        intersect.retainAll(setFemales);
        Assert.assertEquals(setFemales, intersect);
    }
}
