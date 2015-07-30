package com.example.phoneproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewProfile extends Activity implements OnClickListener {

	static final String NAME_KEY = "pname";

	EditText pname;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_profile);

		Button bu = (Button) findViewById(R.id.exist);
		bu.setOnClickListener(this);

		Button b1 = (Button) findViewById(R.id.new_Loc);
		b1.setOnClickListener(this);

		Button b2 = (Button) findViewById(R.id.create);
		b2.setOnClickListener(this);

		pname = (EditText) findViewById(R.id.edit_name);
	}

	@Override
	public void onClick(View va) {
		// TODO Auto-generated method stub
		if (va.getId() == R.id.exist) {

			if (!pname.getText().toString().equals("")) {
				finish();
				Intent inte = new Intent(NewProfile.this, Exist_location.class);
				inte.putExtra(NAME_KEY, pname.getText().toString());
				startActivity(inte);
			} else
				Toast.makeText(getApplicationContext(),
						"Enter a valid Profile name First!", Toast.LENGTH_SHORT)
						.show();
		}

		else if (va.getId() == R.id.new_Loc) {

			Toast.makeText(getApplicationContext(),
					"Your Current Location is predefined !", Toast.LENGTH_LONG)
					.show();
			// Intent inte = new Intent(NewProfile.this, New_location.class);
			// startActivity(inte);
		}

		else if (va.getId() == R.id.create) {

		}

	}
}
