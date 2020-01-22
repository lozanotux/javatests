package com.softtek.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("Negative times not allowed");
        }

        String result = "";

        for (int i = 0; i < times; i++) {
            result += str;
        }

        return result;
    }

    public static boolean isEmpty(String str) {
        String EMPTY = "";
        str = str.trim();
        if ((str == null) || (str.isEmpty()) || (str.length() == 0) || (EMPTY.equals(str))) {
            return true;
        } else {
            return false;
        }
    }

}
