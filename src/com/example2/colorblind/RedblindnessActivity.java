package com.example2.colorblind;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class RedblindnessActivity extends TabActivity {
	
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
/*		setContentView(R.layout.activity_redblindness);
		
		TabHost tab = (TabHost)findViewById(R.id.tabhost02);
		tab.setup(getLocalActivityManager());
		Intent intent;
		
		TabHost.TabSpec spec = tab.newTabSpec("introduce");
		spec.setIndicator("ºÚΩÈ");
		intent = new Intent(RedblindnessActivity.this,Introduce.class);
		intent.putExtra("key", 2);
		spec.setContent(intent);
		tab.addTab(spec);
		
		TabHost.TabSpec spec02 = tab.newTabSpec("test");
		spec02.setIndicator("≤‚ ‘");
		intent = new Intent(RedblindnessActivity.this,Test.class);
		intent.putExtra("key", 2);
		spec02.setContent(intent);
		tab.addTab(spec02);
		
		tab.setCurrentTab(1);*/
		TabHost tab = getTabHost();
		
		TabHost.TabSpec spec01 = tab.newTabSpec("introduce");
		spec01.setIndicator("ºÚΩÈ");
		intent = new Intent(RedblindnessActivity.this,Introduce.class);
		intent.putExtra("key", 2);
		spec01.setContent(intent);
		tab.addTab(spec01);
		
		TabHost.TabSpec spec02 = tab.newTabSpec("test");
		spec02.setIndicator("≤‚ ‘");
		intent = new Intent(RedblindnessActivity.this,Test.class);
		intent.putExtra("key", 2);
		spec02.setContent(intent);
		tab.addTab(spec02);
		
		tab.setCurrentTab(0);
	}
}
