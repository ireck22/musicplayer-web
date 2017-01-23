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
	Uri uri;      //�x�s�v���ɮת� Uri
	TextView txvName, txvUri;  //�ѷӨ�e����������
	boolean isVideo = false;   //�O���O�_���v����

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//�]�w�ù����H�������B�H�εe�����V���
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);//�]�w�ù����H�������
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//�]�w�ù����V���
 
		txvName = (TextView)findViewById(R.id.txvName); //�ѷӨ��1�Ӥ�r����
		txvUri = (TextView)findViewById(R.id.txvUri);   //�ѷӨ��2�Ӥ�r����

		uri = Uri.parse("android.resource://" + //�w�]�|����{������������
					    getPackageName() + "/" + R.raw.welcome);
		txvName.setText("welcome.mp3");         //�b�e��������ɦW
		txvUri.setText("�{�������֦��G"+ uri.toString());//��� Uri
	}
	
	public void onPick(View v) {
		Intent it = new Intent(Intent.ACTION_GET_CONTENT);    //�إ߰ʧ@�� "���" �� Intent
		if(v.getId() == R.id.btnPickAudio) {  //�p�G�O "����q��" �s�� ID
			it.setType("audio/*");     //�n����Ҧ���������
			startActivityForResult(it, 100);		
		}
		else {  //�_�h�N�O "����v��" �s
			it.setType("video/*");     //�n����Ҧ��v������
			startActivityForResult(it, 101);		
		}
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if(resultCode == Activity.RESULT_OK) {
			isVideo = (requestCode == 101); //�O���O�_����F�v���� (���ѧO�X��101��)
			uri = convertUri(data.getData());  //���o����ۤ��� Uri �ð� Uri �榡�ഫ
			txvName.setText(uri.getLastPathSegment ());  //����ɦW (Uri �̫᪺�`�I��r)
			txvUri.setText("�ɮצ�m�G" + uri.getPath());//����ɮת����|
		}
	}
	
    Uri convertUri(Uri uri) { //�N "content://" ������ Uri �ഫ�� "file://" �� Uri
   		if(uri.toString().substring(0, 7).equals("content")) {  //�p�G�O�H "content" �}�Y
			String[] colName = { MediaColumns.DATA };    //�ŧi�n�d�ߪ����
			Cursor cursor = getContentResolver().query(uri, colName,  //�H uri �i��d��
					                                   null, null, null); 
			cursor.moveToFirst();      //����d�ߵ��G���Ĥ@���O��
			uri = Uri.parse("file://" + cursor.getString(0)); //�N���|�ର Uri   			
		}
    	return uri;   //�Ǧ^ Uri ����
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}    
}