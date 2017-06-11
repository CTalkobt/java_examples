/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.example.java.general.generics;

/**
 *
 */
class GenericTest {
    public static void main(String[] args) {
        // Example: Diamond operator.
        // Note that use of generic type avoids chaving to create multiple classes.
        Parent<String> pStr = new Parent<>("String");
        Parent<Integer> pInt = new Parent<>(5);
        
        pStr.set("ABC");
//        pInt.set("abc"); // this will not compile - Incompatible types.
//        pStr.set(123); // Neither will this.
//
        System.err.println("pInt=" + pInt );
        System.err.println("pStr=" + pStr );
    }

}
