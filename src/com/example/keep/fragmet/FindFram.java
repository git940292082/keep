package com.example.keep.fragmet;

import org.xutils.x;

import com.example.keep.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FindFram  extends Fragment{
	View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(view==null){
			view=inflater.inflate(R.layout.fram_find, null);
			x.view().inject(this,view);
			setListener();
			Log.i("≤‚ ‘", "FindFram");
			setData();
		}else{
			((ViewGroup) view.getParent()).removeView(view);
		}
		return view;
	}

	private void setListener() {
		// TODO Auto-generated method stub
		
	}
	private void setData() {
		// TODO Auto-generated method stub
		
	}
}
