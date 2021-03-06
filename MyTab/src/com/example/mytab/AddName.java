package com.example.mytab;

//import com.example.locationservice.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddName extends Activity implements OnClickListener, LocationListener {

	EditText lat , lng;
	Button ok,cancel;
	private LocationManager locman;
	private Criteria criteria;
	private String provider;
	private Location location;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.addname);
		
		locman = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        
        
        criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
        
        provider = locman.getBestProvider(criteria, false);
        
        locman.requestLocationUpdates(provider, 1, 10, this);
        location = locman.getLastKnownLocation(provider);
        
        lat = (EditText) this.findViewById(R.id.editText1);
        lng = (EditText) this.findViewById(R.id.editText2);
        
        this.ok = (Button) this.findViewById(R.id.button1);
        this.cancel = (Button) this.findViewById(R.id.button2);
        
        this.ok.setOnClickListener(this);
        this.cancel.setOnClickListener(this);

		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
		switch(id)
		{
			case R.id.button1: location = locman.getLastKnownLocation(provider);
							   Log.d("provider", provider);		
			
							   String lat = String.format("%.3f", location.getLatitude());
							   String lng = String.format("%.3f", location.getLongitude());
			   
							   
							   
							   this.lat.setText(lat);
							   this.lng.setText(lng);
							   
							   Intent intent = new Intent(this,getLocation.class);
								   intent.putExtra("lati", lat);
								   intent.putExtra("longi", lng);
							   this.startActivity(intent);
							   
				break;
			case R.id.button2: this.lat.setText("");
							   this.lng.setText("");
							   this.lat.requestFocus();
				break;
		
		}
		
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}

	
	
}
