package com.example.crudlist_db;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView lv;
	ArrayList<Person> list = new ArrayList<Person>();
	ItemAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.activity_main);
        
        this.lv = (ListView) this.findViewById(R.id.listView1);
        this.adapter = new ItemAdapter(this, list);
        this.lv.setAdapter(adapter);
    }

    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent(this,updatePerson.class);
		this.startActivityForResult(intent, 0);
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == 0 && resultCode == Activity.RESULT_OK)
		{
			Bundle b = data.getExtras();
			
			Uri uri = b.getParcelable("image");
			String name = b.getString("name");
			
			list.add(new Person(uri,name));
			this.adapter.notifyDataSetChanged();
		}
	
	}    
	
	
}
