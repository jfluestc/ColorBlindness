package com.example2.colorblind;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class PcolorweaknessActivity extends TabActivity {
	
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
/*		setContentView(R.layout.activity_pcolorweakness);*/
		TabHost tab = getTabHost();
		
		TabHost.TabSpec spec01 = tab.newTabSpec("introduce");
		spec01.setIndicator("ºÚΩÈ");
		intent = new Intent(PcolorweaknessActivity.this,Introduce.class);
		intent.putExtra("key", 7);
		spec01.setContent(intent);
		tab.addTab(spec01);
		
		TabHost.TabSpec spec02 = tab.newTabSpec("introduce");
		spec02.setIndicator("≤‚ ‘");
		intent = new Intent(PcolorweaknessActivity.this,Test.class);
		intent.putExtra("key", 7);
		spec02.setContent(intent);
		tab.addTab(spec02);
		
		tab.setCurrentTab(0);
	}
}
