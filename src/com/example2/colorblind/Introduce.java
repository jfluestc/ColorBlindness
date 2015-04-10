package com.example2.colorblind;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Introduce extends Activity {

	TextView introduce,name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduce);
		MyApplication.getInstance().addActivity(this);
		name = (TextView)findViewById(R.id.name);
		introduce = (TextView)findViewById(R.id.introduce);
		
		DBAdapter dba = new DBAdapter(this);
		Cursor cursor;
		Bundle bundle = new Bundle();
		Intent intent = getIntent();
		bundle = intent.getExtras();
		int i = bundle.getInt("key");
		
		switch(i){
		case 1:
			dba.open();
			cursor = dba.select(1);
			name.setText(cursor.getString(1));
			introduce.setText(cursor.getString(2));
			cursor.close();
			dba.close();
			break;
		case 2:
			dba.open();
			cursor = dba.select(2);
			name.setText(cursor.getString(1));
			introduce.setText(cursor.getString(2));
			cursor.close();
			dba.close();
			break;
		case 3:
			dba.open();
			cursor = dba.select(3);
			name.setText(cursor.getString(1));
			introduce.setText(cursor.getString(2));
			cursor.close();
			dba.close();
			break;
		case 4:
			dba.open();
			cursor = dba.select(4);
			name.setText(cursor.getString(1));
			introduce.setText(cursor.getString(2));
			cursor.close();
			dba.close();
			break;
		case 5:
			dba.open();
			cursor = dba.select(5);
			name.setText(cursor.getString(1));
			introduce.setText(cursor.getString(2));
			cursor.close();
			dba.close();
			break;
		case 6:
			dba.open();
			cursor = dba.select(6);
			name.setText(cursor.getString(1));
			introduce.setText(cursor.getString(2));
			cursor.close();
			dba.close();
			break;
		case 7:
			dba.open();
			cursor = dba.select(7);
			name.setText(cursor.getString(1));
			introduce.setText(cursor.getString(2));
			cursor.close();
			dba.close();
			break;
		default:
			break;
		}
	}

}
