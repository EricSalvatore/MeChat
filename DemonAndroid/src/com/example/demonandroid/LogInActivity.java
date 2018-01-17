package com.example.demonandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
		
		final EditText userName = (EditText) findViewById(R.id.userName);
		final EditText passWord = (EditText) findViewById(R.id.password);
	
		Button button = (Button) findViewById(R.id.login);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent();
				myIntent.setClass(LogInActivity.this, ListMenu.class);
	//******			myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				myIntent.putExtra("userName", "");
				myIntent.putExtra("passWord", "");
				SharedPreferences sp = getSharedPreferences("Users", Context.MODE_PRIVATE);
				SharedPreferences.Editor se = sp.edit();
			//	se.putString("userName", userName.getText().toString().trim());
			//	se.putString("passWord", passWord.getText().toString().trim());
				
				se.putString("userName", "admin");
				se.putString("passWord", "admin");
				
				se.commit();

				//getPreferences(mode);ֻ�е�ǰ�����ʹ�ã�������xml�ļ�����������ͬ���϶�Ϊ��ǰ����е�
				
				String userNameStr = sp.getString("userName", "NULL");
				String passWordStr = sp.getString("passWord","NULL");
				//if()
				
				
				
				
				
				LogInActivity.this.startActivity(myIntent);
			}
		});
	
		
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		onUserInteraction();
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
	
	
}
