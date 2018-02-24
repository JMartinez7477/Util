/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;

/**
 *
 * @author S531749
 */
public class DataManipulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static int[] timesInArray(ArrayList<Integer> info, int[] options){
        int[] timesRepeated = new int[options.length];
        for (int num : info) {
            for (int i = 0; i < options.length; i++) {
                int option = options[i];
                if(option == num){
                    timesRepeated[i]++;
                }
            }
        }
        return timesRepeated;
    } 
    
}
