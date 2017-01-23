package tw.com.flag.ch11_player;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {

	VideoView vdv;  //�ΨӰѷ� VideoView ����
	int pos = 0;    //�ΨӰO���e���������m

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//���èt�Ϊ����A�C
		requestWindowFeature(Window.FEATURE_NO_TITLE);        //���� Activity �����D�C    	
		setContentView(R.layout.activity_video);    //�H�W2���]�w�����b����k���e�I�s    	
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//�O���ù��@���}�� (���n�۰ʥ�v)

		Intent it = getIntent();     //���o�ǤJ�� Intent ����
		Uri uri = Uri.parse(it.getStringExtra("uri")); //���X�n����v���� Uri
		if(savedInstanceState != null)                 //�p�G�O�]����ӭ��s�Ұ� Activity
			pos = savedInstanceState.getInt("pos", 0); //���X����e���x�s�������m

		vdv = (VideoView)findViewById(R.id.videoView1);		//�ѷӨ�e������ VideoView ����
		MediaController mediaCtrl = new MediaController(this); //�إ߼��񱱨��
		vdv.setMediaController(mediaCtrl);  //�]�w�n�μ��񱱨��ӱ����
		vdv.setVideoURI(uri);   //�]�w�n����v���� Uri
	}

	@Override
	protected void onResume() { //�� Activity �ҰʡB�ΥѼȰ����A�^�줬�ʪ��A��
		super.onResume();
		vdv.seekTo(pos);   //���� pos �������m
		vdv.start();       //�}�l����
	}

	@Override
	protected void onPause() { //�� Activity �i�J�Ȱ����A�� (�Ҧp�������L�{��)
		super.onPause();
		pos = vdv.getCurrentPosition(); //�x�s�����m
		vdv.stopPlayback();    //�����
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("pos", pos);     //�N�Ȱ��ɩҨ��o���ثe�����m�x�s�_��
	}
}
