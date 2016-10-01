package com.example.keep;

import org.xutils.x;

import com.baidu.mapapi.SDKInitializer;

import android.app.Application;
import android.content.Context;

public class App  extends Application{
	public static Context context;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		context=this;
		x.Ext.init(this);
		SDKInitializer.initialize(this);
		super.onCreate();
	}
}
