package com.example.crudlist_db;

import android.net.Uri;

public class Person {
	
	private Uri ImageUri;
	private String name;
	public Person(Uri imageUri, String name) {
		super();
		ImageUri = imageUri;
		this.name = name;
	}
	
	public Uri getImageUri() {
		return ImageUri;
	}
	public void setImageUri(Uri imageUri) {
		ImageUri = imageUri;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
	
}
