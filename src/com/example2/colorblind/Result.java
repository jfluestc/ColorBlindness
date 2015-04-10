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
				if(ans[0].equals("�����"))
					j[0]=j[0]+3;
				else if(ans[0].equals("������"))
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
				if(ans[5].equals("��"))
					j[5]=j[5]+3;
				else if(ans[5].equals("¿"))
					j[5]=j[5]+2;
			}
			if(!(ans[6].equals("null"))){
				if(ans[6].contains("ƻ��"))
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
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,���ɫ�ʱ�������������ģ������е���������ͷף�");
			else if(sum>=24)
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,���ɫ�ʱ����������");
			else if(sum >= 12)
				result.setText("�����ȷ����"+score+"%,���ɫ�ʱ�������ȳ�����΢��һЩ,ƽʱ��ע�����۲���������");
			else if(sum >= 12 && j[0] ==2)
				result.setText("�����ȷ����"+score+"%,���ɫ�ʱ������ƫ�ͣ��л�ȫɫä�Ŀ����ԣ���������ҽԺ����ؼ��");
			else if(sum>=0)
				result.setText("�����ȷ����"+score+"%,���ɫ�ʱ������ƫ�ͣ��л�ȫɫä�Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[2] == 1 && j[3] == 1)
				result.setText("�����ȷ����"+score+"%,����۾��Ժ�ɫ�ֱ������ڳ��ˣ�������һЩ��ɫä��ز��ԣ����ߵ�ҽԺ����ؼ��");
			if(j[2] == 2 && j[3] == 2)
				result.setText("�����ȷ����"+score+"%,����۾�����ɫ�ֱ������ڳ��ˣ�������һЩ��ɫä��ز��ԣ����ߵ�ҽԺ����ؼ��");
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
				if(ans[8].contains("ǹ"))
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
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,��ĺ�ɫ��������������ģ����ص��Ļ��к�ɫä");
			else if(sum>=24)
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,��ĺ�ɫ���������������");
			else if(sum >= 12)
				result.setText("�����ȷ����"+score+"%,��ĺ�ɫ��������ȳ�����΢��һЩ,ƽʱ��ע�����۲���������");
			else if(sum>=0)
				result.setText("�����ȷ����"+score+"%,��ĺ�ɫ������������л���ɫä�Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[3] == 1 && j[4] == 1 && j[5] == 0 && j[9] == 2)
				result.setText("�����ȷ����"+score+"%,����۾�����ɫ�ֱ������ڳ��ˣ��л���ɫä�����ɫä�Ŀ����ԣ����鵽ҽԺ����ؼ��");
			if(j[1] == 0 && j[4] == 1 && j[6] == 1 && j[9] == 1 )
				result.setText("�����ȷ����"+score+"%,����۾��Ժ�ɫ�ֱ������ڳ��ˣ��л���ɫä�����ɫä�Ŀ�����,���鵽ҽԺ����ؼ��");
			break;
		case 3:
			if(!(ans[0].equals("null"))){
				if(ans[0].contains("��")&&ans[0].contains("��"))
					j[0]=j[0]+3;
				else if(ans[0].contains("��"))
					j[0]=j[0]+1;
				else if(ans[0].contains("��"))
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
				if(ans[6].contains("����"))
					j[6]=j[6]+3;
			}
			if(!(ans[7].equals("null"))){
				if(Integer.parseInt(ans[7]) == 5)
					j[7]=j[7]+3;
			}
			if(!(ans[8].equals("null"))){
				if(ans[8].contains("¹"))
					j[8]=j[8]+3;
				else
					j[8]=j[8]+1;
			}
			if(!(ans[9].equals("null"))){
				if(ans[9].contains("��") && ans[9].contains("Բ"))
					j[9]=j[9]+3;
				else if(ans[9].contains("Բ"))
					j[9] = j[9]+1;
				else if(ans[9].contains("��") )
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
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,�����ɫ��������������ģ����ص��Ļ�����ɫä");
			else if(sum>=24)
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,�����ɫ���������������");
			else if(sum >= 12)
				result.setText("�����ȷ����"+score+"%,�����ɫ��������ȳ�����΢��һЩ,ƽʱ��ע�����۲���������");
			else if(sum >= 12 && j[1] ==1 && j[9]==1)
				result.setText("�����ȷ����"+score+"%,�����ɫ�������ƫ�ͣ��л���ɫä�Ŀ����ԣ���������ҽԺ����ؼ��");
			else if(sum>=0)
				result.setText("�����ȷ����"+score+"%,�����ɫ������������л���ɫä�Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[1] == 0 && j[3] == 3 && j[4] == 0 && j[5] == 0)
				result.setText("�����ȷ����"+score+"%,����۾���ɫ�ʷֱ������ڳ��ˣ���ȫɫä��ȫɫ���Ŀ����ԣ����鵽ҽԺ����ؼ��");
			if(j[0] == 1 && j[1] == 1 && j[3] == 1 && j[9] == 1 )
				result.setText("�����ȷ����"+score+"%,����۾�����ɫ�ֱ������ڳ��ˣ��л���ɫä�����ɫä�Ŀ�����,���鵽ҽԺ����ؼ��");
			if(j[1] == 1 && j[3] != 3)
				result.setText("�����ȷ����"+score+"%,����۾��Ժ�ɫ����ɫ�ֱ������ڳ��ˣ��к���ɫä�Ŀ�����,���鵽ҽԺ����ؼ��");
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
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,�����ɫ�ͻ�ɫ��������������ģ����ص��Ļ�������ɫä");
			else if(sum>=18)
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,�������ɫ���������������");
			else if(sum >= 15)
				result.setText("�����ȷ����"+score+"%,�������ɫ��������ȳ�����΢��һЩ,ƽʱ��ע�����۲���������");
			else if(sum >= 12 )
				result.setText("�����ȷ����"+score+"%,�������ɫ�������ƫ�ͣ�������ɫä�Ŀ����ԣ���������ҽԺ����ؼ��");
			else if(sum>=0)
				result.setText("�����ȷ����"+score+"%,�������ɫ������������л�����ɫä�Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[1] != 3 && j[3] == 0 && j[4] == 0 && j[6] == 0)
				result.setText("�����ȷ����"+score+"%,����۾��Ի�ɫ�ֱ������ڳ��ˣ��л���ɫä�Ŀ����ԣ����鵽ҽԺ����ؼ��");
			if(j[0] == 0 && j[1] !=3 && j[2] == 0 && j[5] == 0 )
				result.setText("�����ȷ����"+score+"%,����۾�����ɫ�ֱ������ڳ��ˣ��л���ɫä�Ŀ�����,���鵽ҽԺ����ؼ��");
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
				if(ans[3].contains("��"))
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
				if(ans[6].contains("��")&&ans[6].contains("��"))
					j[6]=j[6]+3;
				else
					j[6]=j[6]+1;
			}
			if(!(ans[7].equals("null"))){
				if(ans[7].contains("��")||ans[7].contains("ǳ��"))
					j[7]=j[7]+3;
				else 
					j[7]=j[7]+1;
			}
			if(!(ans[8].equals("null"))){
				if(ans[8].contains("��"))
					j[8]=j[8]+3;
				else if(ans[6].contains("��"))
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
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,���ɫ�ʱ�������������ģ����ص�����ȫɫ��֢״");
			else if(sum>=24 && j[8] != 0)
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,���ɫ�ʱ��������������");
			else if(sum>=24 )
				result.setText("�����ȷ����"+score+"%,���ɫ�ʱ��������������");
			else if(sum >= 12)
				result.setText("�����ȷ����"+score+"%,���ɫ�ʱ�������ȳ�����΢��һЩ,ƽʱ��ע�����۲���������");
			else if(sum>=0)
				result.setText("�����ȷ����"+score+"%,���ɫ�ʱ�����������л�ȫɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[3] != 3 && j[6] != 3 && j[7] !=3 && j[8] == 0)
				result.setText("�����ȷ����"+score+"%,����۾���ɫ�ʷֱ������ڳ��ˣ��л�ȫɫ���Ŀ����ԣ����鵽ҽԺ����ؼ��");
			if(j[3]+j[6]+j[7]<=6)
				result.setText("�����ȷ����"+score+"%,����۾���ɫ�ʷֱ������ڳ��ˣ��л�ȫɫ���Ŀ����ԣ����鵽ҽԺ����ؼ��");
			if(j[8] == 0)
				result.setText("�����ȷ����"+score+"%,����۾���ɫ�ʷֱ������ڳ��ˣ��л�ȫɫ���Ŀ����ԣ����鵽ҽԺ����ؼ��");
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
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,������е���ɫ��ͬ��ǳ�̶ȱ�������������ģ����ص��Ļ���ȫɫ��");
			else if(sum>=24)
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,�����е���ɫ��ͬ��ǳ�̶ȱ��������������");
			else if(sum >= 21)
				result.setText("�����ȷ����"+score+"%,��Խ�ǳ��ɫ�ı�������ȳ�����΢��һЩ,ƽʱ��ע�����۲���������");
			else if(sum >= 12)
				result.setText("�����ȷ����"+score+"%,�������ǳɫ�������ƫ�ͣ��л�ȫɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
			else if(sum>=0)
				result.setText("�����ȷ����"+score+"%,�������ǳɫ��������������л�ȫɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[0] == 0 && j[1] == 0&& j[2] == 0)
				result.setText("�����ȷ����"+score+"%,�������ǳɫ��������������л�ȫɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
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
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,������е���ɫ��ͬ��ǳ�̶ȱ�������������ģ����ص��Ļ���ȫɫ��");
			else if(sum>=24)
				result.setText("��ϲ�㣬�����ȷ����"+score+"%,�����е���ɫ��ͬ��ǳ�̶ȱ��������������");
			else if(sum >= 18)
				result.setText("�����ȷ����"+score+"%,��Բ��ֽ�ǳ��ɫ�ı�������ȳ�����΢��һЩ,���ܶ�ĳһ��ɫ�ڽ�Ǯ�ǲ��ֱܷ棬���鵽ҽԺ���");
			else if(sum >= 9)
				result.setText("�����ȷ����"+score+"%,���ĳһ�ֻ�����ǳɫ�������ƫ�ͣ��л�����ɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
			else if(sum>=0)
				result.setText("�����ȷ����"+score+"%,��Խ϶���ɫ��ǳɫ��������������л�����ɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[0] == 0 && j[1] == 0&& j[2] == 0)
				result.setText("�����ȷ����"+score+"%,��Ժ�ɫ��ǳɫ��������������л���ɫɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[3] == 0 && j[4] == 0&& j[5] == 0)
				result.setText("�����ȷ����"+score+"%,�����ɫ��ǳɫ��������������л���ɫɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[6] == 0 && j[7] ==0)
				result.setText("�����ȷ����"+score+"%,�����(��)ɫ��ǳɫ�������ƫ�����л���(��)ɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
			if(j[8] == 0 && j[9] ==0)
				result.setText("�����ȷ����"+score+"%,��Ի�ɫ��ǳɫ�������ƫ�����л���ɫ���Ŀ����ԣ���������ҽԺ����ؼ��");
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
				Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();
			    exitTime = System.currentTimeMillis();
			}
			else{
				MyApplication.getInstance().exit();
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(0);
				}
	}	
}
