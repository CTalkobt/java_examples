/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ctalkobt.example.java.general.stringSwitch;

/**
 *
 */
public class StringSwitchExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String color = "blue";

        System.err.println("For : " + color);
        switch (color) {
            case "blue":
                System.err.println("**BLUE**");
                break;
            case "red":
                System.err.println("**RED**");
                break;
            case "green":
                System.err.println("**GREEN**");
                break;
            default:
                System.err.println("Unknown");
                break;
        }

    }
}
