package tw.com.flag.ch11_player;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity{
	Uri uri;      //儲存影音檔案的 Uri
	TextView txvName, txvUri;  //參照到畫面中的元件
	boolean isVideo = false;   //記錄是否為影片檔

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//設定螢幕不隨手機旋轉、以及畫面直向顯示
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);//設定螢幕不隨手機旋轉
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//設定螢幕直向顯示
 
		txvName = (TextView)findViewById(R.id.txvName); //參照到第1個文字元件
		txvUri = (TextView)findViewById(R.id.txvUri);   //參照到第2個文字元件

		uri = Uri.parse("android.resource://" + //預設會播放程式內的音樂檔
					    getPackageName() + "/" + R.raw.welcome);
		txvName.setText("welcome.mp3");         //在畫面中顯示檔名
		txvUri.setText("程式內的樂曲："+ uri.toString());//顯示 Uri
	}
	
	public void onPick(View v) {
		Intent it = new Intent(Intent.ACTION_GET_CONTENT);    //建立動作為 "選取" 的 Intent
		if(v.getId() == R.id.btnPickAudio) {  //如果是 "選取歌曲" 鈕的 ID
			it.setType("audio/*");     //要選取所有音樂類型
			startActivityForResult(it, 100);		
		}
		else {  //否則就是 "選取影片" 鈕
			it.setType("video/*");     //要選取所有影片類型
			startActivityForResult(it, 101);		
		}
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if(resultCode == Activity.RESULT_OK) {
			isVideo = (requestCode == 101); //記錄是否選取了影片檔 (當識別碼為101時)
			uri = convertUri(data.getData());  //取得選取相片的 Uri 並做 Uri 格式轉換
			txvName.setText(uri.getLastPathSegment ());  //顯示檔名 (Uri 最後的節點文字)
			txvUri.setText("檔案位置：" + uri.getPath());//顯示檔案的路徑
		}
	}
	
    Uri convertUri(Uri uri) { //將 "content://" 類型的 Uri 轉換為 "file://" 的 Uri
   		if(uri.toString().substring(0, 7).equals("content")) {  //如果是以 "content" 開頭
			String[] colName = { MediaColumns.DATA };    //宣告要查詢的欄位
			Cursor cursor = getContentResolver().query(uri, colName,  //以 uri 進行查詢
					                                   null, null, null); 
			cursor.moveToFirst();      //移到查詢結果的第一筆記錄
			uri = Uri.parse("file://" + cursor.getString(0)); //將路徑轉為 Uri   			
		}
    	return uri;   //傳回 Uri 物件
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}    
}