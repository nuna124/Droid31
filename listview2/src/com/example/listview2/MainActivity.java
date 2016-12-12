package com.example.listview2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener, android.content.DialogInterface.OnClickListener {
	ListView lv;
	Button add;
	EditText addTxt;
	AlertDialog.Builder build;
	ArrayList <String> list = new ArrayList<String>();
	ArrayAdapter <String> adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        
        	this.lv = (ListView) this.findViewById(R.id.listView1);
        		this.lv.setAdapter(adapter);
        	
        	this.add = (Button) this.findViewById(R.id.button1);
        	
        	//////
        	this.add.setOnClickListener(this);
        	this.lv.setOnItemClickListener(this);
        	
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		AlertDialog.Builder bd = new AlertDialog.Builder(this);
		String s = this.lv.getItemAtPosition(arg2).toString();
		bd.setTitle("Selected Item");
		bd.setMessage(s);
		bd.setNeutralButton("OK", null);
		
			AlertDialog dialog = bd.create();
				dialog.show();
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		build = new AlertDialog.Builder(this);
		addTxt = new EditText(this);
			addTxt.setHint("Enter Name");
			build.setTitle("Add item");
			build.setView(addTxt);
			build.setPositiveButton("ok", this);
			build.setNegativeButton("cancel", this);
			
		AlertDialog dialog = build.create();
			dialog.show();
	}


	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1)
		{
			case DialogInterface.BUTTON_POSITIVE: 
				String s = this.addTxt.getText().toString();
					if(!s.equals(""))
					{
						list.add(s);
						this.adapter.notifyDataSetChanged();
						arg0.dismiss();
					}
					else
						Toast.makeText(this, "Type name", Toast.LENGTH_SHORT).show();
				break;
			case DialogInterface.BUTTON_NEGATIVE: 
					arg0.dismiss();
				
				
				break;
		
		}
			
	}


    
}
