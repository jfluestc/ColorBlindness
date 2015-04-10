package com.example2.colorblind;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {
	private List<Activity> mylist = new LinkedList<Activity>();
	private static MyApplication instance;
	
	private MyApplication(){
	}
	public synchronized static MyApplication getInstance(){
		if(instance == null)
			instance = new MyApplication();
		return instance;
	}
	public void addActivity(Activity activity){
		mylist.add(activity);
	}
	public void exit(){
		for(Activity activity:mylist){
			if(activity!=null)
				activity.finish();
		}
		System.exit(0);
	}
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		System.gc();
	}
	

	
}
