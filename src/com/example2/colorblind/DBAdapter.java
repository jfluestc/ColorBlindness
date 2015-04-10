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
	
	//��һ�����ݿ����db
	public DBAdapter open() throws SQLiteException{
		db = dbopen.getWritableDatabase();
		return this;
	}
	//�ر����ݿ����
	public void close(){
		db.close();
	}
	public void insert(String name,String introduce){
		ContentValues cv = new ContentValues();
		cv.put(Name, name);
		cv.put(Introduce, introduce);
		db.insert(dbname, null, cv);
		
	}
	//ͨ��idֵ��ɾ�����ݿ��е�����
	public boolean delete(int id){
		db.delete(dbname, Id +"="+id , null);
		return true;
	}
	//ͨ��nameֵ��ɾ�����ݿ��е�����
	public boolean delete(String name){
		db.execSQL("delete * from"+dbname+"where name=?"+new Object[]{name});
		return true;
	}
	//�������ݿ��������ݿ��е�����
	public void update(){
		
	}
	//ͨ��idֵ��������Ӧ������,������Cursor����
	public Cursor select(int id){
		Cursor cursor = db.query(dbname, new String[]{Id,Name,Introduce},Id +"="+id, null, null, null, null, null);
		if(cursor !=null)
			cursor.moveToFirst();
		return cursor;
	}
	//ͨ��nameֵ��������Ӧ�����ݲ�����Cursor����
	public Cursor select(String name){
		Cursor cursor = db.rawQuery("select id,name,introduce from" + dbname+"where name=?",new String[]{name});
		if(cursor != null)
			cursor.moveToFirst();
		return cursor;
	}
	//�������ݿ��е�ȫ������
	public Cursor selectAll(){
		Cursor cursor = db.rawQuery("select id,name,introduce from"+dbname, null);
		if(cursor !=null)
			cursor.moveToFirst();
		return cursor;
	}
}
