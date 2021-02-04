package com.reader.bean;

public class Header {
	
	private String tag;
	private String text;
	
	public Header() {
	}
	
	
	public Header(String tag, String text) {
		super();
		this.tag = tag;
		this.text = text;
	}


	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
