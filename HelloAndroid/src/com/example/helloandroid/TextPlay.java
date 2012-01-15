package com.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		final EditText inputCommand = (EditText) findViewById(R.id.etCommand);
		Button sendCommand = (Button) findViewById(R.id.bSendCommand);
		final ToggleButton passwordToggle = (ToggleButton) findViewById(R.id.tbPasswordToggle);
		final TextView commandText = (TextView) findViewById(R.id.tvCommandText);
		
		passwordToggle.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if (passwordToggle.isChecked()) {
					inputCommand.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				} else {
					inputCommand.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		});
		
		sendCommand.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String inputString = inputCommand.getText().toString();
				
				commandText.setText(inputString);
				if (inputString.contentEquals("left")) {
					commandText.setGravity(Gravity.LEFT);
				} else if (inputString.contentEquals("right")) {
					commandText.setGravity(Gravity.RIGHT);
				} else if (inputString.contentEquals("center")) {
					commandText.setGravity(Gravity.CENTER);
				} else {
					// TODO toast here some message?
				}
			}
		});
	}

}
