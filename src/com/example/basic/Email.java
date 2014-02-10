package com.example.basic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {
	
	EditText personalEmail, intro, personalName, stupidThings, hatefulAction, outro;
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}
	
	
	
	private void initializeVars() {
		// TODO Auto-generated method stub
		personalName = (EditText) findViewById(R.id.etName);
		personalEmail = (EditText) findViewById(R.id.etEmails);
		intro = (EditText) findViewById(R.id.etIntro);
		stupidThings = (EditText) findViewById(R.id.etThings);
		hatefulAction = (EditText) findViewById(R.id.etAction);
		outro = (EditText) findViewById(R.id.etOutro);
		sendEmail = (Button) findViewById(R.id.bSendEmail);
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		convertEditTextVarsIntoStrings();
		String emailaddress[] = { emailAdd };
		String message = "Well Hello "
				+ name 
				+ " I just wanted to say "
				+ beginning
				+ ". Not only that, I hate you when you "
				+ stupidAction
				+ ". That just really makes me crazy. I just want to "
				+ hatefulAct
				+ ". Well, that's all I have to say to you. Oh, and "
				+ out 
				+ '\n'
				+ "PS. Stay in Touch";
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate You");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		
		startActivity(emailIntent);
	}


	private void convertEditTextVarsIntoStrings() {
		// TODO Auto-generated method stub
		name = personalName.getText().toString();
		emailAdd = personalEmail.getText().toString();
		beginning = intro.getText().toString();
		stupidAction = stupidThings.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
	

}
