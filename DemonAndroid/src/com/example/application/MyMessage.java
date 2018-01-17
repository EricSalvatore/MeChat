package com.example.application;

public class MyMessage {
	private int messageStates;
	private int userId;
	private int portraitId;
	private String name;
	private String chatContent;
	private String time;
	private int messageNum;
	
	
	@Override
	public String toString() {
		return "Message [messageStates=" + messageStates + ", userId=" + userId + ", portraitId=" + portraitId
				+ ", name=" + name + ", cahtContent=" + chatContent + ", time=" + time + ", messageNum=" + messageNum
				+ "]";
	}
	
	public int getMessageStates() {
		return messageStates;
	}
	public void setMessageStates(int messageStates) {
		this.messageStates = messageStates;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPortraitId() {
		return portraitId;
	}
	public void setPortraitId(int portraitId) {
		this.portraitId = portraitId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
	public MyMessage(int messageStates, int userId, int portraitId, String name, String chatContent, String time,
			int messageNum) {
		super();
		this.messageStates = messageStates;
		this.userId = userId;
		this.portraitId = portraitId;
		this.name = name;
		this.chatContent = chatContent;
		this.time = time;
		this.messageNum = messageNum;
	}

	public MyMessage(int portraitId, String name, String chatContent, String time) {
		super();
		this.portraitId = portraitId;
		this.name = name;
		this.chatContent = chatContent;
		this.time = time;
	}
}
