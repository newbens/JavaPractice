package com.niuben.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String address = getAddress();
        System.out.println(address);
    }

    public static String getAddress() {
        String s="zhieasy <zhieasy@163.com>";
        Pattern p=Pattern.compile("[a-zA-Z0-9_]{3,20}@[a-zA-Z0-9]{2,10}[.](com|cn|org)");
        Matcher matcher = p.matcher(s);
        String res = "";
        while (matcher.find()) {
            res = (s.substring(matcher.start(),matcher.end()));
        }
        return res;
    }
}
