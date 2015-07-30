package com.example.phoneproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Exist_location extends Activity implements OnClickListener {

	String Pname_obtained;
	String Profile_header;

	RadioGroup profiles;

	static final String HEADER_KEY = "header";

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exist_loc);

		Pname_obtained = getIntent().getStringExtra(NewProfile.NAME_KEY);
		Toast.makeText(getApplicationContext(), Pname_obtained,
				Toast.LENGTH_LONG).show();
		initialise();

	}

	private void initialise() {

		Button b = (Button) findViewById(R.id.Next);
		b.setOnClickListener(this);

		profiles = (RadioGroup) findViewById(R.id.profile_group);

	}

	@Override
	public void onClick(View arg) {

		if (arg.getId() == R.id.Next) {

			int id = profiles.getCheckedRadioButtonId();
			RadioButton bt = (RadioButton) findViewById(id);
			Profile_header = (String) bt.getText();
			Toast.makeText(getApplicationContext(), Profile_header,
					Toast.LENGTH_LONG).show();
			Intent i = new Intent(Exist_location.this, Profile.class);
			i.putExtra(HEADER_KEY, Profile_header);
			i.putExtra(NewProfile.NAME_KEY, Pname_obtained);
			startActivity(i);
		}
	}
}
