/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ctalkobt.example.java.general.tryWithResources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 */
public class TryResourcesExample {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/duck/tryResources.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.err.println(">> " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
