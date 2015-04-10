package com.example2.colorblind;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class PcolorweaknessActivity extends TabActivity implements OnGestureListener{
	
	Intent intent;
	TabHost tab;
	GestureDetector gesture;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
/*		setContentView(R.layout.activity_pcolorweakness);*/
		MyApplication.getInstance().addActivity(this);
		tab = getTabHost();
		
		TabHost.TabSpec spec01 = tab.newTabSpec("introduce");
		spec01.setIndicator("¼ò½é");
		intent = new Intent(PcolorweaknessActivity.this,Introduce.class);
		intent.putExtra("key", 7);
		spec01.setContent(intent);
		tab.addTab(spec01);
		
		TabHost.TabSpec spec02 = tab.newTabSpec("introduce");
		spec02.setIndicator("²âÊÔ");
		intent = new Intent(PcolorweaknessActivity.this,Test.class);
		intent.putExtra("key", 7);
		spec02.setContent(intent);
		tab.addTab(spec02);
		
		tab.setCurrentTab(0);
		gesture = new GestureDetector(this);
	}
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		//ÏòÓÒ»¬¶¯
		if((e2.getX()-e1.getX())>50 && Math.abs(velocityX) > 5){
			lastPage();
			return true;
		}
		//Ïò×ó»¬¶¯
		else if((e1.getX()-e2.getX())>50 && Math.abs(velocityX) > 5){
			nextPage();
			return true;
		}	
		return true;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gesture.onTouchEvent(event);
	}
	private void nextPage(){
		int i = tab.getCurrentTab();
		if(i==0)
			tab.setCurrentTab(1);
	}
	
	private void lastPage(){
		int i = tab.getCurrentTab();
		if(i == 1)
			tab.setCurrentTab(0);
	}
	
}
