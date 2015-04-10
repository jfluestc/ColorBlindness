package com.example2.colorblind;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Result extends Activity {

	Button back;
	TextView result;
	Intent intent,intent2;
	Bundle bundle;
	String ans[] = new String[10];
	int flag;
	int [] j ;
	int sum;
	float score;
	public static String TAG="Result";
	private static long exitTime = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		MyApplication.getInstance().addActivity(this);
		
		back = (Button)findViewById(R.id.back2);
		result = (TextView)findViewById(R.id.result);
		
		intent = new Intent(Result.this,TestActivity.class);
		intent2 = getIntent();
		
		bundle = intent2.getExtras();
		flag = bundle.getInt("flag");
		ans = bundle.getStringArray("key");	
		
		j = new int[10];
		
		switch(flag){
		case 1:
			if(!(ans[0].equals("null"))){
				if(ans[0].equals("五角星"))
					j[0]=j[0]+3;
				else if(ans[0].equals("三角星"))
					j[0]=j[0]+2;
				else
					j[0]++;
				}
			if(!(ans[1].equals("null"))){
				if(Integer.parseInt(ans[1])==12)
						j[1]=j[1]+3;
			}
			if(!(ans[2].equals("null"))){
				if(Integer.parseInt(ans[2])==26)
					j[2]=j[2]+3;
				else if(Integer.parseInt(ans[2])==2)
					j[2]=j[2]+2;
				else if(Integer.parseInt(ans[2])==6)
					j[2] = j[2]+1;
			}
			if(!(ans[3].equals("null"))){
				if(Integer.parseInt(ans[3])==35)
					j[3]=j[3]+3;
				else if(Integer.parseInt(ans[3])==3)
					j[3]=j[3]+2;
				else if(Integer.parseInt(ans[3])==5)
					j[3] = j[3]+1;
			}
			if(!(ans[4].equals("null"))){
				if(Integer.parseInt(ans[4])==45)
					j[4]=j[4]+3;
			}
			if(!(ans[5].equals("null"))){
				if(ans[5].equals("马"))
					j[5]=j[5]+3;
				else if(ans[5].equals("驴"))
					j[5]=j[5]+2;
			}
			if(!(ans[6].equals("null"))){
				if(ans[6].contains("苹果"))
					j[6]=j[6]+3;
			}
			if(!(ans[7].equals("null"))){
				if(Integer.parseInt(ans[7])==2)
					j[7]=j[7]+3;
			}
			if(!(ans[8].equals("null"))){
				if(Integer.parseInt(ans[8])==29)
					j[8]=j[8]+3;
				else if(Integer.parseInt(ans[8])==7)
					j[8]=j[8]+2;
				else if(Integer.parseInt(ans[8])==70)
					j[8] = j[8]+2;
			}
			if(!(ans[9].equals("null"))){
				if(Integer.parseInt(ans[9])==74)
					j[9]=j[9]+3;
				else 
					j[9] = j[9]+2;
			}
			for(int i =0;i<j.length;i++){
				sum = sum+j[i];
				Log.i(TAG, "j["+i+"]="+j[i]);
				Log.i(TAG, ans[i]);
			}
			Log.i(TAG, "sum="+sum);
			score =(float)(sum*100/30);
			Log.i(TAG, "score="+score);
			if(sum == 30)
				result.setText("恭喜你，你的正确率是"+score+"%,你的色彩辨别能力是正常的，你眼中的世界五彩缤纷！");
			else if(sum>=24)
				result.setText("恭喜你，你的正确率是"+score+"%,你的色彩辨别能力正常");
			else if(sum >= 12)
				result.setText("你的正确率是"+score+"%,你的色彩辨别能力比常人稍微弱一些,平时多注意用眼并经常测试");
			else if(sum >= 12 && j[0] ==2)
				result.setText("你的正确率是"+score+"%,你的色彩辨别能力偏低，有患全色盲的可能性，建议您到医院做相关检查");
			else if(sum>=0)
				result.setText("你的正确率是"+score+"%,你的色彩辨别能力偏低，有患全色盲的可能性，建议您到医院做相关检查");
			if(j[2] == 1 && j[3] == 1)
				result.setText("你的正确率是"+score+"%,你的眼睛对红色分辨力低于常人，建议做一些红色盲相关测试，或者到医院做相关检查");
			if(j[2] == 2 && j[3] == 2)
				result.setText("你的正确率是"+score+"%,你的眼睛对绿色分辨力低于常人，建议做一些绿色盲相关测试，或者到医院做相关检查");
			break;
		case 2:
			if(!(ans[0].equals("null"))){
				if(Integer.parseInt(ans[0])==36)
					j[0]=j[0]+3;
				}
			if(!(ans[1].equals("null"))){
				if(Integer.parseInt(ans[1])==3)
						j[1]=j[1]+3;
			}
			if(!(ans[2].equals("null"))){
				if(Integer.parseInt(ans[2])==2)
					j[2]=j[2]+3;
			}
			if(!(ans[3].equals("null"))){
				if(Integer.parseInt(ans[3])==6)
					j[3]=j[3]+3;
				else if(Integer.parseInt(ans[3])==5)
					j[3] = j[3]+1;
			}
			if(!(ans[4].equals("null"))){
				if(Integer.parseInt(ans[4])==66)
					j[4]=j[4]+3;
				if(Integer.parseInt(ans[4])==6)
					j[4]=j[4]+1;
			}
			if(!(ans[5].equals("null"))){
				if(Integer.parseInt(ans[5])==99)
					j[5]=j[5]+3;
				else if(Integer.parseInt(ans[5])==0)
					j[5]=j[5]+1;
			}
			if(!(ans[6].equals("null"))){
				if(ans[6].matches("p")||ans[6].matches("P"))
					j[6]=j[6]+3;
				if(ans[6].matches("n")||ans[6].matches("N"))
					j[6]=j[6]+1;
			}
			if(!(ans[7].equals("null"))){
				if(ans[7].getBytes().length == 3)
					j[7]=j[7]+3;
				else if(ans[7].getBytes().length == 2)
					j[7]=j[7]+2;
				else if(ans[7].getBytes().length == 1)
					j[7]++;
			}
			if(!(ans[8].equals("null"))){
				if(ans[8].contains("枪"))
					j[8]=j[8]+3;
				else
					j[8]=j[8]+1;
			}
			if(!(ans[9].equals("null"))){
				if(Integer.parseInt(ans[9])==26)
					j[9]=j[9]+3;
				else if(Integer.parseInt(ans[9])==2)
					j[9] = j[9]+2;
				else if(Integer.parseInt(ans[9])==6)
					j[9] = j[9]+1;

			}
			for(int i =0;i<j.length;i++){
				sum = sum+j[i];
				Log.i(TAG, "j["+i+"]="+j[i]);
				Log.i(TAG, ans[i]);
			}
			Log.i(TAG, "sum="+sum);
			score =(float)(sum*100/30);
			Log.i(TAG, "score="+score);
			if(sum == 30)
				result.setText("恭喜你，你的正确率是"+score+"%,你的红色辨别能力是正常的，不必担心患有红色盲");
			else if(sum>=24)
				result.setText("恭喜你，你的正确率是"+score+"%,你的红色辨别能力基本正常");
			else if(sum >= 12)
				result.setText("你的正确率是"+score+"%,你的红色辨别能力比常人稍微弱一些,平时多注意用眼并经常测试");
			else if(sum>=0)
				result.setText("你的正确率是"+score+"%,你的红色辨别能力弱，有患红色盲的可能性，建议您到医院做相关检查");
			if(j[3] == 1 && j[4] == 1 && j[5] == 0 && j[9] == 2)
				result.setText("你的正确率是"+score+"%,你的眼睛对绿色分辨力弱于常人，有患红色盲或红绿色盲的可能性，建议到医院做相关检查");
			if(j[1] == 0 && j[4] == 1 && j[6] == 1 && j[9] == 1 )
				result.setText("你的正确率是"+score+"%,你的眼睛对红色分辨力弱于常人，有患红色盲或红绿色盲的可能性,建议到医院做相关检查");
			break;
		case 3:
			if(!(ans[0].equals("null"))){
				if(ans[0].contains("红")&&ans[0].contains("紫"))
					j[0]=j[0]+3;
				else if(ans[0].contains("红"))
					j[0]=j[0]+1;
				else if(ans[0].contains("紫"))
					j[0]=j[0]+2;
				}
			if(!(ans[1].equals("null"))){
				if(Integer.parseInt(ans[1])==74)
						j[1]=j[1]+3;
				else if(Integer.parseInt(ans[1])==21)
					j[1]=j[1]+1;
			}
			if(!(ans[2].equals("null"))){
				if(ans[2].getBytes().length == 3)
					j[2]=j[2]+3;
				else if(ans[2].getBytes().length == 2)
					j[2]=j[2]+2;
				else
					j[2]++;
			}
			if(ans[3].equals("null"))
					j[3]=j[3]+3;
			else if(Integer.parseInt(ans[3])==5)
				j[3] = j[3]+1;
			if(!(ans[4].equals("null"))){
				if(Integer.parseInt(ans[4])==29)
					j[4]=j[4]+3;
				if(Integer.parseInt(ans[4])==7)
					j[4]=j[4]+1;
			}
			if(!(ans[5].equals("null"))){
				if(Integer.parseInt(ans[5])==6)
					j[5]=j[5]+3;
				else if(Integer.parseInt(ans[5])==5)
					j[5]=j[5]+1;
			}
			if(!(ans[6].equals("null"))){
				if(ans[6].contains("金鱼"))
					j[6]=j[6]+3;
			}
			if(!(ans[7].equals("null"))){
				if(Integer.parseInt(ans[7]) == 5)
					j[7]=j[7]+3;
			}
			if(!(ans[8].equals("null"))){
				if(ans[8].contains("鹿"))
					j[8]=j[8]+3;
				else
					j[8]=j[8]+1;
			}
			if(!(ans[9].equals("null"))){
				if(ans[9].contains("方") && ans[9].contains("圆"))
					j[9]=j[9]+3;
				else if(ans[9].contains("圆"))
					j[9] = j[9]+1;
				else if(ans[9].contains("方") )
					j[9] = j[9]+2;

			}
			for(int i =0;i<j.length;i++){
				sum = sum+j[i];
				Log.i(TAG, "j["+i+"]="+j[i]);
				Log.i(TAG, ans[i]);
			}
			Log.i(TAG, "sum="+sum);
			score =(float)(sum*100/30);
			Log.i(TAG, "score="+score);
			if(sum == 30)
				result.setText("恭喜你，你的正确率是"+score+"%,你的绿色辨别能力是正常的，不必担心患有绿色盲");
			else if(sum>=24)
				result.setText("恭喜你，你的正确率是"+score+"%,你的绿色辨别能力基本正常");
			else if(sum >= 12)
				result.setText("你的正确率是"+score+"%,你的绿色辨别能力比常人稍微弱一些,平时多注意用眼并经常测试");
			else if(sum >= 12 && j[1] ==1 && j[9]==1)
				result.setText("你的正确率是"+score+"%,你的绿色辨别能力偏低，有患绿色盲的可能性，建议您到医院做相关检查");
			else if(sum>=0)
				result.setText("你的正确率是"+score+"%,你的绿色辨别能力弱，有患绿色盲的可能性，建议您到医院做相关检查");
			if(j[1] == 0 && j[3] == 3 && j[4] == 0 && j[5] == 0)
				result.setText("你的正确率是"+score+"%,你的眼睛对色彩分辨力弱于常人，有全色盲或全色弱的可能性，建议到医院做相关检查");
			if(j[0] == 1 && j[1] == 1 && j[3] == 1 && j[9] == 1 )
				result.setText("你的正确率是"+score+"%,你的眼睛对绿色分辨力弱于常人，有患绿色盲或红绿色盲的可能性,建议到医院做相关检查");
			if(j[1] == 1 && j[3] != 3)
				result.setText("你的正确率是"+score+"%,你的眼睛对红色和绿色分辨力弱于常人，有红绿色盲的可能性,建议到医院做相关检查");
			break;
		case 4:
			j = new int[7];
			if(!(ans[0].equals("null"))){
				if(Integer.parseInt(ans[0])==70)
					j[0]=j[0]+3;
				}
			if(!(ans[1].equals("null"))){
				if(ans[1].getBytes().length == 3)
						j[1]=j[1]+3;
				else if(ans[1].getBytes().length == 2)
					j[1]=j[1]+2;
				else j[1]++;
			}
			if(!(ans[2].equals("null"))){
				if(Integer.parseInt(ans[2])==6)
					j[2]=j[2]+3;
			}
			if(!(ans[3].equals("null")))
				if(Integer.parseInt(ans[3])==56)
					j[3]=j[3]+3;
			if(!(ans[4].equals("null")))
				if(Integer.parseInt(ans[4])==6)
					j[4]=j[4]+3;
			if(!(ans[5].equals("null"))){
				if(Integer.parseInt(ans[5])==3)
					j[5]=j[5]+3;
			}
			if(!(ans[6].equals("null"))){
				if(Integer.parseInt(ans[6])==4)
					j[6]=j[6]+3;
			}
			for(int i =0;i<j.length;i++){
				sum = sum+j[i];
				Log.i(TAG, "j["+i+"]="+j[i]);
				Log.i(TAG, ans[i]);
			}
			Log.i(TAG, "sum="+sum);
			score =(float)(sum*100/21);
			Log.i(TAG, "score="+score);
			if(sum == 21)
				result.setText("恭喜你，你的正确率是"+score+"%,你的蓝色和黄色辨别能力是正常的，不必担心患有蓝黄色盲");
			else if(sum>=18)
				result.setText("恭喜你，你的正确率是"+score+"%,你的蓝黄色辨别能力基本正常");
			else if(sum >= 15)
				result.setText("你的正确率是"+score+"%,你的蓝黄色辨别能力比常人稍微弱一些,平时多注意用眼并经常测试");
			else if(sum >= 12 )
				result.setText("你的正确率是"+score+"%,你的蓝黄色辨别能力偏低，有蓝黄色盲的可能性，建议您到医院做相关检查");
			else if(sum>=0)
				result.setText("你的正确率是"+score+"%,你的蓝黄色辨别能力弱，有患蓝黄色盲的可能性，建议您到医院做相关检查");
			if(j[1] != 3 && j[3] == 0 && j[4] == 0 && j[6] == 0)
				result.setText("你的正确率是"+score+"%,你的眼睛对黄色分辨力弱于常人，有患黄色盲的可能性，建议到医院做相关检查");
			if(j[0] == 0 && j[1] !=3 && j[2] == 0 && j[5] == 0 )
				result.setText("你的正确率是"+score+"%,你的眼睛对蓝色分辨力弱于常人，有患蓝色盲的可能性,建议到医院做相关检查");
			break;
		case 5:
			if(!(ans[0].equals("null"))){
				if(Integer.parseInt(ans[0])==5)
					j[0]=j[0]+3;
				}
			if(!(ans[1].equals("null"))){
				if(Integer.parseInt(ans[1])==20)
					j[1]=j[1]+3;
				else
					j[1]=j[1]+1;
			}
			if(!(ans[2].equals("null"))){
				if(Integer.parseInt(ans[2])==5)
					j[2]=j[2]+3;
				else
					j[2]++;
			}
			if(!(ans[3].equals("null")))
				if(ans[3].contains("紫"))
					j[3]=j[3]+3;
			    else
			    	j[3] = j[3]+1;
			if(!(ans[4].equals("null"))){
				if(Integer.parseInt(ans[4])==15)
					j[4]=j[4]+3;
				else
					j[4]=j[4]+1;
			}
			if(!(ans[5].equals("null"))){
				if(Integer.parseInt(ans[5])==6)
					j[5]=j[5]+3;
				else
					j[5]=j[5]+1;
			}
			if(!(ans[6].equals("null"))){
				if(ans[6].contains("红")&&ans[6].contains("紫"))
					j[6]=j[6]+3;
				else
					j[6]=j[6]+1;
			}
			if(!(ans[7].equals("null"))){
				if(ans[7].contains("绿")||ans[7].contains("浅绿"))
					j[7]=j[7]+3;
				else 
					j[7]=j[7]+1;
			}
			if(!(ans[8].equals("null"))){
				if(ans[8].contains("红"))
					j[8]=j[8]+3;
				else if(ans[6].contains("绿"))
					j[8]=j[8]+0;
				else
					j[8]++;
			}
			if(!(ans[9].equals("null"))){
				if(Integer.parseInt(ans[9])==6)
					j[9]=j[9]+3;
			}
			for(int i =0;i<j.length;i++){
				sum = sum+j[i];
				Log.i(TAG, "j["+i+"]="+j[i]);
				Log.i(TAG, ans[i]);
			}
			Log.i(TAG, "sum="+sum);
			score =(float)(sum*100/30);
			Log.i(TAG, "score="+score);
			if(sum == 30)
				result.setText("恭喜你，你的正确率是"+score+"%,你的色彩辨别能力是正常的，不必担心有全色反症状");
			else if(sum>=24 && j[8] != 0)
				result.setText("恭喜你，你的正确率是"+score+"%,你的色彩辨别能力基本正常");
			else if(sum>=24 )
				result.setText("你的正确率是"+score+"%,你的色彩辨别能力基本正常");
			else if(sum >= 12)
				result.setText("你的正确率是"+score+"%,你的色彩辨别能力比常人稍微弱一些,平时多注意用眼并经常测试");
			else if(sum>=0)
				result.setText("你的正确率是"+score+"%,你的色彩辨别能力弱，有患全色反的可能性，建议您到医院做相关检查");
			if(j[3] != 3 && j[6] != 3 && j[7] !=3 && j[8] == 0)
				result.setText("你的正确率是"+score+"%,你的眼睛对色彩分辨力弱于常人，有患全色反的可能性，建议到医院做相关检查");
			if(j[3]+j[6]+j[7]<=6)
				result.setText("你的正确率是"+score+"%,你的眼睛对色彩分辨力弱于常人，有患全色反的可能性，建议到医院做相关检查");
			if(j[8] == 0)
				result.setText("你的正确率是"+score+"%,你的眼睛对色彩分辨力弱于常人，有患全色反的可能性，建议到医院做相关检查");
			break;
		case 6:
			if(!(ans[0].equals("null"))){
				if(Integer.parseInt(ans[0])==6)
					j[0]=j[0]+3;
				else if(Integer.parseInt(ans[0])==5)
					j[0]=j[0]+2;
				}
			if(!(ans[1].equals("null"))){
				if(Integer.parseInt(ans[1])==74)
						j[1]=j[1]+3;
				else if(Integer.parseInt(ans[1])==21)
					j[1]=j[1]+1;
			}
			if(!(ans[2].equals("null"))){
				if(Integer.parseInt(ans[2]) == 97)
					j[2]=j[2]+3;
			}
			if(ans[3].equals("null"))
					j[3]=j[3]+3;
			else if(Integer.parseInt(ans[3])==5)
				j[3] = j[3]+1;
			if(!(ans[4].equals("null"))){
				if(Integer.parseInt(ans[4])==29)
					j[4]=j[4]+3;
				if(Integer.parseInt(ans[4])==7)
					j[4]=j[4]+1;
			}
			if(!(ans[5].equals("null"))){
				if(ans[5].matches("a")||ans[5].matches("A"))
					j[5]=j[5]+3;
			}
			if(!(ans[6].equals("null"))){
				if(Integer.parseInt(ans[6])==5)
					j[6]=j[6]+3;
			}
			if(!(ans[7].equals("null"))){
				if(Integer.parseInt(ans[7]) == 45)
					j[7]=j[7]+3;
			}
			if(!(ans[8].equals("null"))){
				if(ans[8].equals("red")||ans[8].equals("RED"))
					j[8]=j[8]+3;
			}
			if(!(ans[9].equals("null"))){
				if(ans[9].matches("c")||ans[9].matches("C"))
					j[9]=j[9]+3;
			}
			for(int i =0;i<j.length;i++){
				sum = sum+j[i];
				Log.i(TAG, "j["+i+"]="+j[i]);
				Log.i(TAG, ans[i]);
			}
			Log.i(TAG, "sum="+sum);
			score =(float)(sum*100/30);
			Log.i(TAG, "score="+score);
			if(sum == 30)
				result.setText("恭喜你，你的正确率是"+score+"%,你对所有的颜色不同深浅程度辨别能力是正常的，不必担心患有全色弱");
			else if(sum>=24)
				result.setText("恭喜你，你的正确率是"+score+"%,你所有的颜色不同深浅程度辨别能力基本正常");
			else if(sum >= 21)
				result.setText("你的正确率是"+score+"%,你对较浅颜色的辨别能力比常人稍微弱一些,平时多注意用眼并经常测试");
			else if(sum >= 12)
				result.setText("你的正确率是"+score+"%,你对所有浅色辨别能力偏低，有患全色弱的可能性，建议您到医院做相关检查");
			else if(sum>=0)
				result.setText("你的正确率是"+score+"%,你对所有浅色辨别能力很弱，有患全色弱的可能性，建议您到医院做相关检查");
			if(j[0] == 0 && j[1] == 0&& j[2] == 0)
				result.setText("你的正确率是"+score+"%,你对所有浅色辨别能力很弱，有患全色弱的可能性，建议您到医院做相关检查");
			break;
		case 7:
			if(!(ans[0].equals("null")))
				if(Integer.parseInt(ans[0])==3)
					j[0]=j[0]+3;
			if(!(ans[1].equals("null")))
				if(Integer.parseInt(ans[1])==5)
					j[1]=j[1]+3;
			if(!(ans[2].equals("null")))
				if(Integer.parseInt(ans[2])== 8)
					j[2]=j[2]+3;
			if(!(ans[3].equals("null")))
				if(Integer.parseInt(ans[3])==8)
					j[3] =j[3]+3;
			if(!(ans[4].equals("null")))
				if(Integer.parseInt(ans[4])==9)
					j[4]=j[4]+3;
			if(!(ans[5].equals("null")))
				if(Integer.parseInt(ans[5])==5)
					j[5]=j[5]+3;
			if(!(ans[6].equals("null")))
				if(Integer.parseInt(ans[6])==3)
					j[6]=j[6]+3;
			if(!(ans[7].equals("null")))
				if(Integer.parseInt(ans[7]) == 5)
					j[7]=j[7]+3;
			if(!(ans[8].equals("null")))
				if(Integer.parseInt(ans[8]) == 2)
					j[8]=j[8]+3;
			if(!(ans[9].equals("null")))
				if(Integer.parseInt(ans[9]) == 4)
					j[9]=j[9]+3;
			for(int i =0;i<j.length;i++){
				sum = sum+j[i];
				Log.i(TAG, "j["+i+"]="+j[i]);
				Log.i(TAG, ans[i]);
			}
			Log.i(TAG, "sum="+sum);
			score =(float)(sum*100/30);
			Log.i(TAG, "score="+score);
			if(sum == 30)
				result.setText("恭喜你，你的正确率是"+score+"%,你对所有的颜色不同深浅程度辨别能力是正常的，不必担心患有全色弱");
			else if(sum>=24)
				result.setText("恭喜你，你的正确率是"+score+"%,你所有的颜色不同深浅程度辨别能力基本正常");
			else if(sum >= 18)
				result.setText("你的正确率是"+score+"%,你对部分较浅颜色的辨别能力比常人稍微弱一些,可能对某一颜色在交钱是不能分辨，建议到医院检测");
			else if(sum >= 9)
				result.setText("你的正确率是"+score+"%,你对某一种或两种浅色辨别能力偏低，有患部分色弱的可能性，建议您到医院做相关检查");
			else if(sum>=0)
				result.setText("你的正确率是"+score+"%,你对较多颜色的浅色辨别能力很弱，有患部分色弱的可能性，建议您到医院做相关检查");
			if(j[0] == 0 && j[1] == 0&& j[2] == 0)
				result.setText("你的正确率是"+score+"%,你对红色的浅色辨别能力很弱，有患红色色弱的可能性，建议您到医院做相关检查");
			if(j[3] == 0 && j[4] == 0&& j[5] == 0)
				result.setText("你的正确率是"+score+"%,你对绿色的浅色辨别能力很弱，有患绿色色弱的可能性，建议您到医院做相关检查");
			if(j[6] == 0 && j[7] ==0)
				result.setText("你的正确率是"+score+"%,你对蓝(紫)色的浅色辨别能力偏弱，有患蓝(紫)色弱的可能性，建议您到医院做相关检查");
			if(j[8] == 0 && j[9] ==0)
				result.setText("你的正确率是"+score+"%,你对黄色的浅色辨别能力偏弱，有患黄色弱的可能性，建议您到医院做相关检查");
			break;	
		}
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(intent);
			}	
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode ==KeyEvent.KEYCODE_BACK ){
			exit();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private void exit(){
		if((System.currentTimeMillis()-exitTime)>2000){
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			    exitTime = System.currentTimeMillis();
			}
			else{
				MyApplication.getInstance().exit();
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(0);
				}
	}	
}
