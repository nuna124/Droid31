package com.example.mytab;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	TabHost tabhost;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        tabhost = this.getTabHost();
        
        Intent listIntent = new Intent(this, NameList.class);
        Intent addIntent = new Intent(this, AddName.class);
        
        Drawable listicon = this.getResources().getDrawable(R.drawable.list);
        Drawable locicon = this.getResources().getDrawable(R.drawable.fireeagle_location);
        
        TabSpec namelist = tabhost.newTabSpec("namelist");
        	namelist.setIndicator("", listicon);
        	namelist.setContent(listIntent);
        	
        TabSpec addlist = tabhost.newTabSpec("addlist");
        	addlist.setIndicator("", locicon);
        	addlist.setContent(addIntent);
        	
        tabhost.addTab(namelist);
        tabhost.addTab(addlist);
        
        
    }
}
