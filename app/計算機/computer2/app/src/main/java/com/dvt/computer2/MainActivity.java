package com.dvt.computer2;

import android.renderscript.Int2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private TextView ans1,ans2;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btna,btns,btnd,btnf,btng,btnfinish;
    private TextView ans;
    private String d="";
    private int s=0,aks=0;
    private char apso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        int result=0;

//        switch(apso){
//            case '+':
//                result =aks + Integer.parseInt(ans1.getText().toString());
//                break;
//            case '-':
//                result =aks - Integer.parseInt(ans1.getText().toString());
//                break;
//            case '*':
//                result =aks * Integer.parseInt(ans1.getText().toString());
//                break;
//            case '/':
//                result =aks / Integer.parseInt(ans1.getText().toString());
//                break;
//        }
//        ans2.setText(String.valueOf(result));


        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=0;
                d+=s;
                ans1.setText(d);

            }
        });

       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               s=1;
               d+=s;
               ans1.setText(d);
           }
       });
       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               s=2;
               d+=s;
               ans1.setText(d);

           }
       });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=3;
                d+=s;
                ans1.setText(d);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=4;
                d+=s;
                ans1.setText(d);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=5;
                d+=s;
                ans1.setText(d);

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=6;
                d+=s;
                ans1.setText(d);

            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=7;
                d+=s;
                ans1.setText(d);

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=8;
                d+=s;
                ans1.setText(d);

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=9;
                d+=s;
                ans1.setText(d);

            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=0;
                d+=s;
                ans1.setText(d);

            }
        });
        btng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans1.setText("");
                ans2.setText("");
            }
        });
    }






    private void findView(){
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button4);
        btn3=(Button)findViewById(R.id.button5);
        btn4=(Button)findViewById(R.id.button9);
        btn5=(Button)findViewById(R.id.button10);
        btn6=(Button)findViewById(R.id.button2);
        btn7=(Button)findViewById(R.id.button6);
        btn8=(Button)findViewById(R.id.button7);
        btn9=(Button)findViewById(R.id.button3);
        btn0=(Button)findViewById(R.id.button11);
        btna=(Button)findViewById(R.id.button8);//+
        btns=(Button)findViewById(R.id.button12);//-
        btnd=(Button)findViewById(R.id.button13);//*
        btnf=(Button)findViewById(R.id.button14);// /
        btng=(Button)findViewById(R.id.button15);//ce
        btnfinish=(Button)findViewById(R.id.button16);
        ans1=(TextView)findViewById(R.id.textView);
        ans2=(TextView)findViewById(R.id.textView2);
    }




}



