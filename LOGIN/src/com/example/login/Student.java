package com.example.login;

public class Student {

	String idno, LName, FName , course , yearlvl, campus;

	public Student(String idno, String lName, String fName, String course,
			String yearlvl, String campus) {
		super();
		this.idno = idno;
		LName = lName;
		FName = fName;
		this.course = course;
		this.yearlvl = yearlvl;
		this.campus = campus;
	}

	public Student()
	{}
	
	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYearlvl() {
		return yearlvl;
	}

	public void setYearlvl(String yearlvl) {
		this.yearlvl = yearlvl;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}
	
}
