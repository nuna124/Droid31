package com.example.smsresponder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class Responder extends BroadcastReceiver implements LocationListener {

	
	private LocationManager locman;
	private Criteria criteria;
	private String provider;
	private Location location;
	
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		
		locman = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        
        
        criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
        
        provider = locman.getBestProvider(criteria, false);
        
        locman.requestLocationUpdates(provider, 1, 10, this);
        location = locman.getLastKnownLocation(provider);
        
		   				

		   String lat = String.format("%.3f", location.getLatitude());
		   String lng = String.format("%.3f", location.getLongitude());
		
		try
		{
			Bundle b = arg1.getExtras();
			Object[] pdus = (Object[]) b.get("pdus");
		
				for(int i = 0 ; i<pdus.length ; i++)
				{
					SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdus[i]);
					String senderNumber = sms.getDisplayOriginatingAddress();
					String msg = sms.getDisplayMessageBody();
					
				
					
					   
					Toast.makeText(arg0, "Sender: " +senderNumber+ "\nMessage:"+msg, Toast.LENGTH_LONG).show();
					
					SmsManager mngr = SmsManager.getDefault();
					//mngr.sendTextMessage(senderNumber, scAddress, text, sentIntent, deliveryIntent)
					
					 
					
					
						mngr.sendTextMessage(senderNumber, "", "hi sad"+lat, null, null);
					
					/*if(msg == "i love you!")
					{
						mngr.sendTextMessage(senderNumber, "", "Hoy! uyab ni niya! kinsa mn ka?"+msg, null, null);
					}*/
					
					//mngr.sendTextMessage(senderNumber, "", "Hoy! uyab ni niya! kinsa mn ka?"+msg, null, null);
					//else mngr.sendTextMessage(senderNumber, "", "Hoy! Kung dili gani ka mo undang PATYA", null, null);
													
					//mngr.sendTextMessage(destinationAddress, scAddress, text, sentIntent, deliveryIntent)				
				}
				
		}
		
		catch(Exception e)
		{
			Log.e("SMSResponder", e.getMessage());
			Log.d("provider", provider);
		}

	}


	private LocationManager getSystemService(String locationService) {
		// TODO Auto-generated method stub
		return null;
	}


	/*private LocationManager getSystemService(String locationService) {
		// TODO Auto-generated method stub
		return null;
	}
*/

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
