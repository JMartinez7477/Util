/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author S531749
 */
public class StringManipulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[s.length() - 1 - i];
            chars[s.length() - 1 - i] = temp;
        }
        String finished = "";
        for (int i = 0; i < chars.length; i++) {
            finished += chars[i];
        }
        return finished;
    }

    public static boolean isPalindrome(String in) {
        String reversed = reverseString(in);
        return in.equals(reversed);
    }

    
    /**
     * 
     * @param in the String that will be manipulated
     * @param indexGap how many indexes to skip when choosing the next letter
     *Takes every Nth letter of String in and puts it into a String.
     *If the Nth letter index is greater than the String length, it subtracts
     *the length from the index till the index works. 
     */
    public static String stringFromIndexGaps(String in, int indexGap) {
        String toReturn = "";
        int length = in.length();
        for (int i = 0; i < length; i++) {
            int index = i * indexGap;
            while (index >= length) {
                index -= length;
            }
            toReturn += (in.charAt(index));
        }
        return toReturn;
    }

    public static int[] numberOfEachLetter(String in) {
        int[] times = new int[26];
        in = in.toUpperCase();
        char[] chars = in.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            for (int j = 65; j < 91; j++) {
                if (aChar == j) {
                    int index = j - 65;
                    times[index]++;
                }
            }
        }
        return times;
    }

    //uppercase characters only
    public static String charToMorse(char c) {
        int index = c - 65;
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."};
        return morse[index];
    }

}
