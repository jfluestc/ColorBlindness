package com.example2.colorblind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DBAdapter {
	
	public String dbname = DBopenhelper.getDbname(); 
	public String Name = DBopenhelper.getName();
	public String Introduce = DBopenhelper.getIntroduce();
	public String Id = DBopenhelper.getId();
	DBopenhelper dbopen;
	SQLiteDatabase db;
	public DBAdapter(Context context){
		dbopen = new DBopenhelper(context);
	}
	
	//打开一个数据库对象db
	public DBAdapter open() throws SQLiteException{
		db = dbopen.getWritableDatabase();
		return this;
	}
	//关闭数据库对象
	public void close(){
		db.close();
	}
	public void insert(String name,String introduce){
		ContentValues cv = new ContentValues();
		cv.put(Name, name);
		cv.put(Introduce, introduce);
		db.insert(dbname, null, cv);
		
	}
	//通过id值来删除数据库中的数据
	public boolean delete(int id){
		db.delete(dbname, Id +"="+id , null);
		return true;
	}
	//通过name值来删除数据库中的数据
	public boolean delete(String name){
		db.execSQL("delete * from"+dbname+"where name=?"+new Object[]{name});
		return true;
	}
	//更改数据库后更新数据库中的数据
	public void update(){
		
	}
	//通过id值来查找相应的数据,并返回Cursor对象
	public Cursor select(int id){
		Cursor cursor = db.query(dbname, new String[]{Id,Name,Introduce},Id +"="+id, null, null, null, null, null);
		if(cursor !=null)
			cursor.moveToFirst();
		return cursor;
	}
	//通过name值来查找相应的数据并返回Cursor对象
	public Cursor select(String name){
		Cursor cursor = db.rawQuery("select id,name,introduce from" + dbname+"where name=?",new String[]{name});
		if(cursor != null)
			cursor.moveToFirst();
		return cursor;
	}
	//查找数据库中的全部数据
	public Cursor selectAll(){
		Cursor cursor = db.rawQuery("select id,name,introduce from"+dbname, null);
		if(cursor !=null)
			cursor.moveToFirst();
		return cursor;
	}
}
