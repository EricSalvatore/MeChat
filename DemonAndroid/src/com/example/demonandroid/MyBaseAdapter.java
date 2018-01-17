package com.example.demonandroid;

import java.util.ArrayList;

import com.example.application.MyMessage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter {

	private ArrayList<MyMessage> messageList;
	private Context myContext;
	
	public MyBaseAdapter(ArrayList<MyMessage> mList, Context c) {
		this.messageList = mList;
		myContext = c;
	}

	public View getTextView(View view) {
		return view;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//返回数据的条目和数量
		return messageList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return messageList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		//系统自己识别，不需要手动调用，底层实现
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null) {
//			 convertView = new View(this.myContext);
			convertView = createView(parent);
		}
		
		bindViewWithData(position, convertView);
		
		return convertView;
	}
	
	public View createView(ViewGroup parent) {
		 View convertView = LayoutInflater.from(myContext).inflate(R.layout.son_list_view, parent, false);
		 return convertView;
	}
	
	public void bindViewWithData(int position, View convertView) {
		ViewHolder viewHolder = new ViewHolder();
		viewHolder.userName = (TextView) convertView.findViewById(R.id.userNaming);
		viewHolder.messageTime = (TextView) convertView.findViewById(R.id.messageTime);
		viewHolder.userMessage = (TextView) convertView.findViewById(R.id.userMessage);
		viewHolder.img1 = (ImageView) convertView.findViewById(R.id.img1);
		
		viewHolder.userName.setText(messageList.get(position).getName());
		viewHolder.messageTime.setText(messageList.get(position).getTime());
		viewHolder.userMessage.setText(messageList.get(position).getChatContent());
		viewHolder.img1.setBackgroundResource(messageList.get(position).getPortraitId());
	}
	
	class ViewHolder{
		TextView userName, messageTime, userMessage;
		ImageView img1;
	}
	
	public void updateData() {
		
	}
	
	public void OnClick(int position, View convertView) {
		ViewHolder viewHolder = new ViewHolder();
		viewHolder.userName = (TextView) convertView.findViewById(R.id.userName);
		viewHolder.userName.setText(messageList.get(position).getName());
		this.notifyDataSetChanged();
	}

}
