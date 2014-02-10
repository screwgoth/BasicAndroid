package com.example.basic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

	/** Value of the Key to be passed by intent **/
	public final static String EXTRA_MESSAGE = "com.example.basic,MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /** Called when user clicks on the Send button" **/
    public void sendMessage(View view) {
    	//Do Something
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	/** Find the View of the Edit Text box **/
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	/** Extract the typed message **/
    	String message = editText.getText().toString();
    	/** Pass extra info, i.e., message, in the intent **/
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
}
