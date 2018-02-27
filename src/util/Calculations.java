/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author S531749
 */
public class Calculations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double[] numbers = {15,3,3,4};
        System.out.println(mean(numbers));
        System.out.println(median(numbers));
        System.out.println(range(numbers));
    }
    
    public static int[] simplifyFraction(int num, int denom) {
        boolean keepGoing = true;
        int curNum = num;
        int curDenom = denom;

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        while (keepGoing == true) {
            boolean madeChange = false;
            for (int i = (primes.length - 1); i >= 0; i--) {
                if ((curNum % primes[i] == 0) && (curDenom % primes[i] == 0)) {
                    curNum /= primes[i];
                    curDenom /= primes[i];
                    madeChange = true;
                }

            }
            keepGoing = madeChange;
        }
        int[] good = new int[2];
        good[0] = curNum;
        good[1] = curDenom;
        return good;
    }

    public static int lcmHard(int a, int b) {
        int lcm = -1;
        int x = 0;
        int y = 0;
        Outer:
        for (int i = 1; i < 10000; i++) {
            x = i * a;
            for (int j = 1; j < 10000; j++) {
                y = j * b;
                if (y > x) {
                    break;
                }
                if (x == y) {
                    lcm = x;
                    break Outer;
                }
            }
        }
        return lcm;
    }
    
    public static int lcm(int[] nums) {
        int n = 1;
        int min = nums[0];
        for (int i : nums) {
            if (i > min) {
                min = i;
            }
        }
        for (int i = 2; i <= min; i++) {
            boolean hasmult = false;
            for (int k = 0; k < nums.length; k++) {
                if (nums[k] % i == 0) {
                    nums[k] /= i;
                    if (!hasmult) {
                        n *= i;
                        hasmult = true;
                    }
                }
            }
            if (hasmult) {
                i = 2;
            }
        }
        for (int i : nums) {
            n *= i;
        }
        return n;

    }
    
    public static double[] findLine(double x1, double y1, double x2, double y2){
        double m = (y2-y1)/(x2-x1);
        double b = y2 - (m*x2);
        double[] info = {m,b};
        return info;
    }
    
    public static double distanceBetweenPoints(double x1, double y1, double x2, double y2){
         return Math.hypot(x2-x1,y2-y1);
    }

    public static double mean(double[] numbers){
        double total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i]; 
        }
        return (total/numbers.length);
    }
    
    public static double median(double[] numbers){
        ArrayList<Double> nums = new ArrayList<Double>();
        for (int i = 0; i < numbers.length; i++) {
            nums.add(numbers[i]);
        }
        Collections.sort(nums);
        int half = nums.size()/2;
        if(nums.size()%2 == 0){
            return (nums.get(half-1) + nums.get(half))/2;
        }else{
            return nums.get(half-1);
        }
    }
    
    public static double range(double[] numbers){
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > max){
                max = numbers[i];
            }
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return max-min;
    }
    
    public static int limit(int val, int low, int high) {
        if (val > high) {
            return high;
        }
        if (val < low) {
            return low;
        }
        return val;
    }
}
