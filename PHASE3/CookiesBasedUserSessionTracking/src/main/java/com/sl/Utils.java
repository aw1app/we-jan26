package com.cl.utils;

import java.util.Random;

public class Utils {

    public static String createUserSessionIdentifier(){

        int randomNo = new Random().nextInt();

        return randomNo+"-session-str";
    }

}