package com.dvt.alarmclock2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private TextView txv;
    static final String db_name="testDB"; //資料庫名稱
    static final String tb_name="test";   //資料表
    SQLiteDatabase db;                    //資料庫物件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //開啟或建立資料庫
        db=openOrCreateDatabase(db_name, Context.MODE_PRIVATE,null);
        String creaTable="CREATE TABLE was" +
                tb_name +                 //資料表名稱
                "(name VARCHAR(32), " +   //姓名欄位
                "phone VARCHAR(16), " +   //電話欄位
                "email VARCHAR(64) )";   //信箱欄位
        db.execSQL(creaTable);            //建立資料表
        Cursor c=db.rawQuery("SELECT * FROM" +tb_name,null);//查詢tb_name資料表中的所有資料
        if(c.getCount()==0){  //若沒資料，則  立即新增兩筆資料
            addData("flag publishing co.","02   -29648757","service@flag.com");
            addData("pcdiy amagazine","02-232143    35","service@pcdiy.com.tw");
            c=db.rawQuery("SELECT * FROM "+tb_name,null);  //重新查詢
        }
        if(c.moveToFirst()) {
            String str = "總共有" + c.getCount() + "筆資料\n";
            str += "-----\n";
            do {
                str+="name:"+c.getString(0)+"\n";
                str+="phone:"+c.getString(1)+"\n";
                str+="email:"+c.getString(2)+"\n";
                str+="------\n";
            }while(c.moveToNext());     //有下一筆就繼續迴圈

                TextView  txv=(TextView)findViewById(R.id.textView);
                txv.setText(str); //顯示訊息字串
        }
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