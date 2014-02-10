package com.example.basic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class MyBringBack extends View {
	
	//Bitmap for our purpleball.png resource
	Bitmap pBall;
	int changingY;
	// Import Typeface to setup a font
	//Typeface font;

	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		pBall = BitmapFactory.decodeResource(getResources(), R.drawable.purpleball);
		changingY = 0;
		//Set up font
		//font = Typeface.createFromAsset(context.getAssets(), "FONTNAME.TTF");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		Paint textPaint = new Paint();
		textPaint.setARGB(75, 222, 12, 111);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(60);
		//If we setup a font in the assets folder, we can set it up here
		//textPaint.setTypeface(font);
		canvas.drawText("Raseel", canvas.getWidth()/2, 200, textPaint);
		
		canvas.drawBitmap(pBall, canvas.getWidth()/2, changingY, null);
		if (changingY < canvas.getHeight()) {
			changingY += 10;
		} else {
			changingY = 0;
		}
		
		//Drawing a rectangle
		Rect middleRect = new Rect();
		middleRect.set(0,400, canvas.getWidth(), 550);
		Paint ourBlue = new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, ourBlue);
		invalidate();
	}

	
}
