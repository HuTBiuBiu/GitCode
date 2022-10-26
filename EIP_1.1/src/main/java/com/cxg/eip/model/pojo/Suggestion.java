package com.cxg.eip.model.pojo;

import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
public class Suggestion {
	int id;
	String head;
	String date;
	
	public Suggestion() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
