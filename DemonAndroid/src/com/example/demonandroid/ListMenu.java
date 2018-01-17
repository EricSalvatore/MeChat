package com.example.demonandroid;

import java.util.ArrayList;
import java.util.Date;

import com.example.application.MyMessage;

import android.R.array;
import android.R.drawable;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ListMenu extends Activity {
	private static int REQUEST_CODE = 10;
	private TextView showMessage;
	Date date = new Date();
	String dateStr = date.toString();
	MyMessage myMessage = new MyMessage(0, 0, com.example.demonandroid.R.drawable.ic_launcher, null, null, null, 0);

	ArrayList<String> arrayList = new ArrayList<String>(){
		{
			add("请输入姓名");
			add("请输入聊天内容");
		}
	};
	ArrayList<MyMessage> messageMenuList = new ArrayList<MyMessage>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_menu);
		
		
		final TextView userName = null;
		final TextView messageTime = null;
		final TextView userMessage = null;
		final ImageView img1 = null;
		final EditText inputedit = null;
	//	final Button enable = (Button) findViewById(R.id.enable);
		final TextView inputtitle = (TextView) findViewById(R.id.inputtitle);		
		/*enable.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//String userNameTemp = ((EditText) findViewById(R.id.inputedit)).toString();
				//userName.setText(userNameTemp);
				for(int num = 0; num<2; num++) {
					switch(num) {
					case 0:
						inputtitle.setText(arrayList.get(0));
						myMessage.setName(((EditText) findViewById(R.id.inputedit)).toString());
						break;
					case 1:
						inputtitle.setText(arrayList.get(1));
						myMessage.setUserId(Integer.parseInt(((EditText) findViewById(R.id.inputedit)).toString()));
						break;
					case 1:
						inputtitle.setText(arrayList.get(1));
						myMessage.setChatContent(((EditText) findViewById(R.id.inputedit)).toString());
						break;
					}
				}*/
/*				Date date = new Date();
				String dateStr = date.toString();*/
				
/*				myMessage.setTime(dateStr);
				messageMenuList.add(myMessage);
			}
		});*/
		MyMessage message1 = new MyMessage(0 ,0 ,com.example.demonandroid.R.drawable.ic_launcher , "name1", "sdasdasdasdasdasda", "9:34", 0);
		messageMenuList.add(message1);
		MyMessage message2 = new MyMessage(0 ,0 ,com.example.demonandroid.R.drawable.ic_launcher , "name1", "sdasdasdasdasdasda", "9:34", 0);
		messageMenuList.add(message2);
		MyMessage message3 = new MyMessage(0 ,0 ,com.example.demonandroid.R.drawable.ic_launcher , "name1", "sdasdasdasdasdasda", "9:34", 0);
		messageMenuList.add(message3);
		MyMessage message4 = new MyMessage(0 ,0 ,com.example.demonandroid.R.drawable.ic_launcher , "name1", "sdasdasdasdasdasda", "9:34", 0);
		messageMenuList.add(message4);
		
		MyBaseAdapter myBaseAdapter = new MyBaseAdapter(messageMenuList, this);
		final ListView listView = (ListView) findViewById(R.id.usermessagelist);
		listView.setAdapter(myBaseAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				view.findViewById(R.id.userNaming);
				intent.setClass(ListMenu.this, MessageActivity.class);
				intent.putExtra("pageId", "page1");
				startActivity(intent);
			}
		});
		Intent intent = new Intent();
		intent.setClass(ListMenu.this, MyMessage.class);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		String message = data.getStringExtra("message");
		showMessage.setText(message);
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	private void RegisterBroadcastReceiver() {
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("SEND_ACTION");
		this.registerReceiver(mBroadcastReceiver, intentFilter);
	}
	
	private void UnRegisterBroadcastReceiver() {
		this.unregisterReceiver(mBroadcastReceiver);
	}
	
	
	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
		}
	};
	
}
