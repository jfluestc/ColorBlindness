package com.example2.colorblind;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class ColoragainstActivity extends TabActivity {

	GestureDetector gesture;
	TabHost tab;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		MyApplication.getInstance().addActivity(this);
		
		tab = getTabHost();
		Intent intent1,intent2;
		Bundle bundle = new Bundle();
		bundle.putInt("key", 5);
/*		tab = (TabHost)findViewById(R.id.tabhost2);*/

		
		TabHost.TabSpec spec = tab.newTabSpec("introduce");
		spec.setIndicator("¼ò½é");
		intent1 = new Intent(ColoragainstActivity.this,Introduce.class);
		intent1.putExtras(bundle);
		spec.setContent(intent1);
		tab.addTab(spec);
		
		TabHost.TabSpec spec2 = tab.newTabSpec("test");
		spec2.setIndicator("²âÊÔ");
		intent2 = new Intent(ColoragainstActivity.this,Test.class);
		intent2.putExtras(bundle);
		spec2.setContent(intent2);
		tab.addTab(spec2);
		
		tab.setCurrentTab(0);
		
		gesture = new GestureDetector(ges);
	}
	private OnGestureListener ges = new OnGestureListener(){

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
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
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
			if((e2.getX()-e1.getX())>50 && Math.abs(velocityX)>5){
				lastPage();
				return true;
			}
			//Ïò×ó»¬¶¯
			if((e1.getX()-e2.getX())>50 && Math.abs(velocityX)>5){
				nextPage();
				return true;
			}
			return true;
		}
		
	};
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gesture.onTouchEvent(event);
	}
	private void lastPage(){
		int i = tab.getCurrentTab();
		if(i == 1)
			tab.setCurrentTab(0);
	}
	private void nextPage(){
		int i = tab.getCurrentTab();
		if(i == 0)
			tab.setCurrentTab(1);
	}

}
