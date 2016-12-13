package com.example.studentinfo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {

	EditText idno;
	EditText userN;
	RadioGroup sex;
	Spinner course;
	Button ok , cancel;
	private String selected_course;
	private int Ssex;
	

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        idno = (EditText) this.findViewById(R.id.editText1);
        userN = (EditText) this.findViewById(R.id.editText2);
        sex = (RadioGroup) this.findViewById(R.id.radioGroup1);
        course = (Spinner) this.findViewById(R.id.spinner1);
        ok = (Button) this.findViewById(R.id.button1);
        cancel = (Button) this.findViewById(R.id.button2);
        
        ///////
        ok.setOnClickListener(this);   
        cancel.setOnClickListener(this);
        //////
        course.setOnItemSelectedListener(this);
        //////
        Ssex = sex.getCheckedRadioButtonId();
        
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
		int id = arg0.getId();
			switch(id)
			{
				case R.id.button1: 
									String idN = idno.getText().toString();
									String nm = userN.getText().toString();
										if(idN.equals("") && nm.equals(""))
										{
											Toast.makeText(this, "Fill ID number and Name" , Toast.LENGTH_SHORT).show();
										}
										else
										{
											RadioButton sexB = (RadioButton) this.findViewById(Ssex);
											String mysex = sexB.getText().toString();
											
											String message = "Id number: "+idN+"\nName: "+nm+"\nSex: "+mysex+"Course: "+this.selected_course;
											
											AlertDialog.Builder build = new AlertDialog.Builder(this);
											build.setTitle("Student Information");
											build.setMessage(message);
											build.setNeutralButton("OK", null);
											
											AlertDialog dialog = build.create();
											dialog.show();
											
											
										}
										
									
									break;
				
				case R.id.button2: 
									idno.setText("");
									userN.setText("");
									sex.clearCheck();
									course.setSelection(0);
									break;
			
			}
		
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		selected_course = course.getItemAtPosition(arg2).toString();
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
