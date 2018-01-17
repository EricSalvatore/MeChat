package com.example.demonandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessageActivity extends Activity {
	static String SEND_ACTION = "SEND_ACTION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);
		 
		
		EditText edit = (EditText) findViewById(R.id.input);
		String input = edit.getText().toString();
		TextView message = (TextView) findViewById(R.id.messagetext2);
		message.setText(input);
		
		Intent data = new Intent();
		data.putExtra("chat_content", "");
		
		/*LinearLayout mainLayout = (LinearLayout) findViewById(R.id.showout);
		
		LayoutInflater layoutInflater = LayoutInflater.from(this);
		View view = layoutInflater.inflate(R.layout.message1, mainLayout, true);*/
		Intent myIntent = new Intent();
		Intent getIntent = getIntent();
		String pageId = getIntent.getStringExtra("getIntent");
		myIntent.setAction("SEND_ACTION");
		myIntent.putExtra("pageId", pageId);
		
		MessageActivity.this.sendBroadcast(myIntent);
		
	}
}
