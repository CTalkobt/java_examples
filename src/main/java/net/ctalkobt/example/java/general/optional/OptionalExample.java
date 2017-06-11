/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.example.java.general.optional;

import java.util.Optional;

/**
 *
 */
public class OptionalExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Optional<String> test = myFunction("one");

        Integer value = test
                .map(Integer::parseInt)
                .orElse(-1);
        
        System.err.println("Output: " + value);
        System.err.println("Type:" + value.getClass());
    }

    private static Optional myFunction(String parm) {
        if (!parm.equals("one")) {
            return Optional.empty();
        }
        return Optional.of("2");
    }

}
