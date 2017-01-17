package com.example.crudlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends Activity implements OnClickListener {

	EditText name;
	Button save , cancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.updateitem);
		
		this.name = (EditText) this.findViewById(R.id.editText1);
		this.save = (Button) this.findViewById(R.id.button1);
		this.cancel = (Button) this.findViewById(R.id.button2);
		
		this.save.setOnClickListener(this);
		this.cancel.setOnClickListener(this);
		
		Intent intent = this.getIntent();
		Bundle b = intent.getExtras();
			if(b != null)
			{
				String updatename = b.getString("updatename");
				this.name.setText(updatename);
			}
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int id = arg0.getId();
			switch(id)
			{
				case R.id.button1:
					String nm = this.name.getText().toString();
					Intent intent = new Intent();
					intent.putExtra("myname", nm);
					this.setResult(Activity.RESULT_OK, intent);
					
				case R.id.button2:
					this.finish();
			}
		
	}

	
	
}
