package com.example.listview3;

public class Student {
	
	private int image;
	private String stdName;
	private String course;
	
	public Student(int image, String stdName, String course) {
		super();
		this.image = image;
		this.stdName = stdName;
		this.course = course;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
}
