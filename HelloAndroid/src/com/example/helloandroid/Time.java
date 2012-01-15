package com.example.helloandroid;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Time extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time);

		final TextView myTextview = (TextView) findViewById(R.id.tvShowTime);
		Button myButton = (Button) findViewById(R.id.bShowTime);

		myButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
				String strWhen = formatter.format(new Date());
				myTextview.setText("Clicked at " + strWhen);
			}
		});

	}

}
