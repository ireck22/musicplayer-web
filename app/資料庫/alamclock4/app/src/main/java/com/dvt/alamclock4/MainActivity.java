package com.dvt.alamclock4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    AlarmManager am;
    PendingIntent pi;
    Calendar     cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int n=30;
        for(int i=0;i<n; i++){
            cal=Calendar.getInstance();
            cal.set(2014,0,1,10,10,10);
            Intent intent=new Intent(this,aml.class);
            am=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
            pi=PendingIntent.getBroadcast(this, i ,intent,PendingIntent.FLAG_ONE_SHOT);
            am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi);
        }



    }
}
