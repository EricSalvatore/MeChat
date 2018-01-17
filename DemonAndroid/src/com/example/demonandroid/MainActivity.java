package com.example.demonandroid;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static int REQUEST_CODE = 1;
	private static boolean mBackKeyPressed = false;
	

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub	
		super.onStart();
		Log.i("Deomon", "the activity is start");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("Deomon", "the activity is restart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("Deomon", "the activity is resume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("Deomon", "the activity is pause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("Deomon", "the activity is stop");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("Deomon", "the activity is destory");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Context context = getApplicationContext();
		if(context == this) {
			Log.i("Eric", "是当前的context");
		}else {
			Log.i("Eric", "不是当前context");
		}
		
		TextView Tv2, Tv3;
		final TextView Tv1, Tv4, Tv5;
		Tv1 = (TextView) findViewById(R.id.one);
		Tv2 = (TextView) findViewById(R.id.two);
		Tv3 = (TextView) findViewById(R.id.three);
		Tv4 = (TextView) findViewById(R.id.four);
		Tv5 = (TextView) findViewById(R.id.circle);
	//	Tv5.setGravity();
		
		
		FrameLayout f1;
		f1 = (FrameLayout) findViewById(R.id.frame1);
		
		
/*		FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(10, 10);
		f1.setLayoutParams(flp);*/
		
		RelativeLayout rel = (RelativeLayout)findViewById(R.id.relative2);
		RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(10, 10);
		rl.addRule(RelativeLayout.CENTER_HORIZONTAL, R.id.relative2);
		
		
		TextView userName = (TextView) findViewById(R.id.userName);
		userName.setLayoutParams(rl);
		
		/*TextView userMessage = (TextView) findViewById(R.id.userMessage);
		userMessage.setLayoutParams(rl);*/
		
		LinearLayout ll;
		ll = (LinearLayout)findViewById(R.id.linear1);
		TextView newtv = new TextView(this);
		newtv.setHeight(100);
		newtv.setWidth(100);
	//	newtv.setBackgroundColor(Color.BLUE);
		newtv.setText("This is a new TextView");
		ll.addView(newtv);
		Tv4.setTextSize(60);

		Tv1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Tv1.setText("hello, this world");

			}
		});
		Tv1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					Tv1.setTextColor(Color.parseColor("#C1CDCD"));
					break;
				case MotionEvent.ACTION_UP:
					Tv1.setTextColor(Color.parseColor("#9932CC"));
					break;
				}
				Log.d("Eric", "123");
				Log.i("Eric", "int");
				return true;

			}
		});

		// int i = 0;

		Tv1.setText("Hello, this beautiful world!");
		Tv2.setText("哈哈哈哈哈啊哈哈哈");

		Tv1.setTextSize(80);// 默认单位是px

		Timer timer = new Timer();
		/*
		 * TimerTask timertask = new TimerTask() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub String str =
		 * Tv4.getText().toString(); i++;
		 * 
		 * } };
		 */
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String now = Tv4.getText().toString();
				if (now.length() >= 6) {
					now = "";
				}
				final String str = now + ".";
				Tv4.post(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Tv4.setText(str);
					}

				});

			}
		}, 1000, 200);
		Log.d("Eric", "123");
		Log.i("Eric", "int");
		
		LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
		linear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent messageIntent = new Intent();
				messageIntent.setClass(MainActivity.this, MessageActivity.class);
				messageIntent.putExtra("userName", "杨振华");
				MainActivity.this.startActivityForResult(messageIntent, REQUEST_CODE);
			}
		});
		
		
		
	}
	
//双击退出
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		if(event.getKeyCode() == KeyEvent.ACTION_UP && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			if(!mBackKeyPressed) {
				Toast.makeText(MainActivity.this, "Please press the back key again", Toast.LENGTH_LONG);
				mBackKeyPressed = true;
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						mBackKeyPressed = false;
					}
				}, 3000);
			}else {
				this.finish();
				System.exit(0);
			}
		}
		return super.dispatchKeyEvent(event);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		String chat_content = data.getStringExtra("chat_content");
	}
	

}
