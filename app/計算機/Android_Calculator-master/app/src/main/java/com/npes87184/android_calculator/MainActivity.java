package com.npes87184.android_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btn10;
    private Button btnC;
    private Button btnPlus;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private Button btnAbout;
    private Button btnEqu;
    private TextView bar;
    private boolean flag = false;
    private boolean contiOper = false;
    private char lastOperate;
    private int lastNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private Button.OnClickListener bltisener = new Button.OnClickListener() {
        @Override
        public void onClick(View V) {
            switch (V.getId()) {
                case R.id.button10:
                    if(bar.getText().toString().length()==1) {
                        bar.setText("0");
                    } else {
                        bar.setText(bar.getText().toString().substring(0, bar.getText().toString().length() - 1));
                    }
                    break;
                case R.id.buttonC:
                    bar.setText("0");
                    break;
                case R.id.buttonAbout:
                    break;
                case R.id.buttonPlus:
                    if(contiOper) {
                        int result = 0;
                        switch (lastOperate) {
                            case '+':
                                result = lastNum + Integer.parseInt(bar.getText().toString());
                                break;
                            case '-':
                                result = lastNum - Integer.parseInt(bar.getText().toString());
                                break;
                            case '*':
                                result = lastNum * Integer.parseInt(bar.getText().toString());
                                break;
                            case '/':
                                result = lastNum / Integer.parseInt(bar.getText().toString());
                                break;
                            default:
                                break;
                        }
                        lastNum = result;
                        bar.setText(String.valueOf(result));
                        contiOper = false;
                    } else {
                        contiOper = true;
                        lastNum = Integer.parseInt(bar.getText().toString());
                        bar.setText("0");
                    }
                    lastOperate = '+';
                    flag = true;
                    break;
                case R.id.buttonSubtract:
                    if(contiOper) {
                        int result = 0;
                        switch (lastOperate) {
                            case '+':
                                result = lastNum + Integer.parseInt(bar.getText().toString());
                                break;
                            case '-':
                                result = lastNum - Integer.parseInt(bar.getText().toString());
                                break;
                            case '*':
                                result = lastNum * Integer.parseInt(bar.getText().toString());
                                break;
                            case '/':
                                result = lastNum / Integer.parseInt(bar.getText().toString());
                                break;
                            default:
                                break;
                        }
                        lastNum = result;
                        bar.setText(String.valueOf(result));
                        contiOper = false;
                    } else {
                        contiOper = true;
                        lastNum = Integer.parseInt(bar.getText().toString());
                        bar.setText("0");
                    }
                    lastOperate = '-';
                    flag = true;
                    break;
                case R.id.buttonMul:
                    if(contiOper) {
                        int result = 0;
                        switch (lastOperate) {
                            case '+':
                                result = lastNum + Integer.parseInt(bar.getText().toString());
                                break;
                            case '-':
                                result = lastNum - Integer.parseInt(bar.getText().toString());
                                break;
                            case '*':
                                result = lastNum * Integer.parseInt(bar.getText().toString());
                                break;
                            case '/':
                                result = lastNum / Integer.parseInt(bar.getText().toString());
                                break;
                            default:
                                break;
                        }
                        lastNum = result;
                        bar.setText(String.valueOf(result));
                        contiOper = false;
                    } else {
                        contiOper = true;
                        lastNum = Integer.parseInt(bar.getText().toString());
                        bar.setText("0");
                    }
                    lastOperate = '*';
                    flag = true;
                    break;
                case R.id.buttonDiv:
                    if(contiOper) {
                        int result = 0;
                        switch (lastOperate) {
                            case '+':
                                result = lastNum + Integer.parseInt(bar.getText().toString());
                                break;
                            case '-':
                                result = lastNum - Integer.parseInt(bar.getText().toString());
                                break;
                            case '*':
                                result = lastNum * Integer.parseInt(bar.getText().toString());
                                break;
                            case '/':
                                result = lastNum / Integer.parseInt(bar.getText().toString());
                                break;
                            default:
                                break;
                        }
                        lastNum = result;
                        bar.setText(String.valueOf(result));
                        contiOper = false;
                    } else {
                        contiOper = true;
                        lastNum = Integer.parseInt(bar.getText().toString());
                        bar.setText("0");
                    }
                    lastOperate = '/';
                    flag = true;
                    break;
                case R.id.buttonEqu:
                    if(flag) {
                        int result = 0;
                        switch (lastOperate) {
                            case '+':
                                result = lastNum + Integer.parseInt(bar.getText().toString());
                                break;
                            case '-':
                                result = lastNum - Integer.parseInt(bar.getText().toString());
                                break;
                            case '*':
                                result = lastNum * Integer.parseInt(bar.getText().toString());
                                break;
                            case '/':
                                result = lastNum / Integer.parseInt(bar.getText().toString());
                                break;
                            default:
                                break;
                        }
                        bar.setText(String.valueOf(result));
                    }
                    contiOper = false;
                    flag = false;
                    break;
                default:
                    // if origin is not 0, add a number in the last.
                    if(bar.getText().toString().equals("0")) {
                        bar.setText(((Button)V).getText().toString());
                    } else {
                        bar.setText(bar.getText().toString()+((Button)V).getText().toString());
                    }
            }
        }
    };

    private void findView() {
        bar = (TextView)findViewById(R.id.tv);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);
        btn9 = (Button)findViewById(R.id.button9);
        btn0 = (Button)findViewById(R.id.button0);
        btn10 = (Button)findViewById(R.id.button10);
        btnPlus = (Button)findViewById(R.id.buttonPlus);
        btnSub = (Button)findViewById(R.id.buttonSubtract);
        btnMul = (Button)findViewById(R.id.buttonMul);
        btnDiv = (Button)findViewById(R.id.buttonDiv);
        btnEqu = (Button)findViewById(R.id.buttonEqu);
        btnAbout = (Button)findViewById(R.id.buttonAbout);
        btnC = (Button)findViewById(R.id.buttonC);

        btn1.setOnClickListener(bltisener);
        btn2.setOnClickListener(bltisener);
        btn3.setOnClickListener(bltisener);
        btn4.setOnClickListener(bltisener);
        btn5.setOnClickListener(bltisener);
        btn6.setOnClickListener(bltisener);
        btn7.setOnClickListener(bltisener);
        btn8.setOnClickListener(bltisener);
        btn9.setOnClickListener(bltisener);
        btn0.setOnClickListener(bltisener);
        btn10.setOnClickListener(bltisener);
        btnPlus.setOnClickListener(bltisener);
        btnSub.setOnClickListener(bltisener);
        btnMul.setOnClickListener(bltisener);
        btnDiv.setOnClickListener(bltisener);
        btnEqu.setOnClickListener(bltisener);
        btnAbout.setOnClickListener(bltisener);
        btnC.setOnClickListener(bltisener);
    }
}
