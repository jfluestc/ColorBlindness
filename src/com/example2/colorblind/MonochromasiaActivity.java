package com.example2.colorblind;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MonochromasiaActivity extends TabActivity implements OnGestureListener{
	
	GestureDetector gesture;
	TabHost tab;
	private static final float XLENGTH=50;
	private static final float XVELOCITY=5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
/*		setContentView(R.layout.activity_monochromasia);*/
		MyApplication.getInstance().addActivity(this);
		
		Intent intent1,intent2;
		Bundle bundle = new Bundle();
		bundle.putInt("key", 1);
/*		tab = (TabHost)findViewById(R.id.tabhost2);*/
		tab = getTabHost();
		gesture = new GestureDetector(this);
		
		TabHost.TabSpec spec = tab.newTabSpec("introduce");
		spec.setIndicator("¼ò½é");
		intent1 = new Intent(MonochromasiaActivity.this,Introduce.class);
		intent1.putExtras(bundle);
		spec.setContent(intent1);
		tab.addTab(spec);
		
		TabHost.TabSpec spec2 = tab.newTabSpec("test");
		spec2.setIndicator("²âÊÔ");
		intent2 = new Intent(MonochromasiaActivity.this,Test.class);
		intent2.putExtras(bundle);
		spec2.setContent(intent2);
		tab.addTab(spec2);
		
		tab.setCurrentTab(0);
			
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
		if((e2.getX()-e1.getX())>XLENGTH && Math.abs(velocityX) > XVELOCITY){
			lastPage();
			return true;
		}
		//Ïò×ó»¬¶¯
		else if((e1.getX()-e2.getX())>XLENGTH && Math.abs(velocityX) > XVELOCITY){
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
