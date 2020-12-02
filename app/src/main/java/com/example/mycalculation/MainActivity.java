package com.example.mycalculation;


import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String resultView = "";
    double num1 = 0;
    String ope = "+";
    changeNumber cn = new changeNumber();
    Input input = new Input();
    Calculation calculation = new Calculation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager wm = getWindowManager();

        Display disp = wm.getDefaultDisplay();
        String width = "Width=" + disp.getWidth();
        String height = "Height=" + disp.getHeight();

        System.out.println(width);

        System.out.println(height);

        setContentView(R.layout.activity_main);


        //textView
        TextView result = findViewById(R.id.resultTextView);
        TextView label = findViewById(R.id.label);
        result.setText("0");
        label.setText("10進数");
        //Button
        //number
        Button nine = findViewById(R.id.nine);
        Button eight = findViewById(R.id.eight);
        Button seven = findViewById(R.id.seven);
        Button six = findViewById(R.id.six);
        Button five = findViewById(R.id.five);
        Button four = findViewById(R.id.four);
        Button three = findViewById(R.id.three);
        Button two = findViewById(R.id.two);
        Button one = findViewById(R.id.one);
        Button zero = findViewById(R.id.zero);
        Button point = findViewById(R.id.point);

        //operator
        Button mul = findViewById(R.id.multiplication);
        Button div = findViewById(R.id.division);
        Button sub = findViewById(R.id.subtraction);
        Button add = findViewById(R.id.addition);
        Button clear = findViewById(R.id.clear);
        Button equal = findViewById(R.id.equal);

        //changeDecimal
        Button binary = findViewById(R.id.binary);
        Button octal = findViewById(R.id.octal);
        Button hexaDecimal = findViewById(R.id.hexadecimal);

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("9",resultView);
                result.setText(resultView);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("8",resultView);
                result.setText(resultView);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("7",resultView);
                result.setText(resultView);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("6",resultView);
                result.setText(resultView);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("5",resultView);
                result.setText(resultView);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("4",resultView);
                result.setText(resultView);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("3",resultView);
                result.setText(resultView);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("2",resultView);
                result.setText(resultView);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("1",resultView);
                result.setText(resultView);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input("0",resultView);
                result.setText(resultView);
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = input.input(".",resultView);
                result.setText(resultView);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = "0";
                num1 = 0;
                result.setText("0");
                label.setText("10進数");
            }
        });

        //計算処理
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(num1, Double.parseDouble(resultView));
                ope = "/";
                resultView = "0";
                result.setText(String.valueOf(num1));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(num1, Double.parseDouble(resultView));
                ope = "*";
                resultView = "0";
                result.setText(String.valueOf(num1));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(num1, Double.parseDouble(resultView));
                ope = "-";
                resultView = "0";
                result.setText(String.valueOf(num1));
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(num1, Double.parseDouble(resultView));
                ope = "+";
                resultView = "0";
                result.setText(String.valueOf(num1));
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation(num1,Double.parseDouble(resultView));
                resultView = "0";
                ope = "+";
                result.setText(String.valueOf(num1));
            }
        });

        binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = cn.binary(String.valueOf(result.getText()));
                num1 = 0;
                result.setText(resultView);
                resultView = "";
                label.setText("2進数");
            }
        });
        octal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = cn.octal(String.valueOf(result.getText()));
                num1 = 0;
                result.setText(resultView);
                resultView = "";
                label.setText("8進数");
            }
        });
        hexaDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = cn.hexadecimal(String.valueOf(result.getText()));
                num1 = 0;
                result.setText(resultView);
                resultView = "";
                label.setText("16進数");
            }
        });
    }



    public double operation(double n1, double n2){
        System.out.println(n1 + ":" + n2);
        switch (ope){
            case "+":
                num1 = calculation.addition(n1, n2);
                break;
            case "-":
                num1 = calculation.subtraction(n1, n2);
                break;
            case "*":
                num1 = calculation.multiplication(n1, n2);
                break;
            case "/":
                num1 = calculation.division(n1, n2);
                break;
        }
        System.out.println("=" + num1);
        return num1;
    }



}