package com.example.getmysource;

public class Student {

		private int image;
		private String StudentName;
		private String coure;
		public Student(int image, String studentName, String coure) {
			super();
			this.image = image;
			StudentName = studentName;
			this.coure = coure;
		}
		public int getImage() {
			return image;
		}
		public void setImage(int image) {
			this.image = image;
		}
		public String getStudentName() {
			return StudentName;
		}
		public void setStudentName(String studentName) {
			StudentName = studentName;
		}
		public String getCoure() {
			return coure;
		}
		public void setCoure(String coure) {
			this.coure = coure;
		}
}
