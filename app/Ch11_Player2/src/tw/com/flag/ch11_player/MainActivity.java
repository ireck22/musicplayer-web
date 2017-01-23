package tw.com.flag.ch11_player;

import android.media.MediaPlayer;
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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements 
			MediaPlayer.OnPreparedListener,   //��@ MediaPlayer �� 3 �Ӫ��ƥ��ť����
			MediaPlayer.OnErrorListener, 
			MediaPlayer.OnCompletionListener {
	Uri uri;      //�x�s�v���ɮת� Uri
	TextView txvName, txvUri;  //�ΨӰѷӨ�e����������
	boolean isVideo = false;   //�ΨӰO���O�_���v����

	Button btnPlay, btnStop;  //�ΨӰѷӼ���s�B����s
	CheckBox ckbLoop;         //�ΨӰѷӭ��Ƽ���h��s
	MediaPlayer mper;         //�ΨӰѷ� MediaPlayer ����
	Toast tos;                //�ΨӰѷ� Toast ���� (��ܰT������)
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//�]�w�ù����H�������B�e���n���V��ܡB�H�οù����i�J��v
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);//�]�w�ù����H�������
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//�]�w�ù����V���
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//�]�w�ù����i�J��v
		
		txvName = (TextView)findViewById(R.id.txvName); //�ѷӨ��1�Ӥ�r����
		txvUri = (TextView)findViewById(R.id.txvUri);   //�ѷӨ��2�Ӥ�r����
		btnPlay = (Button)findViewById(R.id.btnPlay);   //�ѷӨ켽��s
		btnStop = (Button)findViewById(R.id.btnStop);   //�ѷӨ찱��s
		ckbLoop = (CheckBox)findViewById(R.id.ckbLoop); //�ѷӨ쭫�Ƽ���h��s

		uri = Uri.parse("android.resource://" + //�w�]�|����{������������
					    getPackageName() + "/" + R.raw.welcome);
		txvName.setText("welcome.mp3");         //�b�e��������ɦW
		txvUri.setText("�{�������֦��G"+ uri.toString());//��� Uri
		
		mper = new MediaPlayer();           //�إ� MediaPlayer ����
		mper.setOnPreparedListener(this);   //�]�w 3 �Өƥ��ť��
		mper.setOnErrorListener(this);
		mper.setOnCompletionListener(this);
		tos = Toast.makeText(this, "", Toast.LENGTH_SHORT); //�إ� Toast ����
		
		prepareMusic();   //�ǳƭ��� (welcome.mp3) ������
	}
	
	void prepareMusic() {
		btnPlay.setText("����");     //�N���s��r��_�� "����"
		btnPlay.setEnabled(false);   //�ϼ���s����� (�n���ǳƦn�~���)
		btnStop.setEnabled(false);   //�ϰ���s�����
		
		try {
			mper.reset();       //�p�G���e�����L�q, ���� reset ��~�ഫ�q
			mper.setDataSource(this, uri);  //���w�q���ӷ�
			mper.setLooping(ckbLoop.isChecked()); //�]�w�O�_���Ƽ���			
			mper.prepareAsync();  //�n�D MediaPlayer �ǳƼ�����w������
		} catch (Exception e) {    //�d�I���~����ܰT��
			tos.setText("���w�����ɿ��~�I" + e.toString());
			tos.show();
		}
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
			if(!isVideo) prepareMusic();   //�p�G�O���ִN�ǳƼ���
		}
	}
    Uri convertUri(Uri uri) { //�N "content://" ������ Uri �ഫ�� "file://" �� Uri
   		if(uri.toString().substring(0, 7).equals("content")) {  //�p�G�O�H "content" �}�Y
			String[] colName = { MediaColumns.DATA };    //�ŧi�n�d�ߪ����
			Cursor cursor = getContentResolver().query(uri, colName,  //�H imgUri �i��d��
					                                   null, null, null); 
			cursor.moveToFirst();      //����d�ߵ��G���Ĥ@���O��
			uri = Uri.parse("file://" + cursor.getString(0)); //�N���|�ର Uri   			
		}
    	return uri;   //�Ǧ^ Uri ����
    }
	//********************************************************

	public void onMpPlay(View v) {   //���U�i����j�s��
		if (mper.isPlaying()) {  //�p�G���b��, �N�Ȱ�
			mper.pause();   //�Ȱ�����
			btnPlay.setText("�~��");
		}
		else {  //�p�G�S���b��, �N�}�l��
			mper.start();   //�}�l����
			btnPlay.setText("�Ȱ�");
			btnStop.setEnabled(true);
		}
	}

	public void onMpStop(View v) {   //���U�i����j�s��
		mper.pause();   //�Ȱ�����
		mper.seekTo(0); //���쭵�֤� 0 ����m
		btnPlay.setText("����");
		btnStop.setEnabled(false);
	}

	public void onMpLoop(View v) {   //���U�i���Ƽ���j�h��s��
		if (ckbLoop.isChecked())
			mper.setLooping(true);   //�]�w�n���Ƽ���
		else
			mper.setLooping(false);  //�]�w���n���Ƽ���
	}

	public void onMpBackward(View v) {   //���U�˰h�ϧζs��
		if(!btnPlay.isEnabled()) return; //�p�G�٨S�ǳƦn(����s�����), �h���B�z
		int len = mper.getDuration();       //Ū�����֪���
		int pos = mper.getCurrentPosition();//Ū���ثe�����m
		pos -= 10000;		                //�˰h 10 �� (10000ms)
		if(pos <0) pos = 0;                 //���i�p�� 0
		mper.seekTo(pos);                   //���ʼ����m
		tos.setText("�˰h10��G" + pos/1000 + "/" + len/1000);  //��ܰT��
		tos.show();
	}
	
	public void onMpForward(View v) {   //���U�e�i�ϧζs��
		if(!btnPlay.isEnabled()) return; //�p�G�٨S�ǳƦn(����s�����), �h���B�z
		int len = mper.getDuration();       //Ū�����֪���
		int pos = mper.getCurrentPosition();//Ū���ثe�����m
		pos += 10000;		                //�e�i 10 �� (10000ms)
		if(pos > len) pos = len;            //���i�j���`���
		mper.seekTo(pos);                   //���ʼ����m
		tos.setText("�e�i10��G" + pos/1000 + "/" + len/1000);  //��ܰT��
		tos.show();
	}

	//********************************************************
	
	@Override
	public void onPrepared(MediaPlayer arg0) {
		btnPlay.setEnabled(true);  //��ǳƦn��, �u�����i����j�s�i�H���Y�i
	}   
	
	@Override
	public void onCompletion(MediaPlayer arg0) {
		mper.seekTo(0);             //�N�����m�k 0
		btnPlay.setText("����");    //������s��� "����"
		btnStop.setEnabled(false);  //������s�����
	}

	@Override
	public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
		tos.setText("�o�Ϳ��~�A�����");  //��ܿ��~�T��
		tos.show();
		return true;
	}

	//********************************************************
	
	@Override
	protected void onPause() {
		super.onPause();
		
		if (mper.isPlaying()) {  //�p�G���b��, �N�Ȱ�
			btnPlay.setText("�~��");
			mper.pause();  //�Ȱ�����
		}
	}

	@Override
	protected void onDestroy() {
		mper.release();  //���� MediaPlayer ����
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}