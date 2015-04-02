package com.example2.colorblind;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class ColorweaknessActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TabHost tab = getTabHost();
		Intent intent1,intent2;
		Bundle bundle = new Bundle();
		bundle.putInt("key", 6);
/*		tab = (TabHost)findViewById(R.id.tabhost2);*/

		
		TabHost.TabSpec spec = tab.newTabSpec("introduce");
		spec.setIndicator("ºÚΩÈ");
		intent1 = new Intent(ColorweaknessActivity.this,Introduce.class);
		intent1.putExtras(bundle);
		spec.setContent(intent1);
		tab.addTab(spec);
		
		TabHost.TabSpec spec2 = tab.newTabSpec("test");
		spec2.setIndicator("≤‚ ‘");
		intent2 = new Intent(ColorweaknessActivity.this,Test.class);
		intent2.putExtras(bundle);
		spec2.setContent(intent2);
		tab.addTab(spec2);
		
		tab.setCurrentTab(0);
	}
}
