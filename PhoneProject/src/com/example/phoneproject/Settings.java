package com.example.phoneproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Settings extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		Button b_new = (Button) findViewById(R.id.new_profile);
		b_new.setOnClickListener(this);

		Button b_view = (Button) findViewById(R.id.view_profile);
		b_view.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg) {
		// TODO Auto-generated method stub
		if (arg.getId() == R.id.new_profile) {
			Intent i = new Intent(Settings.this, NewProfile.class);
			startActivity(i);
		}

		else if (arg.getId() == R.id.view_profile) {
			Intent i = new Intent(Settings.this, ViewProfiles.class);
			startActivity(i);
		}

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();

		Intent inte = new Intent(Settings.this, Home.class);
		finish();
		startActivity(inte);
	}
}
