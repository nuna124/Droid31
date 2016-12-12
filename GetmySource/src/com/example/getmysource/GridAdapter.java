package com.example.getmysource;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
public class GridAdapter extends BaseAdapter {

	Context conT;
	ArrayList<Integer> list;
	LayoutInflater inflater;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}



	public GridAdapter(Context conT, ArrayList<Integer> list) {
		super();
		this.conT = conT;
		this.list = list;
		//this.student = student;
		this.inflater = LayoutInflater.from(conT);
	}


	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}



	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
