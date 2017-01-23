package com.dvt.computer3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView ans;
    private EditText az,ax;
    private Button btn1,btn2,btn3,btn4,btn0;
    private int w=0,r=0,result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = az.getText().toString();
                String d = ax.getText().toString();
                w = Integer.parseInt(s);
                r = Integer.parseInt(d);
                result = w + r;
                String ert = String.valueOf(result);
                ans.setText(ert);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=az.getText().toString();
                String d=ax.getText().toString();
                w=Integer.parseInt(s);
                r=Integer.parseInt(d);
                result=w-r;
                String ert=String.valueOf(result);
                ans.setText(ert);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=az.getText().toString();
                String d=ax.getText().toString();
                w=Integer.parseInt(s);
                r=Integer.parseInt(d);
                result=w*r;
                String ert=String.valueOf(result);
                ans.setText(ert);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=az.getText().toString();
                String d=ax.getText().toString();
                w=Integer.parseInt(s);
                r=Integer.parseInt(d);
                result=w/r;
                String ert=String.valueOf(result);
                ans.setText(ert);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText("0");
            }
        });





    }


    private void findview(){
        az=(EditText)findViewById(R.id.editText);
        ax=(EditText)findViewById(R.id.editText2);
        ans=(TextView)findViewById(R.id.textView3);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn0=(Button)findViewById(R.id.button5);
    }




}
