package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: HKZ
 * @Date: 2020/2/15 8:18
 * @Description:
 */
public class test3 {

    public static void main (String[] args){
        Pattern pattern = Pattern.compile("^[0-2]\\d{0,9}$");
        Matcher matcher = pattern.matcher("999");
        System.out.println(matcher.matches());
    }
}
