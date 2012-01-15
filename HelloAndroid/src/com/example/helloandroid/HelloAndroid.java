package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class HelloAndroid extends Activity {

	final String[] COLORS = { "red", "green", "orange", "blue", "purple",
			"black", "yellow", "cyan", "magenta" };
	private final static String DEBUG_TAG = "HelloAndroid debug tag";
	private MediaPlayer mp;
	
	int light_id = 0, dark_id = 0, style_group = 0;
	int shapeGroup = 0, square = 0, circle = 0;
	boolean isLight = false;
	boolean isSquare = false;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// TextView tv = new TextView(this);
		// tv.setText("Hello Android, this is your master qmmr, obey me!");
		// setContentView(tv);

		setContentView(R.layout.main);

		// forceError();
		Log.i(DEBUG_TAG, "Here I can write what happenes.");
		


		// setContentView(R.layout.autocomplete);

		// AUTOCOMPLETE FIELDS
		// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_dropdown_item_1line, COLORS);
		// AutoCompleteTextView text = (AutoCompleteTextView)
		// findViewById(R.id.autoCompleteTextView);
		// text.setAdapter(adapter);
		//
		// MultiAutoCompleteTextView mtext = (MultiAutoCompleteTextView)
		// findViewById(R.id.multiAutoCompleteTextView);
		// mtext.setAdapter(adapter);
		// mtext.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		//
		// final EditText textFiltered = (EditText)
		// findViewById(R.id.textFiltered);
		// textFiltered.setFilters(new InputFilter[] { new
		// InputFilter.AllCaps(),
		// new InputFilter.LengthFilter(2) });

		/* TODO find out why spinner is not working */
		// final Spinner spin = (Spinner) findViewById(R.id.spinner);
		// TextView text_sel = (TextView) spin.getSelectedView();
		// String selected_text = (String) text_sel.getText();

		// playMusicFromWeb();
		// getLocation();

		/*
		 * BUTTONS
		 */
		/*
		 * setContentView(R.layout.buttons); // basic button with toast final
		 * Button cancel = (Button) findViewById(R.id.button1);
		 * cancel.setOnClickListener(new View.OnClickListener() {
		 * 
		 * public void onClick(View v) { // TODO Auto-generated method stub
		 * Toast.makeText(HelloAndroid.this, "Cancel was pressed!",
		 * Toast.LENGTH_SHORT).show(); } });
		 * 
		 * // checkbox that changes it's own text onClick final CheckBox
		 * checkbox = (CheckBox) findViewById(R.id.checkbox1);
		 * checkbox.setOnClickListener(new View.OnClickListener() {
		 * 
		 * public void onClick(View v) { // TODO Auto-generated method stub
		 * TextView tv = (TextView) findViewById(R.id.checkbox1);
		 * tv.setText(checkbox.isChecked() ? "It is checked!" :
		 * "It is NOT checked"); } });
		 * 
		 * // radio buttons & radio group final RadioGroup group = (RadioGroup)
		 * findViewById(R.id.radioGroup); final TextView tv = (TextView)
		 * findViewById(R.id.radioButtonText);
		 * 
		 * group.setOnCheckedChangeListener(new
		 * RadioGroup.OnCheckedChangeListener() {
		 * 
		 * public void onCheckedChanged(RadioGroup group, int checkedId) { //
		 * TODO Auto-generated method stub if (checkedId != -1) { RadioButton rb
		 * = (RadioButton) findViewById(checkedId); if (rb != null) {
		 * tv.setText("You chose: " + rb.getText()); } } else {
		 * tv.setText("You need to choose an option."); } } });
		 * 
		 * // clears out radio buttons final Button clear = (Button)
		 * findViewById(R.id.clearRadios); clear.setOnClickListener(new
		 * View.OnClickListener() {
		 * 
		 * public void onClick(View v) { // TODO Auto-generated method stub
		 * RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup); if (rg !=
		 * null) { rg.clearCheck(); Toast.makeText(HelloAndroid.this,
		 * "Cleared radio buttons options", Toast.LENGTH_SHORT) .show(); } } });
		 */

		/* datepicker */
		// final DatePicker date = (DatePicker) findViewById(R.id.datePicker1);
		// final TimePicker time = (TimePicker) findViewById(R.id.timePicker);
		// final TextView dateText = (TextView) findViewById(R.id.displayDate);
		//
		// date.init(date.getYear(), date.getMonth(), date.getDayOfMonth(),
		// new DatePicker.OnDateChangedListener() {
		// public void onDateChanged(DatePicker view, int year,
		// int monthOfYear, int dayOfMonth) {
		// Date dt = new Date(year - 1900, monthOfYear,
		// dayOfMonth, time.getCurrentHour(), time
		// .getCurrentMinute());
		// dateText.setText(dt.toString());
		// }
		// });
		//
		//
		// time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener()
		// {
		// public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
		// {
		// Date dt = new Date(date.getYear() - 1900, date.getMonth(), date
		// .getDayOfMonth(), hourOfDay, minute);
		// dateText.setText(dt.toString());
		// }
		// });

		ProgressBar hProgress = (ProgressBar) findViewById(R.id.hProgressBar);
		hProgress.setProgress(75);

		// TODO application bar is not working
		// requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		// requestWindowFeature(Window.FEATURE_PROGRESS);
		// setContentView(R.layout.indicators);
		// setProgressBarIndeterminateVisibility(true);
		// setProgressBarVisibility(true);
		// setProgress(5000);

		SeekBar seek = (SeekBar) findViewById(R.id.seekBar);
		seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				((TextView) findViewById(R.id.seekText)).setText("Value: "
						+ progress);
				seekBar.setSecondaryProgress((progress + seekBar.getMax()) / 2);
			}
		});

		RatingBar rate = (RatingBar) findViewById(R.id.ratingBar);
		rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				// TODO Auto-generated method stub
				((TextView) findViewById(R.id.rateText)).setText("Rating: "
						+ rating);
			}
		});

		final Chronometer timer = (Chronometer) findViewById(R.id.chronometer);
		long base = timer.getBase();
		Log.d(DEBUG_TAG, "base = " + base);
		timer.setBase(0);
		timer.start();
		
		Button lpb = (Button) findViewById(R.id.longPress);
		lpb.setOnLongClickListener(new View.OnLongClickListener() {
			
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				TextView events;
				((TextView) findViewById(R.id.rateText)).setText("Long press text: " + v.toString());
				return false;
			}
		});

		TextView focus = (TextView) findViewById(R.id.tvFocus);
		focus.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			public void onFocusChange(View v, boolean hasFocus) {
				String mSaveText = "";
				// TODO Auto-generated method stub
				if (hasFocus) {
					if (mSaveText != null) {
						((TextView)v).setText(mSaveText);
					}
				} else {
					mSaveText = ((TextView)v).getText().toString();
					((TextView)v).setText("");
				}
			}
		});
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);

		if (v.getId() == R.id.chronometer) {
			// getMenuInflater().inflate(R.menu.timer_context, menu);
			menu.setHeaderIcon(android.R.drawable.ic_media_play)
					.setHeaderTitle("Timer controls");
		}
	}

	/*
	 * OVERRIDE MENU DEFAULT
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		menu.add("Forms").setIcon(android.R.drawable.ic_menu_edit)
				.setIntent(new Intent(this, HelloAndroid.class));
		menu.add("Indicators").setIntent(new Intent(this, HelloAndroid.class))
				.setIcon(android.R.drawable.ic_menu_info_details);
		menu.add("Containers").setIcon(android.R.drawable.ic_menu_view)
				.setIntent(new Intent(this, HelloAndroid.class));
		menu.add("Shapes").setIcon(android.R.drawable.ic_menu_view)
				.setIntent(new Intent(this, HelloAndroid.class));

		/* adding submenu */
		SubMenu style_choice = menu.addSubMenu("Style").setIcon(
				android.R.drawable.ic_menu_preferences);

		style_choice.add(style_group, light_id, 1, "Light").setChecked(isLight);
		style_choice.add(style_group, dark_id, 2, "Dark").setChecked(!isLight);
		style_choice.setGroupCheckable(style_group, true, true);

		/* another submenu to shapes */
		SubMenu shapeChoice = menu.addSubMenu("Shapes").setIcon(
				android.R.drawable.ic_lock_idle_alarm);

		shapeChoice.add(shapeGroup, square, 1, "Square").setChecked(isSquare);
		shapeChoice.add(shapeGroup, circle, 2, "Circle").setChecked(!isSquare);
		shapeChoice.setGroupCheckable(shapeGroup, true, true);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == light_id) {
			item.setChecked(true);
			isLight = true;
			return true;
		} else if (item.getItemId() == dark_id) {
			item.setChecked(true);
			isLight = false;
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void getLocation() {
		// TODO Auto-generated method stub
		try {
			LocationManager locManager = (LocationManager) getSystemService(LOCATION_SERVICE);
			Location recentLocation = locManager
					.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			Log.i(DEBUG_TAG, "loc: " + recentLocation.toString());
		} catch (Exception e) {
			// TODO: handle exception
			Log.e(DEBUG_TAG, "Location could not be determined.");
		}
	}

	public void forceError() {
		// TODO Auto-generated method stub
		if (true) {
			throw new Error("Whoops!");
		}

	}

	public void playMusicFromWeb() {
		try {
			Uri file = Uri.parse("http://www.perlgurl.org/podcast/archives"
					+ "/podcasts/PerlgurlPromo.mp3");
			mp = MediaPlayer.create(this, file);
			mp.start();
		} catch (Exception e) {
			// TODO: handle exception
			Log.e(DEBUG_TAG, "Player failed.", e);
		}

	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		if (mp != null) {
			mp.stop();
			mp.release();
		}
		super.onStop();
	}
}