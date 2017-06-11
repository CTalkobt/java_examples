/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.example.java.general.generics;

/**
 * Example parent class w/ Generic types.
 * @param <T>
 */
public class Parent<T> {
    T value;
    
    public Parent(T value) {
        this.value = value;
    }
    
    public void set(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Parent:[" + value + "]";
    }
}
