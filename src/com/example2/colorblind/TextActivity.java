package com.example2.colorblind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TextActivity extends Activity {

	TextView tv01,tv02,tv03,tv04,tv05,tv06,tv07,tv08;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text);
		
		tv01 = (TextView)findViewById(R.id.monochromasiaTV);
		tv02 = (TextView)findViewById(R.id.redblindnessTV);
		tv03 = (TextView)findViewById(R.id.greenblindnessTV);
		tv04 = (TextView)findViewById(R.id.BYblindnessTV);
		tv05 = (TextView)findViewById(R.id.RGblindnessTV);
		tv06 = (TextView)findViewById(R.id.coloragainstTV);
		tv07 = (TextView)findViewById(R.id.colorweaknessTV);
		tv08 = (TextView)findViewById(R.id.PcolorweaknessTV);
		
		tv01.setOnClickListener(listener);
		tv02.setOnClickListener(listener);
		tv03.setOnClickListener(listener);
		tv04.setOnClickListener(listener);
		tv05.setOnClickListener(listener);
		tv06.setOnClickListener(listener);
		tv07.setOnClickListener(listener);
		tv08.setOnClickListener(listener);
	}
	
	private OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			TextView tv = (TextView)v;
			switch(tv.getId()){
			case R.id.monochromasiaTV:
				intent.setClass(TextActivity.this, MonochromasiaActivity.class);
				startActivity(intent);
				break;
			case R.id.redblindnessTV:
				intent.setClass(TextActivity.this,RedblindnessActivity.class);
				startActivity(intent);
				break;
			case R.id.greenblindnessTV:
				intent.setClass(TextActivity.this,GreenblindnessActivity.class);
				startActivity(intent);
				break;
			case R.id.BYblindnessTV:
				intent.setClass(TextActivity.this,BYblindnessActivity.class);
				startActivity(intent);
				break;
			case R.id.RGblindnessTV:
				intent.setClass(TextActivity.this,RGblindnessActivity.class);
				startActivity(intent);
				break;
			case R.id.coloragainstTV:
				intent.setClass(TextActivity.this,ColoragainstActivity.class);
				startActivity(intent);
				break;
			case R.id.colorweaknessTV:
				intent.setClass(TextActivity.this,ColorweaknessActivity.class);
				startActivity(intent);
				break;
			case R.id.PcolorweaknessTV:
				intent.setClass(TextActivity.this,PcolorweaknessActivity.class);
				startActivity(intent);
				break;
		    default:
		    	break;
			}
		}
		
	};

}
