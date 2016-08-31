package com.example.mytime;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button startButton;
	EditText minuteText;
	EditText secondText;
	int minute;
	int second;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		startButton = (Button) findViewById(R.id.button_start);
		minuteText = (EditText)findViewById(R.id.minute);
		secondText = (EditText)findViewById(R.id.second);
		
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!minuteText.getText().toString().equals("")) {
					minute = Integer.parseInt(minuteText.getText().toString());
				}
				if (!secondText.getText().toString().equals("")) {
					second = Integer.parseInt(secondText.getText().toString());
				}
				if (minute != 0 || second != 0) {
					System.out.println(minute+":"+second);
					
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(minute);
					list.add(second);
					
					Intent intent = new Intent();
					intent.setAction("com.example.mytime.StartActivity");
					
					intent.putIntegerArrayListExtra("times", list);
					startActivity(intent);
				}
			}
		});
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		minute = 0;
		second = 0;
		super.onResume();
	}
}