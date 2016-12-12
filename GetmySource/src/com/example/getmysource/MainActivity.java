package com.example.getmysource;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	GridView gv;
	ArrayList<Integer> list = new ArrayList<Integer>();
	GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.gv = (GridView) this.findViewById(R.id.gridView1);
        
        list.add(R.drawable.img1);
        list.add(R.drawable.img2);
        list.add(R.drawable.img3);
        list.add(R.drawable.img4);
        list.add(R.drawable.img5);
        list.add(R.drawable.img6);
        list.add(R.drawable.img7);
        list.add(R.drawable.img8);
        list.add(R.drawable.img9);
        list.add(R.drawable.img10);
        list.add(R.drawable.img11);
        list.add(R.drawable.img12);
        list.add(R.drawable.img13);
        
        this.gv.setAdapter(adapter);
        
        this.gv.setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		String [] names = this.getResources().getStringArray(R.array.psits);
			
		AlertDialog.Builder build = new AlertDialog.Builder(this);
		build.setTitle("Selected ITEM");
		build.setMessage(names[arg2]);
		build.setNeutralButton("OK",null);
					
		AlertDialog dialog=build.create();
			dialog.show();
		
				
	}
}
