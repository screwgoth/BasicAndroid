package com.example.basic;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu  extends ListActivity {

	String classes[] = { "MainActivity", "TextPlay", "Email", "Camera", "Data", "Orientation",
			"GFX", "SoundStuff", "Slider", "Tabs", "SimpleBrowser"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//Full screen
		/*
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
				*/
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classes));
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		//Starting a new Activity using Classes
		try {
			Class ourClass = Class.forName("com.example.basic." + cheese);
			Intent ourIntent = new Intent(this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
//		return super.onCreateOptionsMenu(menu);
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp =  getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}


	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
//		return super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.example.basic.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent p = new Intent("com.example.basic.PREFS");
			startActivity(p);
			break;
		case R.id.exit:
			finish();
			break;
		}
		
		return false;
	
	}


}
