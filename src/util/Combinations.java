/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.TreeSet;

/**
 *
 * @author S531749
 */
public class Combinations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    /**
     * @param a the set of characters 
     * @param k the current index of the character to get. Starts at 0
     * @param length how many characters the combinations should be
     * @param options the number of options 
     * 
     * Make sure the TreeSet combos is declared outside of this method
     */
    public static void allCombos(char[] a, int k, int length, int options) {
        //make this TreeSet outside of method 
        TreeSet combos = new TreeSet();
        if (k == length) {
            String current = "";
            for (int i = 0; i < length; i++) {
                current += a[i];
            }
            combos.add(current);
        } else {
            for (int i = k; i < options; i++) {
                char temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                allCombos(a, k + 1, length, options);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
    
}
