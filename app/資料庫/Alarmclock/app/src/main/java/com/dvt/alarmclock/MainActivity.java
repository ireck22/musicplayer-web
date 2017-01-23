package com.dvt.alarmclock;

import android.content.ContentValues;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txv;
    static final String db_name="testDB"; //資料庫名稱
    static final String tb_name="test";   //資料表
    SQLiteDatabase db;                    //資料庫物件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //開啟或建立資料庫
        db=openOrCreateDatabase(db_name, Context.MODE_PRIVATE,null);
        String creaTable="CREATE TABLE w" +
                tb_name +                 //資料表名稱
                "(name VARCHAR(32), " +   //姓名欄位
                "phone VARCHAR(16), " +   //電話欄位
                "email VARCHAR(64) )";   //信箱欄位
        db.execSQL(creaTable);            //建立資料表
        addData("flag publishing co.","02-29648757","service@flag.com");
        addData("pcdiy amagazine","02-23214335","service@pcdiy.com.tw");
        txv=(TextView)findViewById(R.id.textView);
        txv.setText("資料庫擋路徑: "+db.getPath()+ "\n"+
                    "料料庫分頁大小: "+db.getPageSize() +" Bytes\n"+
                    "資料量上限: "+db.getMaximumSize() +" Bytes\n");


        db.close();
    }
    private void addData(String name,String phone,String email){
        ContentValues cv=new ContentValues(3);
        cv.put("name",name);
        cv.put("phone",phone);
        cv.put("email",email);
        db.insert(tb_name, null, cv);

    }

}
