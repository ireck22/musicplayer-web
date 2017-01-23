package com.dvt.qqq;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double df;
    private int ret,requestCode,resultCode;
    private TextView tx6,tx7;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        tx6=(TextView)findViewById(R.id.textView6);
        tx7=(TextView)findViewById(R.id.textView7);
//        Intent intent2=new Intent();

        tx6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx6.setText(ret);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this, timpage.class);
//                Bundle bundle = new Bundle();
//                bundle.putDouble("age", df);//傳遞Double
//                intent.putExtras(bundle);
                startActivityForResult(intent,ret);

            }
        });
    }


    Intent intent=getIntent();
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(resultCode){
            case 30:
            //當B傳回來的Intent的requestCode 等於當初A傳出去的話
                String result = data.getExtras().getString("ans");

                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
