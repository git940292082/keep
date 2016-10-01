package com.example.keep;

import java.util.HashMap;
import java.util.Map;

import org.xutils.x;
import org.xutils.view.annotation.ViewInject;

import com.example.keep.fragmet.FindFram;
import com.example.keep.fragmet.RunFram;
import com.example.keep.untils.ExceptionHandler;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
public class MainActivity extends FragmentActivity {
	@ViewInject(R.id.main_fram)
	FrameLayout fram;
	@ViewInject(R.id.main_groaup)
	RadioGroup group;
	@ViewInject(R.id.radio1)
	RadioButton rd1;
	@ViewInject(R.id.radio2)
	RadioButton rd2;
	private Map<Integer, Fragment> mapFram;
	private Fragment fragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		x.view().inject(this);
		try {
			setListener();

			setData();

		} catch (Exception e) {
			// TODO: handle exception
			ExceptionHandler.handlerException(e);
		}
	}
	private void setListener() {
		// TODO Auto-generated method stub
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				show(checkedId);
			}
		});
	}
	private void setData() {
		// TODO Auto-generated method stub
		mapFram=new HashMap<Integer, Fragment>();
		mapFram.put(rd1.getId(), new RunFram());
		mapFram.put(rd2.getId(), new FindFram());
		show(rd1.getId());
	}
	private void show(int checkedId) {
		try {
			FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
			if(fragment!=null){
				transaction.hide(fragment);
			}
			Fragment fragment=mapFram.get(checkedId);
			if(!fragment.isAdded()){
				transaction.add(R.id.main_fram, mapFram.get(checkedId));
			}
			transaction.show(fragment);
			transaction.commit();
			this.fragment=fragment;
		} catch (Exception e) {
			// TODO: handle exception
			ExceptionHandler.handlerException(e);
		}
	
	}
}
