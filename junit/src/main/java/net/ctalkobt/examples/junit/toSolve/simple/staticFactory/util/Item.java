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
package net.ctalkobt.examples.junit.toSolve.simple.staticFactory.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Craig Taylor <ctalkobt@ctalkobt.net>
 */
public class Item {
    
    private long id;
    private String name;
    private final Collection<Item> subItems = new ArrayList<>();
    private Location currentLocation;
    
    public Item(long id, String name) {
        this.id = id;
        this.name = name;
        this.currentLocation = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Item subItem) {
        subItems.add(subItem);
    }
    
    public Collection<Item> getChildren() {
        return subItems;
    }
    
    public Location getCurrentLocation() {
        return currentLocation;
    }
    
    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }
}
