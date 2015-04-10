package com.example2.colorblind;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Test extends Activity {

	ImageView img;
	RadioGroup rg;
	RadioButton rb01,rb02;
	Button next,back;
	TextView tv;
	EditText answer;
	LinearLayout ll;
	Intent intent,intent2;
	Bundle bun;
	public static String[] ans;
	public static int k;
	public static String TAG="Test";
	public static String message;
/*	private static long exitTime = 0;*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity);
		MyApplication.getInstance().addActivity(this);
		
		Log.i(TAG, "Test->onCreate");
		img = (ImageView)findViewById(R.id.img);
		rg = (RadioGroup)findViewById(R.id.group);
		rb01 = (RadioButton)findViewById(R.id.choice01);
		rb02 = (RadioButton)findViewById(R.id.choice02);
		next = (Button)findViewById(R.id.next);
		back = (Button)findViewById(R.id.back);
		tv = (TextView)findViewById(R.id.text);
		answer = (EditText)findViewById(R.id.answer);
		ll = (LinearLayout)findViewById(R.id.bg01);
		intent = getIntent();
		intent2 = new Intent();
		bun = new Bundle();
		Bundle bundle = new Bundle();
		bundle = intent.getExtras();
		k = 0;
		ans  = new String[10];
		
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				intent2.setClass(Test.this, TestActivity.class);
				startActivity(intent2);
			}
			
		});

		//用整数i来标识是哪一项色盲测试请求
		int i = bundle.getInt("key");
		
		switch(i){
		/**
		 * 当i等于1时表示的是全色盲测试请求被传送过来，因此布局文件相应显示全色盲测试模块的内容
		 * 当i等于2时表示的是红色盲测试请求被传送过来，因此布局文件相应显示红色盲测试模块的内容
		 * 当i等于3时表示的是绿色盲测试请求被传送过来，因此布局文件相应显示绿色盲测试模块的内容
		 * ......
		 */
		case 1:
			img.setImageResource(R.drawable.first);
			//初始状态将得分标识符号j置为0
			rb02.setText("我看见的是五角星（三角星或其他图形）");
			/**
			 * 初始状态设置选项2为被选中状态
			 * 设置文本输入框的舒适状态为可编辑
			 */
			rb02.setChecked(true);
			answer.setEnabled(true);
			answer.setTextColor(Color.BLACK);
			answer.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
			/**
			 * 当选项的选中状态由选项1变为选项2时设置文本编辑框为可编辑状态
			 */
			rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					answer.setEnabled(true);
					//当选择了选项按钮1时，文本框的内容将被清空
					answer.setText("");
				}
			});
			/**
			 * 当选项的选中状态由选项2变为选项1是设置文本编辑框为不可编辑状态
			 */
			rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener(){

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					// TODO Auto-generated method stub
					answer.setEnabled(false);
				}
				
			});
			next.setOnClickListener(new View.OnClickListener() {	
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					/**
					 * 用整数k来标识显示第几幅图片,初始状态k=0,相应显示第一幅图片
					 * 每一次点击next按钮，k的值相应加1,当k=1时显示第二幅图片
					 * 当k=2是显示第三幅图片的内容
					 * ......
					 */
					message = answer.getText().toString();
					if(rb02.isChecked() && !(message.isEmpty())){
						ans[k] = message;
						Log.i(TAG, ans[k]);
					}
					else
						ans[k]="null";
					k++;
					switch(k){
					case 1:
						img.setImageResource(R.drawable.second);
						ll.setBackgroundColor(Color.BLACK);
						tv.setTextColor(Color.WHITE);
						//设置文本框的初始内容为空
						answer.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
						answer.setTextColor(Color.WHITE);
						answer.setText("");
						//初始状态设置文本框为可编辑状态
						answer.setEnabled(true);
						rb01.setTextColor(Color.WHITE);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb02.setTextColor(Color.WHITE);
						//设置选项按钮的初始状态为选择选项2
						rb02.setChecked(true);
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
							    answer.setEnabled(true);	
							    answer.setText("");
							}
						});
						rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener(){
							@Override
							public void onCheckedChanged(
									CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
							
						});
						next.setTextColor(Color.WHITE);
						break;
					case 2:
						img.setImageResource(R.drawable.third);
						rb02.setChecked(true);
						answer.setTextColor(Color.WHITE);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(true);
								answer.setText("");
							}
						});
						rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
						});
						break;
					case 3:
						img.setImageResource(R.drawable.fourth);
						ll.setBackgroundColor(Color.WHITE);
						tv.setTextColor(Color.BLACK);
						rb02.setChecked(true);
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						answer.setEnabled(true);
						rb01.setTextColor(Color.BLACK);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb02.setTextColor(Color.BLACK);
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(true);
								answer.setText("");
							}
						});
						rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
						});
						next.setTextColor(Color.BLACK);
						break;
					case 4:
						img.setImageResource(R.drawable.fifth);
						ll.setBackgroundColor(Color.BLACK);
						rb02.setChecked(true);
						answer.setTextColor(Color.WHITE);
						answer.setText("");
						answer.setEnabled(true);
						tv.setTextColor(Color.WHITE);
						rb01.setTextColor(Color.WHITE);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb02.setTextColor(Color.WHITE);
						next.setTextColor(Color.WHITE);
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(true);
								answer.setText("");
							}
						});
                        rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
						});
						break;
					case 5:
						img.setImageResource(R.drawable.sixth);
						ll.setBackgroundColor(Color.rgb(169,168, 166));
						rb02.setChecked(true);
						answer.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setText("我能看见一只动物（请在下方输入驴或马或其他动物）");
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(true);
								answer.setText("");
							}
						});
                        rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
						});
						break;
					case 6:
						img.setImageResource(R.drawable.seventh);
						rb02.setChecked(true);
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						answer.setEnabled(true);
						ll.setBackgroundColor(Color.rgb(227, 231, 234));
						tv.setTextColor(Color.BLACK);
						rb01.setTextColor(Color.BLACK);
						rb02.setText("我能看见（请在下方输入你所看见的物体的名称）");
						rb02.setTextColor(Color.BLACK);
						next.setTextColor(Color.BLACK);
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(true);
								answer.setText("");
							}
						});
                        rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
						});
						break;
					case 7:
						img.setImageResource(R.drawable.eighth);
						rb02.setChecked(true);
						answer.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
						answer.setText("");
						answer.setEnabled(true);
						ll.setBackgroundColor(Color.WHITE);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(true);
								answer.setText("");
							}
						});
                        rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
						});
						break;
					case 8:
						img.setImageResource(R.drawable.ninth);
						ll.setBackgroundColor(Color.WHITE);
						rb02.setChecked(true);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(true);
								answer.setText("");
							}
						});
                        rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
						});
						break;
					case 9:
						img.setImageResource(R.drawable.tenth);
						rb02.setChecked(true);
						answer.setText("");
						answer.setEnabled(true);
						ll.setBackgroundColor(Color.WHITE);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(true);
								answer.setText("");
							}
						});
                        rb02.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {
							
							@Override
							public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
								// TODO Auto-generated method stub
								answer.setEnabled(false);
							}
						});
						next.setTextColor(Color.BLACK);
						next.setText("查看结果");
						break;
					case 10:
						bun.putStringArray("key", ans);
						bun.putInt("flag", 1);
					    intent2.putExtras(bun);
						intent2.setClass(Test.this, Result.class);
						startActivity(intent2);
						break;
					default:
						break;
					}
				}
			});
			break;
		case 2:
			img.setImageResource(R.drawable.r_first);
			ll.setBackgroundColor(Color.rgb(254, 254, 254));
			tv.setTextColor(Color.BLACK);
			rb01.setTextColor(Color.BLACK);
			rb02.setTextColor(Color.BLACK);
			rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
			/**
			 * 设置文本编辑框的编辑文字为黑色
			 * 设置文本编辑框的初始文本为空
			 * 设置文本编辑框的初始编辑状态为可编辑
			 * 设置选项按钮的初始选择状态为选择选项2
			 */
			answer.setTextColor(Color.BLACK);
			answer.setText("");
			answer.setEnabled(true);
			rb02.setChecked(true);
			next.setTextColor(Color.BLACK);
			next.setText("next");
			/**
			 * 当选项按钮1被点击后文本框的编辑状态变为不可编辑
			 * 当选项按钮2被点击后文本框的编辑状态为可编辑
			 */
			rb01.setOnClickListener(listener);
			rb02.setOnClickListener(listener);

			next.setOnClickListener(new View.OnClickListener() {	
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					message = answer.getText().toString();
					if(rb02.isChecked() && !(message.isEmpty())){
						ans[k] = message;
						Log.i(TAG, ans[k]);
					}
					else{
						ans[k]="null";
					}
					k++;
					switch(k){
					case 1:
						img.setImageResource(R.drawable.r_second);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 2:
						img.setImageResource(R.drawable.r_third);
						ll.setBackgroundColor(Color.rgb(254, 254, 254));
						tv.setTextColor(Color.BLACK);
						answer.setEnabled(true);
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						rb02.setChecked(true);
						rb01.setTextColor(Color.BLACK);
						rb02.setTextColor(Color.BLACK);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						next.setTextColor(Color.BLACK);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 3:
						img.setImageResource(R.drawable.r_fourth);
						ll.setBackgroundColor(Color.rgb(255, 255, 255));
						answer.setEnabled(true);
						answer.setText("");
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 4:
						img.setImageResource(R.drawable.r_fifth);
						ll.setBackgroundColor(Color.rgb(254, 254, 254));
						answer.setEnabled(true);
						answer.setText("");
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 5:
						img.setImageResource(R.drawable.r_sixth);
						ll.setBackgroundColor(Color.rgb(244, 249, 252));
						answer.setEnabled(true);
						answer.setText("");
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 6:
						img.setImageResource(R.drawable.r_seventh);
						ll.setBackgroundColor(Color.rgb(175, 179, 178));
						tv.setTextColor(Color.WHITE);
						answer.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
						answer.setEnabled(true);
						answer.setTextColor(Color.WHITE);
						answer.setText("");
					/*	while(!(message.isEmpty()) && !(message>'a' && message<'z'||message>'A' && message<'Z')*/
								
						rb02.setChecked(true);
						rb01.setTextColor(Color.WHITE);
						rb02.setTextColor(Color.WHITE);
						rb02.setText("我能看见字母（请在下方输入您所看见的字母）");
						next.setTextColor(Color.WHITE);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 7:
						img.setImageResource(R.drawable.r_eighth);
						ll.setBackgroundColor(Color.rgb(254, 254, 254));
						tv.setTextColor(Color.BLACK);
						answer.setEnabled(true);
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						rb02.setChecked(true);
						rb01.setTextColor(Color.BLACK);
						rb02.setTextColor(Color.BLACK);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						next.setTextColor(Color.BLACK);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 8:
						img.setImageResource(R.drawable.r_ninth);
						ll.setBackgroundColor(Color.BLACK);
						tv.setTextColor(Color.WHITE);
						answer.setTextColor(Color.WHITE);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb01.setTextColor(Color.WHITE);
						rb02.setTextColor(Color.WHITE);
						rb02.setText("我能看见图片显示的内容（请在下方输入您所看见物体名称）");
						next.setTextColor(Color.WHITE);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 9:
						img.setImageResource(R.drawable.r_tenth);
						ll.setBackgroundColor(Color.rgb(252, 252, 252));
						tv.setTextColor(Color.BLACK);
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb01.setTextColor(Color.BLACK);
						rb02.setTextColor(Color.BLACK);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						next.setTextColor(Color.BLACK);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						next.setText("查看结果");
						break;
					case 10:
						intent2.setClass(Test.this, Result.class);
						bun.putStringArray("key", ans);
						bun.putInt("flag", 2);
						intent2.putExtras(bun);
						startActivity(intent2);
						break;
					default:
						break;
					}
				}
			});
			break;
		case 3:
			img.setImageResource(R.drawable.g_first);
			ll.setBackgroundColor(Color.rgb(253, 253, 253));
			tv.setTextColor(Color.BLACK);
			answer.setTextColor(Color.BLACK);
			answer.setText("");
			answer.setEnabled(true);
			rb02.setChecked(true);
			rb01.setTextColor(Color.BLACK);
			rb02.setTextColor(Color.BLACK);
			rb02.setText("我能看见有颜色的条带(请在下方输入你所看见的条带的颜色)");
			next.setTextColor(Color.BLACK);
			next.setText("next");
			rb01.setOnClickListener(listener);
			rb02.setOnClickListener(listener);
			next.setOnClickListener(new View.OnClickListener() {	
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					message = answer.getText().toString();
					if(rb02.isChecked() && !(message.isEmpty())){
						ans[k] = message;
						Log.i(TAG, ans[k]);
					}
					else
						ans[k] = "null";
					k++;
					switch(k){
					case 1:
						img.setImageResource(R.drawable.g_second);
						ll.setBackgroundColor(Color.rgb(254, 254, 254));
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnClickListener(new OnClickListener(){
							@Override
							public void onClick(View v){
								answer.setEnabled(false);
								answer.setText("");
							}
						});
						rb02.setOnClickListener(new OnClickListener(){
							@Override
							public void onClick(View v){
								answer.setEnabled(true);
							}
						});
						break;
					case 2:
						img.setImageResource(R.drawable.g_third);
						ll.setBackgroundColor(Color.rgb(172, 222, 101));
						tv.setTextColor(Color.WHITE);
						answer.setTextColor(Color.WHITE);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb01.setTextColor(Color.WHITE);
						rb02.setTextColor(Color.WHITE);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						next.setTextColor(Color.WHITE);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 3:
						img.setImageResource(R.drawable.g_fourth);
						ll.setBackgroundColor(Color.rgb(254, 254, 254));
						tv.setTextColor(Color.BLACK);
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb01.setTextColor(Color.BLACK);
						rb02.setTextColor(Color.BLACK);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						next.setTextColor(Color.BLACK);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 4:
						img.setImageResource(R.drawable.g_fifth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 5:
						img.setImageResource(R.drawable.g_sixth);
						ll.setBackgroundColor(Color.rgb(204, 237, 255));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 6:
						img.setImageResource(R.drawable.g_seventh);
						ll.setBackgroundColor(Color.rgb(255, 255, 255));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一只动物（请在下方输入您所看见的动物名称）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 7:
						img.setImageResource(R.drawable.g_eighth);
						ll.setBackgroundColor(Color.rgb(253, 253, 253));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字（请在下方输入您所看见的数字）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 8:
						img.setImageResource(R.drawable.g_ninth);
						ll.setBackgroundColor(Color.rgb(255, 255, 255));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一只动物（请在下方输入您所看见的动物名称）");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 9:
						img.setImageResource(R.drawable.g_tenth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见两个环(请在下方输入你看见的环的形状)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						next.setText("查看结果");
						break;
					case 10:
						intent2.setClass(Test.this, Result.class);
						bun.putStringArray("key", ans);
						bun.putInt("flag",3);
						intent2.putExtras(bun);
						startActivity(intent2);
						break;
					default:
						break;
					}
				}
			});
			break;
		case 4:
			img.setImageResource(R.drawable.by_first);
			ll.setBackgroundColor(Color.BLACK);
			tv.setTextColor(Color.WHITE);
			answer.setTextColor(Color.WHITE);
			answer.setText("");
			answer.setEnabled(true);
			rb02.setChecked(true);
			rb01.setTextColor(Color.WHITE);
			rb02.setTextColor(Color.WHITE);
			rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
			next.setTextColor(Color.WHITE);
			rb01.setOnClickListener(listener);
			rb02.setOnClickListener(listener);
			next.setText("next");
			next.setOnClickListener(new View.OnClickListener() {	
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					message = answer.getText().toString();
					if(rb02.isChecked() && !(message.isEmpty())){
						ans[k] = message;
						Log.i(TAG, ans[k]);
					}
					else
						ans[k]="null";
					k++;
					switch(k){
					case 1:
						img.setImageResource(R.drawable.by_second);
						ll.setBackgroundColor(Color.rgb(248, 248, 248));
						tv.setTextColor(Color.BLACK);
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb01.setTextColor(Color.BLACK);
						rb02.setTextColor(Color.BLACK);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						next.setTextColor(Color.BLACK);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 2:
						img.setImageResource(R.drawable.by_third);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb02.setChecked(true);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 3:
						img.setImageResource(R.drawable.by_fourth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb02.setChecked(true);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 4:
						img.setImageResource(R.drawable.by_fifth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 5:
						img.setImageResource(R.drawable.by_sixth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb02.setChecked(true);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 6:
						img.setImageResource(R.drawable.by_eventh);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						next.setText("查看结果");
						break;
					case 7:
						intent2.setClass(Test.this, Result.class);
						bun.putStringArray("key", ans);
						bun.putInt("flag", 4);
						intent2.putExtras(bun);
						startActivity(intent2);
						break;
					default:
						break;
					}
				}
			});
			break;
		case 5:
			img.setImageResource(R.drawable.a_first);
			ll.setBackgroundColor(Color.WHITE);
			tv.setTextColor(Color.BLACK);
			answer.setTextColor(Color.BLACK);
			answer.setText("");
			answer.setEnabled(true);
			rb02.setChecked(true);
			rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
			rb01.setTextColor(Color.BLACK);
			rb02.setTextColor(Color.BLACK);
			next.setTextColor(Color.BLACK);
			rb01.setOnClickListener(listener);
			rb02.setOnClickListener(listener);
			next.setText("next");
			next.setOnClickListener(new View.OnClickListener() {	
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					message = answer.getText().toString();
					if(rb02.isChecked() && !(message.isEmpty())){
						ans[k]=message;
						Log.i(TAG, ans[k]);
					}
					else
						ans[k] = "null";
					k++;
					switch(k){
					case 1:
						img.setImageResource(R.drawable.a_second);
						break;
					case 2:
						img.setImageResource(R.drawable.a_third);
						ll.setBackgroundColor(Color.rgb(232, 232, 232));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 3:
						img.setImageResource(R.drawable.a_fourth);
						ll.setBackgroundColor(Color.WHITE);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能分辨图片中的颜色(请在下方输入你所看见的颜色)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 4:
						img.setImageResource(R.drawable.a_fifth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 5:
						img.setImageResource(R.drawable.a_sixth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 6:
						img.setImageResource(R.drawable.a_seventh);
						ll.setBackgroundColor(Color.rgb(253, 253, 253));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见有颜色的环(请在下方输入你所看见环的颜色)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 7:
						img.setImageResource(R.drawable.a_eighth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见有颜色的条带(请在下方输入你所看见条带的颜色)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 8:
						img.setImageResource(R.drawable.a_ninth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能分辨图片中的颜色(请在下方输入你所看见的颜色)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 9:
						img.setImageResource(R.drawable.a_tenth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						next.setText("查看结果");
						break;
					case 10:
						intent2.setClass(Test.this, Result.class);
						bun.putStringArray("key", ans);
						bun.putInt("flag", 5);
						intent2.putExtras(bun);
						startActivity(intent2);
						break;
					default:
						break;
					}
				}
			});
			break;
		case 6:
			img.setImageResource(R.drawable.all_first);
			ll.setBackgroundColor(Color.rgb(255, 255, 255));
			tv.setTextColor(Color.BLACK);
			answer.setTextColor(Color.BLACK);
			answer.setText("");
			answer.setEnabled(true);
			rb02.setChecked(true);
			rb01.setTextColor(Color.BLACK);
			rb02.setTextColor(Color.BLACK);
			rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
			next.setTextColor(Color.BLACK);
			rb01.setOnClickListener(listener);
			rb02.setOnClickListener(listener);
			next.setText("next");
			next.setOnClickListener(new View.OnClickListener() {	
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					message = answer.getText().toString();
					ans[k] = message;
					if(rb02.isChecked() && !(message.isEmpty())){
						ans[k] = message;
						Log.i(TAG, ans[k]);
					}
					else
						ans[k] = "null";
					k++;
					switch(k){
					case 1:
						img.setImageResource(R.drawable.all_second);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 2:
						img.setImageResource(R.drawable.all_third);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 3:
						img.setImageResource(R.drawable.all_fourth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 4:
						img.setImageResource(R.drawable.all_fifth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 5:
						img.setImageResource(R.drawable.all_sixth);
						ll.setBackgroundColor(Color.rgb(209, 227, 187));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个字母(请在下方输入你所看见的字母)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 6:
						img.setImageResource(R.drawable.all_seventh);
						ll.setBackgroundColor(Color.rgb(248, 248, 248));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 7:
						img.setImageResource(R.drawable.all_eighth);
						ll.setBackgroundColor(Color.BLACK);
						tv.setTextColor(Color.WHITE);
						answer.setTextColor(Color.WHITE);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb01.setTextColor(Color.WHITE);
						rb02.setTextColor(Color.WHITE);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						next.setTextColor(Color.WHITE);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 8:
						img.setImageResource(R.drawable.all_ninth);
						ll.setBackgroundColor(Color.rgb(242, 255, 250));
						tv.setTextColor(Color.BLACK);
						answer.setTextColor(Color.BLACK);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb01.setTextColor(Color.BLACK);
						rb02.setTextColor(Color.BLACK);
						rb02.setText("我能看见一个单词(请在下方输入你所看见的单词)");
						next.setTextColor(Color.BLACK);
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 9:
						img.setImageResource(R.drawable.all_tenth);
						ll.setBackgroundColor(Color.rgb(232, 233, 193));
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个字母(请在下方输入你所看见的字母)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						next.setText("查看结果");
						break;
					case 10:
						intent2.setClass(Test.this, Result.class);
						bun.putStringArray("key", ans);
						bun.putInt("flag",6);
						intent2.putExtras(bun);
						startActivity(intent2);
						break;
					default:
						break;
					}
				}
			});
			break;
		case 7:
			img.setImageResource(R.drawable.p_first);
			ll.setBackgroundColor(Color.rgb(248, 248, 248));
			answer.setText("");
			answer.setEnabled(true);
			rb02.setChecked(true);
			rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
			rb01.setOnClickListener(listener);
			rb02.setOnClickListener(listener);
			next.setText("next");
			next.setOnClickListener(new View.OnClickListener() {	
				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					message = answer.getText().toString();
					if(rb02.isChecked() && !(message.isEmpty())){
						ans[k] = message;
						Log.i(TAG, ans[k]);
					}
					else
						ans[k] = "null";
					k++;
					switch(k){
					case 1:
						img.setImageResource(R.drawable.p_second);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 2:
						img.setImageResource(R.drawable.p_third);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 3:
						img.setImageResource(R.drawable.p_fourth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 4:
						img.setImageResource(R.drawable.p_fifth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 5:
						img.setImageResource(R.drawable.p_sixth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 6:
						img.setImageResource(R.drawable.p_seventh);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 7:
						img.setImageResource(R.drawable.p_eighth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 8:
						img.setImageResource(R.drawable.p_ninth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						break;
					case 9:
						img.setImageResource(R.drawable.p_tenth);
						answer.setText("");
						answer.setEnabled(true);
						rb02.setChecked(true);
						rb02.setText("我能看见一个数字(请在下方输入你所看见的数字)");
						rb01.setOnClickListener(listener);
						rb02.setOnClickListener(listener);
						next.setText("查看结果");
						break;
					case 10:
						intent2.setClass(Test.this, Result.class);
						bun.putStringArray("key",ans);
						bun.putInt("flag", 7);
						intent2.putExtras(bun);
						startActivity(intent2);
						break;
					default:
						break;
					}
				}
			});
			break;
		default:
			break;
		}
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.i(TAG, "Test->onRestart");
		super.onRestart();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.i(TAG, "Test->onResume");
		super.onResume();
	}
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.i(TAG, "Test->onStart");
		super.onStart();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.i(TAG, "Test->onPause");
		super.onPause();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.i(TAG, "Test->onStop");
		super.onStop();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(TAG, "Test->onDestory");
		super.onDestroy();
	}
	

/*	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode ==KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
			if((System.currentTimeMillis()-exitTime)>2000){
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			    exitTime = System.currentTimeMillis();
			}
			else{
				finish();
				System.exit(0);
				}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}*/


	private OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			RadioButton rb = (RadioButton)v;
			if(rb.getId() == R.id.choice01){
				answer.setEnabled(false);
				answer.setText("");
			}
			else if(rb.getId() == R.id.choice02)
				answer.setEnabled(true);
		}
	};
}
