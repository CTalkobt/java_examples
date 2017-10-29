/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.examples.eipexamplelib;

import java.io.Serializable;

/**
 *
 */
public class Item implements Serializable {

    private static final long serialVersionUID = 1299644189170013527L;
    public enum ItemType {
        Immaterial,
        Useless,
        Incorporeal,
        Worthless,
        Illegal,
        BugRidden,
        GovermentBureaucracy
    }
    
    public static final Item PIECE_OF_PAPER = new Item("Piece Of Paper (1 Sheet)", ItemType.Useless, 1, 1);
    public static final Item REAM_OF_PAPER = new Item("Ream of Paper", ItemType.BugRidden, 450, 1);
    public static final Item PLANET_EARTH = new Item("Planet Earth", ItemType.Useless, Integer.MAX_VALUE-1, 1);
    
    private final String name;
    private final ItemType type;
    private final long costInCents;
    private final int quantity;

    public Item(String name, ItemType type, long costInCents, int quantity) {
        this.name = name;
        this.type = type;
        this.costInCents = costInCents;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public long getCostInCents() {
        return costInCents;
    }
    
    public double getCost() {
        return costInCents / 100.0;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
}
