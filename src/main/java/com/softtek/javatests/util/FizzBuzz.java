package com.softtek.javatests.util;

public class FizzBuzz {

    public static String fizzBuzz(int n) {

        if ((n % 3 != 0) || (n % 5 != 0)) {
            if (n % 3 == 0) {
                return "Fizz";
            } else if (n % 5 == 0) {
                return "Buzz";
            } else {
                return String.valueOf(n);
            }
        } else {
            return "FizzBuzz";
        }

    }
}
