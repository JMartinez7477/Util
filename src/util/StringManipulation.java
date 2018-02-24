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
    
    public static String stringFromIndexGaps(String in, int indexGap){
        String toReturn = "";
        int length = in.length();
        for (int i = 0; i < length; i++) {
            int index = i*indexGap;
            while(index>=length){
                index -= length;
            }
            toReturn += (in.charAt(index));
        }
        return toReturn;        
    }
    
}
