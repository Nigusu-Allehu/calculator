package com.example.sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String value="";
    EditText field;
    Button zero, one, two, three, four, five, six, seven, eight, nine, point;
    Button plus, times, divide, minus, equals, back_space;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    startButtons();
    }
    public  void startButtons(){
        field= (EditText) findViewById(R.id.field);
        field.setKeyListener(null);
        zero=(Button) findViewById(R.id.zero);
        one=(Button) findViewById(R.id.one);
        two=(Button) findViewById(R.id.two);
        three=(Button) findViewById(R.id.three);
        four=(Button) findViewById(R.id.four);
        five=(Button) findViewById(R.id.five);
        six=(Button) findViewById(R.id.six);
        seven=(Button) findViewById(R.id.seven);
        eight=(Button) findViewById(R.id.eight);
        nine=(Button) findViewById(R.id.nine);
        point=(Button) findViewById(R.id.point);
        equals=(Button) findViewById(R.id.equals);
        plus=(Button) findViewById(R.id.plus);
        minus=(Button) findViewById(R.id.minus);
        times=(Button) findViewById(R.id.times);
        divide=(Button) findViewById(R.id.division);
        back_space=(Button) findViewById(R.id.back_space);

        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="1";
                field.setText(value);
            }});
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="2";
                field.setText(value);
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="3";
                field.setText(value);
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="4";
                field.setText(value);
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="5";
                field.setText(value);
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="6";
                field.setText(value);
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="7";
                field.setText(value);
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="8";
                field.setText(value);
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="9";
                field.setText(value);
            }
        });
        point.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+=".";
                field.setText(value);
            }
        });
        plus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="+";
                field.setText(value);
            }
        });
        minus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="-";
                field.setText(value);
            }
        });
        times.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="x";
                field.setText(value);
            }
        });
        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="/";
                field.setText(value);
            }
        });
        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                value+="0";
                field.setText(value);
            }
        });
        back_space.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (value.length()>=1){
                value= value.substring(0,value.length()-1);}
                field.setText(value);
            }
        });
        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (value.length()>=1){
                field.setText(calculator(value));}
                value=calculator(value);
            }
        });




    }
    public  String  calculator(String s){
        if (s.charAt(0)=='+' || s.charAt(0)=='-'){
            return calculator("0"+s);
        }
        String current="";
        int index=0;
        while (index<s.length()){
            if ((s.charAt(index)=='+' || s.charAt(index)=='-')&&(Character.isDigit(s.charAt(index-1)) || index==0)){

                if (s.charAt(index)=='+') return Float.toString(Float.parseFloat(multiplier(current))+ Float.parseFloat(calculator(s.substring(index+1))));
                if (s.charAt(index)=='-')return Float.toString(Float.parseFloat(multiplier(current))- Float.parseFloat(calculator(s.substring(index+1))));
            }
            else{
                current+=s.charAt(index);
            }
            index+=1;
        }
        return multiplier(current);


    }
    public String multiplier(String s){

        String current="";
        int index=0;
        while (index<s.length()){
        if (s.charAt(index)=='x' || s.charAt(index)=='/'){


           if (s.charAt(index)=='x') return Float.toString(Float.parseFloat(current)* Float.parseFloat(multiplier(s.substring(index+1))));
           if (s.charAt(index)=='/')return Float.toString(Float.parseFloat(current)/ Float.parseFloat(multiplier(s.substring(index+1))));
        }
        else{
            current+=s.charAt(index);
        }
        index+=1;
        }

        return clear(s);


    }
public static String clear(String s){
      int  minuses=0;
      int index=0;
      for (int i=0; i<s.length();i++){
          if(s.charAt(i)=='-'){
              minuses+=1;
          }

          else if(Character.isDigit(s.charAt(i))){
              index =i;
              break;
          }
      }
      if(minuses%2==0){
          return "+"+s.substring(index);
      }else {
          return "-"+s.substring(index);
      }

}

}
