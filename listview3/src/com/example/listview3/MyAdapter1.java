package com.example.listview3;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter1 extends BaseAdapter {

	Context con;
	ArrayList<Student> student;
	LayoutInflater inflater;
	

	public MyAdapter1(Context con, ArrayList<Student> student) {
		super();
		this.con = con;
		this.student = student;
		this.inflater = LayoutInflater.from(con);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return student.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return student.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		StudentHandler handler = null;
			if(arg1 == null)
			{
				arg1 = inflater.inflate(R.layout., null);
				handler = new StudentHandler();
				//handler.iv = arg1.findViewById(R.id.)
			}
			
		return arg1;
	}

	static class StudentHandler
	{
		ImageView iv;
		TextView name;
		TextView course;
	}
}
