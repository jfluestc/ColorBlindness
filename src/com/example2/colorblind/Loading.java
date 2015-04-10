package com.example2.colorblind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;



@SuppressLint("SdCardPath")
public class Loading extends Activity implements Runnable{

	private static final String DBNAME = "cblindness";//数据库的名字
	private static final String DBPATH ="/data/data/com.example2.colorblind/databases/";//数据库在手机里的路径
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		MyApplication.getInstance().addActivity(this);
		
		ProgressDialog pd = new ProgressDialog(Loading.this);
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.setTitle("提示");
		pd.setMessage("请稍后...");
		pd.show();
		
		boolean checkdb = CheckDb();
		if(checkdb){
			
		} else
			try {
				CopyDb();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		new Thread(this).start();		
	}
	private boolean CheckDb() {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		try{
			String dbPath = DBPATH+DBNAME;
			db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
		}catch(SQLiteException e){}
		if(db!=null)
			db.close();
		return (db!=null)?true:false;
	}
    /**
     * 复制数据库到手机指定文件夹下
     * @throws IOException
     */
	private void CopyDb() throws IOException {
		// TODO Auto-generated method stub
		String dbfilePath = DBPATH+DBNAME;
		File file = new File(DBPATH);
		if(!file.exists())  //判断文件夹是否存在，不存在就新建一个
			file.mkdir();
		FileOutputStream os = null;
		try{
			os = new FileOutputStream(dbfilePath);//得到数据库文件的写入流
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		InputStream is = getResources().getAssets().open(DBNAME);
		int length = is.available();
		byte[] buffer = new byte[length]; 
		int count =0;
		try{
			while((count = is.read(buffer))>0){
				os.write(buffer, 0, count);
				os.flush();
			}
		}catch(IOException e){}
        try{
            is.close();
            os.close();
        }catch(IOException e){
            e.printStackTrace();
        }
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 1;
		while(count<300){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
		updataApp();
		
	}
	private void updataApp() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Loading.this,MainActivity.class);
		Loading.this.startActivity(intent);
		Loading.this.finish();
	}
}
