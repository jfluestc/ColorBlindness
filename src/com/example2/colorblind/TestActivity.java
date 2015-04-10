package com.example2.colorblind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TestActivity extends Activity{

	TextView tv01,tv02,tv03,tv04,tv05,tv06,tv07;
	GestureDetector gesture;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		MyApplication.getInstance().addActivity(this);
		
		
		tv01 = (TextView)findViewById(R.id.monochromasiaTV);
		tv02 = (TextView)findViewById(R.id.redblindnessTV);
		tv03 = (TextView)findViewById(R.id.greenblindnessTV);
		tv04 = (TextView)findViewById(R.id.BYblindnessTV);
		tv05 = (TextView)findViewById(R.id.coloragainstTV);
		tv06 = (TextView)findViewById(R.id.colorweaknessTV);
		tv07 = (TextView)findViewById(R.id.PcolorweaknessTV);
		
		tv01.setOnClickListener(listener);
		tv02.setOnClickListener(listener);
		tv03.setOnClickListener(listener);
		tv04.setOnClickListener(listener);
		tv05.setOnClickListener(listener);
		tv06.setOnClickListener(listener);
		tv07.setOnClickListener(listener);
		
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
			Intent intent = new Intent();
			//ÏòÓÒ»¬¶¯
			if((e2.getX()-e1.getX())>50 && Math.abs(velocityX) > 1){
				intent.setClass(TestActivity.this,MainActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.left_in,R.anim.right_out);
			}
			return true;
		}
		
	};
	
	private OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			TextView tv = (TextView)v;
			switch(tv.getId()){
			case R.id.monochromasiaTV:
				intent.setClass(TestActivity.this, MonochromasiaActivity.class);
				startActivity(intent);
				break;
			case R.id.redblindnessTV:
				intent.setClass(TestActivity.this,RedblindnessActivity.class);
				startActivity(intent);
				break;
			case R.id.greenblindnessTV:
				intent.setClass(TestActivity.this,GreenblindnessActivity.class);
				startActivity(intent);
				break;
			case R.id.BYblindnessTV:
				intent.setClass(TestActivity.this,BYblindnessActivity.class);
				startActivity(intent);
				break;
			case R.id.coloragainstTV:
				intent.setClass(TestActivity.this,ColoragainstActivity.class);
				startActivity(intent);
				break;
			case R.id.colorweaknessTV:
				intent.setClass(TestActivity.this,ColorweaknessActivity.class);
				startActivity(intent);
				break;
			case R.id.PcolorweaknessTV:
				intent.setClass(TestActivity.this,PcolorweaknessActivity.class);
				startActivity(intent);
				break;
		    default:
		    	break;
			}
		}
		
	};
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return gesture.onTouchEvent(event);
	}

}
