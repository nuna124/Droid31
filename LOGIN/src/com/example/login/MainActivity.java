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

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText user , pass;
	Button login;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.user = (EditText) this.findViewById(R.id.editText1);
        this.pass = (EditText) this.findViewById(R.id.editText2);
        this.login = (Button) this.findViewById(R.id.button1);
        
        
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        	this.login.setOnClickListener(this);
        	
    }

	@Override
	public void onClick(View v) {
		String username = this.user.getText().toString();
		String password = this.pass.getText().toString();
		
		try{
			URL url = new URL("http://10.0.2.2/MyAndroidServer/login.php?username="+username+"&password="+password);
			//URL url = new URL("http://10.0.2.2/MyAndroidServer/login.php?username="+username+"&password="+password);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream is = conn.getInputStream();
			
			int c = 0;
			StringBuffer sb = new StringBuffer();
				while((c = is.read()) != -1)
				{
					sb.append((char)c);
				}
				
				Toast.makeText(this, sb.append(is), Toast.LENGTH_SHORT).show();
				
				if(sb.append(is).equals("Login Accepted"))
				{
					Intent intent = new Intent(this,ACCEPTEDlog.class);
					this.startActivity(intent);
				}
				is.close();
				conn.disconnect();	
				
				//mag buhat ug menu layout
				//menu ang unahon
				/*AlertDialog.Builder builder = new AlertDialog.Builder(this);
						builder.setTitle("http response");
						builder.setMessage(sb.toString());
						builder.setNeutralButton("OK", null);
					
					AlertDialog dialog = builder.create();
						dialog.show();
					*/
				//INTENT na ang buhatonon!!!!!
					
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			this.user.setText("");
			this.pass.setText("");
			this.user.requestFocus();
	}    
}
