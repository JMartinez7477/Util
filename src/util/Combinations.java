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

    /**
     *
     * @param n the total length
     * @param r the number of items to choose
     * @return a set of all combinations of r ints on the range [0,n), in order
     */
    public static int[][] nChooser(int n, int r) {
        //find the length
        int big = Math.max(r, n - r);
        int small = Math.min(r, n - r);
        int len = 1;
        for (int i = n; i > big; i--) {
            len *= i;
        }
        len /= factorial(small);

        //construct bounds, answer, and current list
        int[][] ans = new int[len][r];
        int[] bases = new int[r];
        int[] roofs = new int[r];
        for (int i = 0; i < r; i++) {
            bases[i] = i;
            roofs[r - 1 - i] = n - 1 - i;
        }
        int[] cur = bases.clone();

        //solve
        int i = 0;
        while (i < len) {
            ans[i] = cur.clone();
            boolean carry = true;
            for (int j = r - 1; (j >= 0) && carry; j--) {       //add 1, starting all the way at the right
                cur[j]++;
                if (cur[j] > roofs[j]) {
                    carry = true;
                } else {
                    carry = false;
                    for (int k = 1; k + j < cur.length; k++) {  //reset nums to the right
                        cur[k + j] = cur[j] + k;
                    }
                }
            }
            i++;
        }
        return ans;
    }

    /**
     * 
     * @param n the total length
     * @param r the number of items to choose
     * @return  a set of all permutations of r ints on the range [0,n), not in order
     * 
     * This is different than nChooser in that order matters. This will return a longer set.
     */
    public static int[][] nPickr(int n, int r) {
        int len = 1;
        for (int i = n; i > (n - r); i--) {
            len *= i;
        }
        int[][] ans = new int[len][r];

        int[][] chosen = nChooser(n, r);
        int[][] combs = combos(r);

        //iterate over the different chosen sets
        for (int i = 0; i < chosen.length; i++) {
            int[] arr = chosen[i];  //the current set of numbers

            //iterate over the differnt combos
            for (int j = 0; j < combs.length; j++) {
                int[] curcomb = combs[j];   //the current ordering

                for (int k = 0; k < r; k++) {
                    ans[i * combs.length + j][k] = arr[curcomb[k]];
                }
            }
        }

        return ans;
    }

    //works for ints on the range [0, inf)
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     *
     * @param length the length of ints [0, length)
     * @return the set of all the ways an integer array of the form [0, 1, ...
     * length-1] can be arranged. Not sorted.
     */
    public static int[][] combos(int length) {
        if (length == 1) {
            return new int[][]{new int[]{0}};
        }
        int[][] ans = new int[factorial(length)][length];

        int[][] subans = combos(length - 1);
        //get the combo set that is inside this one that
        //will repeat similarly length times

        //go through each time the subset will repeat
        for (int i = 0; i < length; i++) {
            //go through the subset for this beginning number
            for (int j = 0; j < subans.length; j++) {
                ans[j + i * subans.length][0] = i;  //set the first num to this new sets num
                for (int k = 0; k < length - 1; k++) { //fill in subset
                    int sub = subans[j][k];
                    if (sub >= i) {
                        ans[j + i * subans.length][k + 1] = sub + 1;
                    } else {
                        ans[j + i * subans.length][k + 1] = sub;
                    }
                }
            }
        }
        return ans;
    }
}
