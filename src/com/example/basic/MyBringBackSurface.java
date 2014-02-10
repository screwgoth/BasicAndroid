package com.example.basic;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyBringBackSurface extends SurfaceView implements Runnable {
	
	SurfaceHolder ourHolder;
	Thread ourThread = null;

	public MyBringBackSurface(Context context) {
		// TODO Auto-generated constructor stub
		super(context);
		ourHolder = getHolder();
		ourThread = new Thread(this);
		ourThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
