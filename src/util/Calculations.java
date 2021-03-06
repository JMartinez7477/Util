/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigInteger;
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

    }

    /**
     * A numerator and denominator can be divided by their gcf to get the
     * simplified fraction
     */
    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static int gcd(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int lcm(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = lcm(result, input[i]);
        }
        return result;
    }

    public static double[] findLine(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y2 - (m * x2);
        double[] info = {m, b};
        return info;
    }
    
    /*
     * 
     * @return maps the value val from the range x1 to y1, to x2 to y2
     * Example: float value = map(110, 0, 100, -20, -10) = -9
     */
    public static double map(double val, double x1, double y1, double x2, double y2){
        if(x2-x1 == 0)return 0;
        return ((y2 - y1) / (x2 - x1)) * (val - x1) + y1;
    }

    public static double mean(double[] numbers) {
        double total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return (total / numbers.length);
    }

    public static double median(double[] numbers) {
        ArrayList<Double> nums = new ArrayList<Double>();
        for (int i = 0; i < numbers.length; i++) {
            nums.add(numbers[i]);
        }
        Collections.sort(nums);
        int half = nums.size() / 2;
        if (nums.size() % 2 == 0) {
            return (nums.get(half - 1) + nums.get(half)) / 2;
        } else {
            return nums.get(half - 1);
        }
    }

    public static double range(double[] numbers) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return max - min;
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

    public static double limit(double val, double low, double high) {
        if (val > high) {
            return high;
        }
        if (val < low) {
            return low;
        }
        return val;
    }
}
