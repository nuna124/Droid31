package com.example.login;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class ACCEPTEDlog extends Activity {
	
	ListView lv;
	ItemAdapter adapter;
	ArrayList<Student> list = new ArrayList<Student>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.lv = (ListView) this.findViewById(R.id.listView1);
        adapter = new ItemAdapter(this,list);
        this.lv.setAdapter(adapter);
        
        try {
			URL url = new URL("http://10.0.2.2/androidweb/listforandroid.php");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream is = conn.getInputStream();
			StringBuffer sb = new StringBuffer();
			int c = 0;
				while((c = is.read()) != -1)
				{
					sb.append((char)c);
				}
					is.close();
					conn.disconnect();
					
					String jsonstring = sb.toString();
					
					JSONObject json = new JSONObject(jsonstring);
					JSONArray sArray = new JSONArray("student");
					
						for(int i = 0 ; i<sArray.length() ; i++)
						{
							JSONObject student = (JSONObject) sArray.get(i);
							Student s = new Student();
								s.setIdno(student.getString("idno"));
								s.setLName(student.getString("LName"));
								s.setFName(student.getString("FName"));
								s.setCourse(student.getString("course"));
								s.setYearlvl(student.getString("yearlvl"));
								s.setCampus(student.getString("campus"));
								list.add(s);
						}
						
					adapter.notifyDataSetChanged();
					
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		
		
		return super.onCreateOptionsMenu(menu);
	}
}
