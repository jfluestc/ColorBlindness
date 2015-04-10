package com.example2.colorblind;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class BYblindnessActivity extends TabActivity{
	
	GestureDetector gesture;
	TabHost tab;
	private static final float XLENGTH=50;
	private static final float XVELOCITY=5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		MyApplication.getInstance().addActivity(this);
		
/*		setContentView(R.layout.activity_byblindness);*/
		tab = getTabHost();
		Intent intent1,intent2;
		Bundle bundle = new Bundle();
		bundle.putInt("key", 4);
/*		tab = (TabHost)findViewById(R.id.tabhost2);*/

		
		TabHost.TabSpec spec = tab.newTabSpec("introduce");
		spec.setIndicator("���");
		intent1 = new Intent(BYblindnessActivity.this,Introduce.class);
		intent1.putExtras(bundle);
		spec.setContent(intent1);
		tab.addTab(spec);
		
		TabHost.TabSpec spec2 = tab.newTabSpec("test");
		spec2.setIndicator("����");
		intent2 = new Intent(BYblindnessActivity.this,Test.class);
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
			//���һ���
			if((e2.getX()-e1.getX())>XLENGTH && Math.abs(velocityX) > XVELOCITY){
				lastPage();
			}
			//���󻬶�
			if((e1.getX()-e2.getX())>XLENGTH && Math.abs(velocityX) > XVELOCITY){
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
	private void nextPage(){
		int i = tab.getCurrentTab();
		if(i == 0)
			tab.setCurrentTab(1);
	}
	private void lastPage(){
		int i = tab.getCurrentTab();
		if(i ==1)
			tab.setCurrentTab(0);
	}
}
