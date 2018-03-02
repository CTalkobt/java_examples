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
package net.ctalkobt.examples.junit.toSolve.simple.complex.util;

import java.util.Collection;

/**
 * This DAO does nothing except to throw exceptions.
 * @param <T>
 */
public class BadDAO<T> {
   public T get(long id) {
        throw new IllegalStateException("I'm a class which doesnt do anything.");
    }
    
    public Collection<T> getAll() {
        throw new IllegalStateException("I'm a class which doesnt do anything.");
    }
    
    public void save(T value) {
        throw new IllegalStateException("I'm a class which doesnt do anything.");
    }
    
}
