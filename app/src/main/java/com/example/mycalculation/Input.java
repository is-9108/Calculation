package com.example.mycalculation;

public class Input {
    public String input(String n,String num){
        String result = "";
        if(num.contains(".")){
            if(n == "."){
                System.out.println("エラー");
                result = num;
            }else {
                result = num + n;
                System.out.println("aa");
            }
        }else{
            if(num == "0"){
                if(n == "."){
                    result = num + n;
                }else {
                    result = n;
                }
            }else{
                result = num + n;
            }
        }

        return result;
    }

}
