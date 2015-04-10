package com.example2.colorblind;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBopenhelper extends SQLiteOpenHelper{
	
	private static int VERSION = 1;
	private static final String DBNAME = "cblindness";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String INTRODUCE = "introduce";
	private static final String TAG = "DBAdapter";
	private static final String SQL = "create table cblindness(id integer primary key autoincrement,name varchar(10)  not null,"+
	"introduce text not null);";

	
	public DBopenhelper(Context context) {
		super(context, DBNAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(TAG, "Updating database from oldversion"+oldVersion+"to"+
		newVersion+",which will destory all old data");
		db.execSQL("drop table id exits titles");
		onCreate(db);
	}

	public static String getDbname() {
		return DBNAME;
	}

	public static String getName() {
		return NAME;
	}

	public static String getIntroduce() {
		return INTRODUCE;
	}

	public static String getId() {
		return ID;
	}
	
	
}
