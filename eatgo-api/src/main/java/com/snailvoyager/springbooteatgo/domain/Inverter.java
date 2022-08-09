package com.snailvoyager.springbooteatgo.domain;

public class Inverter {

    public static String invert(String arg) {
        if (arg == null)
            return "";
        StringBuilder result = new StringBuilder(arg);

        return result.reverse().toString();
    }
}
