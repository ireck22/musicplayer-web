package com.dvt.sssssa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button CalculateButton = (Button)findViewById(R.id.Button01);
        CalculateButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText HeightEditText = (EditText) findViewById(R.id.EditText01);
                double height = Double.parseDouble(HeightEditText.getText().toString());

                String sex = "";
                RadioButton SexMale = (RadioButton) findViewById(R.id.RadioButton01);
                if (SexMale.isChecked()) {
                    sex = "M";
                } else {
                    sex = "F";
                }

                //new一個intent物件，並指定Activity切換的class
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Main2Activity.class);

                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putDouble("height", height);
                bundle.putString("sex", sex);

                //將Bundle物件assign給intent
                intent.putExtras(bundle);

                //切換Activity
                startActivity(intent);
            }

        });
    }
}
