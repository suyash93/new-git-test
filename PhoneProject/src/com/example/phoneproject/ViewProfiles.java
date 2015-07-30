package com.example.phoneproject;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewProfiles extends Activity {

	String[] data;
	ArrayList<String> AList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_profile_layout);
		initialise();

	}

	private void initialise() {

		getDataFromDB();
		ListView list = (ListView) findViewById(R.id.profile_list);
		ArrayAdapter<String> adap = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, data);
		list.setAdapter(adap);
	}

	private void getDataFromDB() {

		Profile_DB_HANDLER DBH = new Profile_DB_HANDLER(this);
		Cursor cs = DBH.getAllData();

		while (cs.moveToNext()) {

			String temp = cs.getString(1).toUpperCase() + " : "
					+ cs.getString(0);
			AList.add(temp);
		}

		String[] temp = new String[AList.size()];
		for (int i = 0; i < AList.size(); i++)
			temp[i] = AList.get(i).toString();
		data = temp;
	}
}
