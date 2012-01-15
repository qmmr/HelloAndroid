package com.example.helloandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classesList[] = { "HelloAndroid", "TextPlay", "Arrayz",
			"Time", "project4" };

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		String clickedLinkName = classesList[position]; // when we click an item we can get the name via the id
		Class ourClass; // placeholder for the Intent
		
		try {
			ourClass = Class.forName("com.example.helloandroid." + clickedLinkName);
			Intent newActivityIntent = new Intent(Menu.this, ourClass);
			startActivity(newActivityIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classesList));
	}

}
