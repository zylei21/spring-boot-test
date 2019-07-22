package com.cibei.springboot;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/04 16:45
 */
public class SortBy {
    public static int compare(String s1,String s2){
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        return s1.compareTo(s2);
    }
}
