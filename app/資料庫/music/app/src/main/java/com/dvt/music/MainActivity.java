package com.dvt.music;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener{

        Uri uri;
        TextView txvname,txvuri;
        boolean  isVideo=false;

        Button btnplay,btnstop;
        CheckBox ckbloop;
        MediaPlayer mper;
        Toast tos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //設定螢幕不隨手機旋轉以及不休眠
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //設定螢幕直向顯示
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//設定不休眠
        txvname=(TextView)findViewById(R.id.textView);
        txvuri=(TextView)findViewById(R.id.textView2);
        btnplay=(Button)findViewById(R.id.button3);
        btnstop=(Button)findViewById(R.id.button4);
        ckbloop=(CheckBox)findViewById(R.id.checkBox);

        uri=Uri.parse("android.resource//" +
                       getPackageName() + "/" );
        txvname.setText("test.mp3");
        txvuri.setText("程式內的樂曲:" + uri.toString());

        mper=new MediaPlayer();
        mper.setOnPreparedListener(this);
        mper.setOnErrorListener(this);
        mper.setOnCompletionListener(this);
        tos=Toast.makeText(this, "",Toast.LENGTH_SHORT); //建立toas物件

        preparMusic();

    }
    void preparMusic(){
        btnplay.setText("播放");
        btnplay.setEnabled(false);//播放按鈕不能按，撙備好才能按
        btnstop.setEnabled(false);//停止鈕不能按

        try{
            mper.reset();
            mper.setDataSource(this, uri);
            mper.setLooping(ckbloop.isChecked());
            mper.prepareAsync();
        }catch(Exception e){
            tos.setText("指定音樂檔錯誤!" + e.toString());
            tos.show();
        }

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mper.seekTo(0);
        btnplay.setText("播放");
        btnstop.setEnabled(false);
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        tos.setText("發生錯誤，停止撥放");
        tos.show();
        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
            btnplay.setEnabled(true);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data ){

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK){
            boolean isvideo = (requestCode == 101);
            uri=convertUri(data.getData());
            txvname.setText(uri.getLastPathSegment());
            txvuri.setText("檔案位置:" + uri.getPath());
            if(!isVideo)preparMusic();

        }
    }

    public void onMpPlay(View V){
        if(mper.isPlaying()){  //如果正在播，就暫停
            mper.pause();      //暫停播放
            btnplay.setText("繼續");
        }
        else{  //如果沒有再播就開始播
            mper.start();             //開始播放
            btnplay.setText("暫停");
            btnstop.setEnabled(true); //音樂已經開始播，所以讓停止鈕有作用
        }
    }
    public void onMpStop(View v){   //按下停止鈕時
        mper.pause();
        mper.seekTo(0);            //移道音樂0秒的位置
        btnplay.setText("播放");
        btnstop.setEnabled(false); //讓停止鈕不能再按了
    }
    public void onMpLoop(View v){
        if(ckbloop.isChecked())
            mper.setLooping(true);   //設定要重複播放
        else
            mper.setLooping(false);   //設定不要重複播放
    }
    public void onMpBackward(View V){
        if(!btnplay.isEnabled()) return; //如果還沒準備好(播放鈕不能按)
        int len=mper.getDuration();      //讀取音樂長度
        int pos=mper.getCurrentPosition();  //讀取目前播放位置
        pos-=10000;
        if(pos<0) pos=0;
        mper.seekTo(pos);
        tos.setText("倒退十秒:"+ pos/1000 + "/" + len/1000); //顯示訊息
        tos.show();
    }
    public void onMpForward(View V){
        if(!btnplay.isEnabled()) return; //如果還沒準備好(播放鈕不能按)
        int len=mper.getDuration();      //讀取音樂長度
         int pos=mper.getCurrentPosition(); //讀取目前播放位置
        pos+=10000;                       //前進十秒
        if(pos>len) pos=len;             //不可大於總秒數
        mper.seekTo(pos);                //移動播放位置
        tos.setText("倒退十秒:" + pos / 1000 + "/" + len / 1000); //顯示訊息
        tos.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mper.release(); //釋放mdiaplyer物件

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mper.isPlaying()){
            btnplay.setText("繼續");
            mper.pause();
        }
    }




    Uri convertUri(Uri uri) {
        if(uri.toString().substring(0,7).equals("contant")){
            String[] colName={ MediaStore.MediaColumns.DATA };
            Cursor cursor=getContentResolver().query(uri,colName,null,null,null);
            cursor.moveToFirst();
            uri=Uri.parse("file://" + cursor.getString(0));
        }
        return uri;
    }


}
