/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.examples.eipexamplelib;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 7290899436210068793L;
    public enum OrderType { 
        Faxed,
        Emailed, 
        Telepathy,
        GovermentBribe,
        MoneyLaundering
    }
    
    private final Person from;
    private final Person to;
    private final List<Item> items;

    public static final Order MJ_MJ_PAPER = new Order(Person.MARY_JOE, Person.MARY_JOE, 
        Arrays.asList(Item.PIECE_OF_PAPER, Item.REAM_OF_PAPER));
    
    public Order(Person from, Person to, List<Item> items) {
        this.from = from;
        this.to = to;
        this.items = items;
    }

    public Person getFrom() {
        return from;
    }

    public Person getTo() {
        return to;
    }

    public List<Item> getItems() {
        return items;
    }

    
}
