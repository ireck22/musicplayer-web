package com.dvt.sssssa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        //取的intent中的bundle物件
        Bundle bundle0311 =this.getIntent().getExtras();

        String sex = bundle0311.getString("sex");
        double height = bundle0311.getDouble("height");

        String sexText="";
        if(sex.equals("M")){
            sexText="男性";
        }else{
            sexText="女性";
        }

        //取得標準體中
        String weight = this.getWeight(sex,height);
        //設定輸出
        TextView tv1 = (TextView)findViewById(R.id.TextView11);
        tv1.setText("您是一位"+sexText+"\n您的身高是"+height+"cm\n您的標準體重是"+weight+"kg");
    }

    private String getWeight(String sex, double height) {
        // TODO Auto-generated method stub
        String weight="";
        if(sex.equals("M")){
            weight=format((height-80)*0.7);
        }else{
            weight=format((height-70)*0.6);
        }
        return weight;
    }

    //四捨五入用
    private String format(double num) {
// TODO Auto-generated method stub
        NumberFormat formatter = new DecimalFormat("0.00");
        String s = formatter.format(num);
        return s;
    }

}