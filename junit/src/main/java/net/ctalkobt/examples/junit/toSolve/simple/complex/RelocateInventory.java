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
package net.ctalkobt.examples.junit.toSolve.simple.complex;

import net.ctalkobt.examples.junit.toSolve.simple.staticFactory.util.BadDAO;
import net.ctalkobt.examples.junit.toSolve.simple.staticFactory.util.Container;
import net.ctalkobt.examples.junit.toSolve.simple.staticFactory.util.Item;
import net.ctalkobt.examples.junit.toSolve.simple.staticFactory.util.Location;

public class RelocateInventory {
    
    protected BadDAO<Item> itemDAO = new BadDAO<>();
    private Location sanFran;
    private Location dallas;
    private Container box;
    private Container flatBed;
    
    public void setItemDAO(BadDAO<Item> dao) {
        this.itemDAO = dao;
    }
    
    public void currentState() {        
        sanFran = new Location(1, "San Francisco");
         dallas = new Location(2, "Dallas");
        
        // Assemble a box full of items.
        box = new Container(100, "Box1");
        box.add(new Item(101, "magic flute"));
        box.add(new Item(102, "magic lamp"));
        box.add(new Item(103, "floating rug"));
        box.add(new Item(104, "100 gold pieces"));

        // Add the box to a flat bead. 
        flatBed = new Container(102, "ID #42");
        flatBed.add(box);
    }
    
    public void relocateInventory() {                
        moveItems(flatBed, sanFran);
        moveItems(flatBed, dallas);
    }
    
    private void moveItems(Item container, Location source) {
        for (Item item : container.getChildren()) {
            item.setCurrentLocation(source);
            itemDAO.save(item);
            moveItems(item, source);
        }
    }    
    
    public static void main(String[] args) {
        RelocateInventory ri = new RelocateInventory();
        ri.currentState();
        ri.relocateInventory();
    }

}
