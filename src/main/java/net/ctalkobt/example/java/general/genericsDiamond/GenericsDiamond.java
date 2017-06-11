/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ctalkobt.example.java.general.genericsDiamond;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class GenericsDiamond {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Long prior duplicated form.
        List<Integer> int1 = new ArrayList<Integer>();
        System.err.println(int1);                           // 
        
        // New shorter format using the <> "diamond" operator to automaticaly 
        // use the inferred type.
        List<Integer> int2 = new ArrayList<>();
        
        Map<String, List<Integer>> mapExample = new HashMap<>();
        mapExample.put("abc", int2);
    }

}
