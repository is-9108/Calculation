package com.example.mycalculation;

public class Calculation {
    public double addition(double n1, double n2){

        return n1 + n2;
    }

    public double subtraction(double n1, double n2){
        if(n1 == 0){
            return n2;
        }else{
            return n1 - n2;
        }
    }

    public double multiplication(double n1, double n2){
        if(n1 == 0){
            return n2;
        }else {
            return n1 * n2;
        }
    }

    public double division(double n1, double n2){
        if(n1 == 0){
            return n2;
        }else {
            return n1 / n2;
        }

    }

}
