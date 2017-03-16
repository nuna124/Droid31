package com.example.crudlist_db;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class updatePerson extends Activity implements OnClickListener {

	ImageView iv;
	EditText name;
	Button save , cancel;
	Uri uri;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.updatelayout);
		
		this.iv = (ImageView) this.findViewById(R.id.imageView1);
		this.name = (EditText) this.findViewById(R.id.editText1);
		this.save = (Button) this.findViewById(R.id.button1);
		this.cancel = (Button) this.findViewById(R.id.button2);
		
		this.save.setOnClickListener(this);
		this.cancel.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
			switch(id)
			{
			case R.id.imageView1: 
				//Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				this.startActivityForResult(intent, 111);
								
				break;
				
				
			case R.id.button1: 
				String Name = this.name.getText().toString();
					
					if(uri != null && !Name.equals(""))
					{
						intent = new Intent();
						intent.putExtra("image", uri);
						intent.putExtra("name", Name);
						this.setResult(Activity.RESULT_OK, intent);
						
					}
					else Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_SHORT).show();			
					
				break;
				
				
			case R.id.button2:
				this.finish();
				
				 break;
			
			}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		uri = data.getData();
		this.iv.setImageURI(uri);
	}
}
