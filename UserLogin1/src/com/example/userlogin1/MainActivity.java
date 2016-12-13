package com.example.userlogin1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
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
        
        this.login.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		String userName = this.user.getText().toString();
		String passWord = this.pass.getText().toString();
		
		if((userName.equals("admin")) && (passWord.equals("helloworld")))
		{
			AlertDialog.Builder build = new AlertDialog.Builder(this);
			build.setMessage("SUCCESS");
			build.setNeutralButton("OK", null);
			
			AlertDialog dialog = build.create();
			dialog.show();
			user.setText("");
			pass.setText("");
			
		}
		else
		{
			AlertDialog.Builder build = new AlertDialog.Builder(this);
			build.setTitle("Error");
			build.setMessage("Incorrect Password or Username");
			build.setNeutralButton("OK", null);
			
			AlertDialog dialog = build.create();
			dialog.show();
	
		}
	}
    
}
