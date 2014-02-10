package com.example.basic;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {

	ImageButton ib;
	ImageView iv;
	Button b;
	Intent i;
	final static int cameraData = 0;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.splash_background);
		bmp = BitmapFactory.decodeStream(is);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById(R.id.ivReturnedPic);
		ib = (ImageButton) findViewById(R.id.ibTakePic);
		b = (Button) findViewById(R.id.bSetWallPaper);

		b.setOnClickListener(this);
		ib.setOnClickListener(this);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.ibTakePic:
			//Capture Image
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
			break;
		case R.id.bSetWallPaper:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				e.printStackTrace();
				
			}
 			break;
		}
		
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (RESULT_OK == resultCode) {
			// Get image from the Camera
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			// Set the image from the data in our Image View
			iv.setImageBitmap(bmp);
		}
	}

}
