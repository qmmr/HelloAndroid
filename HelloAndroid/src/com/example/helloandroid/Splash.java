package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {

	// splash song
	private MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		mp = MediaPlayer.create(Splash.this, R.raw.cascada_night_nurse);
//		mp.start();

		Thread startupTimer = new Thread() {
			public void run() {
				try {
					sleep(5000); // app will sleep for 5 sec.
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openHelloAndroid = new Intent("com.example.helloandroid.MENU");
					// needs to be the name of the activity you want to launch
					startActivity(openHelloAndroid);
				}
			}

		};

		startupTimer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mp.release(); // ends music
		finish(); // ends activity for good Destroy yourself!
	}

}
