package com.dvt.alamclock4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by 助理001 on 2016/7/26.
 */
public class aml   extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "時間到", Toast.LENGTH_LONG).show();
    }
}
