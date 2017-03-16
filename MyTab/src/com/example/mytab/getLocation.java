package com.example.mytab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class getLocation extends Activity {
	TextView lat,lng;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.lat = (TextView) this.findViewById(R.id.editText1);
		this.lng = (TextView) this.findViewById(R.id.editText2);
		
		
		
		Bundle b = this.getIntent().getExtras();
			String lat = b.getString("lati");
			String lng = b.getString("longi");
	
		
		
	this.lat.setText(lat);
	this.lng.setText(lng);
		
	}
	
	

}
