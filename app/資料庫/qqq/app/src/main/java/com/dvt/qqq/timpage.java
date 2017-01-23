package com.dvt.qqq;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class timpage extends Activity implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener{
    private TextView tx1,tx2,tx3,tx4,tx5,tx11,tx12;
    private int mHour, mMinute;
    private double age;
    String  ts1,ts2;
    private int ret ;
    Handler hs;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timpage);
        fidview();





        tx5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(timpage.this, MainActivity.class);
                startActivity(intent2);

            }
        });


        tx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time();
            }
        });




        tx11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    data();
//                uri = Uri.parse("android.resource://" + getPackageName() + "/");
//                tx11.setText("選取的歌:" + uri.toString());

            }
        });
        tx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_GET_CONTENT);
                it.setType("audio/*");
                // 建立 "檔案選擇器" 的 Intent  (第二個參數: 選擇器的標題)
                Intent destIntent = Intent.createChooser(it, "選擇檔案");

                // 切換到檔案選擇器 (它的處理結果, 會觸發 onActivityResult 事件)
                startActivityForResult(destIntent, 100);


            }
        });
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data ){

        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if ( resultCode == RESULT_OK )
        {
            // 取得檔案的 Uri
            Uri uri = data.getData();
            if( uri != null )
            {
                // 利用 Uri 顯示 音樂

                tx11.setText((CharSequence) uri);

                setTitle(uri.toString());
            }
            else
            {
                setTitle("無效的檔案路徑 !!");
            }
        }

        else{
            setTitle("取消選擇檔案");
        }

    }

    private void data(){
//        Calendar c = Calendar.getInstance();
//        int year = c.get(Calendar.YEAR);                      //取出年
//        int month = c.get(Calendar.MONTH) + 1;           //取出月，月份的編號是由0~11 故+1
//        int day = c.get(Calendar.DAY_OF_MONTH);        //取出日
//        int weekday = c.get(Calendar.DAY_OF_WEEK);   //取出星期幾，編號由Sunday(1)~Saturday(7)
        SimpleDateFormat sDateFormat = new SimpleDateFormat("HH:mm");
        String date = sDateFormat.format(new java.util.Date());
        tx11.setText(date);


    }



    private void time(){
        //設定初始時間
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        TimePickerDialog tpd= new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute){

                        tx2.setText(hourOfDay + ":" + minute);

                        String ans=hourOfDay + ":" + minute;
                        tx12.setText(ans);
                        SimpleDateFormat sDateFormat = new SimpleDateFormat("mm");
                        String date = sDateFormat.format(new java.util.Date());
                        SimpleDateFormat sDate = new SimpleDateFormat("HH");
                        String date2 = sDate.format(new java.util.Date());
                        if( minute == Integer.valueOf(date) && hourOfDay == Integer.valueOf(date2)){
                            tx11.setText("成功");
                        }else{
                            tx11.setText("失敗");
                        }
                    }
                }, mHour, mMinute, false);
        tpd.show();

    }


    private void fidview(){
        tx1=(TextView)findViewById(R.id.textView);
        tx2=(TextView)findViewById(R.id.textView2);
        tx3=(TextView)findViewById(R.id.textView3);
        tx4=(TextView)findViewById(R.id.textView4);
        tx5=(TextView)findViewById(R.id.textView5);
        tx11=(TextView)findViewById(R.id.textView11);
        tx12=(TextView)findViewById(R.id.textView12);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}
