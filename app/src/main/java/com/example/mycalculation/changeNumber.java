package com.example.mycalculation;

import java.util.regex.Pattern;

public class changeNumber {
    String number = "";
    public String  binary(String num){
        searchPoint(num);
        String result = Integer.toBinaryString(Integer.valueOf(number));
        return result;
    }

    public String octal(String num){
        searchPoint(num);
        String result = Integer.toOctalString(Integer.valueOf(number));
        return result;
    }

    public String hexadecimal(String  num){
        searchPoint(num);
        String result = Integer.toHexString(Integer.valueOf(number));

        return result;
    }

    public void searchPoint(String num){
        //小数点で２つに分ける
        if(num.contains(".")){
            Pattern pa = Pattern.compile(".");
            String[] tokens = pa.split(num);

            String integer = tokens[0];
            String decimal = tokens[1];

            System.out.println("integer:" + integer);
            System.out.println("decimal:" + decimal);

            number = integer;
        }else{
            number = num;
        }

    }

}
