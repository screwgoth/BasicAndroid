package com.example.basic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.content.SharedPreferences;

public class OpenedClass extends Activity implements View.OnClickListener,
		OnCheckedChangeListener {
//public class OpenedClass extends Activity {

	TextView question, text;
	Button returnData;
	RadioGroup rgSelectionList;
	String gotBread, sendData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialise();
		/**
		 The next 3 lines are commented fo SAFR to work
		 Uncommnet for SA
		// Get the intent though which we reached to this class
		Bundle gotBasket = getIntent().getExtras();
		//Get Data from the passed Bundle
		gotBread = gotBasket.getString("key");
		question.setText(gotBread);
		
		**/
		
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("name", "Raseel is...");
		String values = getData.getString("list", "4");
		if(values.contentEquals("1")){
			question.setText(et);
		}
		
	}

	private void initialise() {
		// TODO Auto-generated method stub
		question = (TextView) findViewById(R.id.tvQuestions);
		text = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
		returnData.setOnClickListener(this);
		rgSelectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		rgSelectionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", sendData);
		person.putExtras(backpack);
		//Send Result back
		setResult(RESULT_OK, person);
		finish();

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rCrazy:
			sendData = "Probably Right !";
			break;
		case R.id.rAwesome:
			sendData = "Defnitely Right !";
			break;
		case R.id.rBoth:
			sendData = "Spot On !!";
			break;
		}
		text.setText(sendData);

	}

}
