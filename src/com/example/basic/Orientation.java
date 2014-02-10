package com.example.basic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Orientation extends Activity implements View.OnClickListener {
//public class Orientation extends Activity {


	TextView tv;
	Button add;	
	Button sub;
	int count = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.orientation);
		initiaise();
		add.setOnClickListener(this);
		sub.setOnClickListener(this);
		
	}

	private void initiaise() {
		// TODO Auto-generated method stub
		tv = (TextView) findViewById(R.id.tvSomeText);
		add = (Button) findViewById(R.id.bAdd);
		sub = (Button) findViewById(R.id.bSub);
		count = 0;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.bAdd:
			count++;
			break;
		case R.id.bSub:
			count--;
			break;
		}
		tv.setText("Our new value is " + count);
		
	}
	
	

}
