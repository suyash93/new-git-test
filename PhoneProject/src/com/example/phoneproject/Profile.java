package com.example.phoneproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Profile extends Activity {

	String Profile_name, Profile_header;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		initialise();

		Profile_header = getIntent().getStringExtra(Exist_location.HEADER_KEY);
		Profile_name = getIntent().getStringExtra(NewProfile.NAME_KEY);
	}

	private void initialise() {

		Button browse_tones_alert, browse_tones_ringer, browse_wallpapers, Save_bt;

		browse_tones_alert = (Button) findViewById(R.id.profile_tone_alert_browse);
		browse_wallpapers = (Button) findViewById(R.id.profile_wall_browse);
		browse_tones_ringer = (Button) findViewById(R.id.profile_tone_ringer_browse);
		Save_bt = (Button) findViewById(R.id.saveFinal);

		browse_tones_alert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, 1);

			}
		});

		browse_wallpapers.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, 2);
			}
		});

		browse_tones_ringer.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, 3);

			}
		});

		Save_bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Profile_DB_HANDLER DBHandler = new Profile_DB_HANDLER(
						getApplicationContext());

				boolean result = DBHandler.addProfile(Profile_name,
						Profile_header);
				if (result)
					Toast.makeText(getApplicationContext(), "Added profile",
							Toast.LENGTH_SHORT).show();

				Intent inte = new Intent(Profile.this, Settings.class);
				startActivity(inte);
				finish();

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 1 && resultCode == RESULT_OK) {

		}
	}

}
