package com.example.phoneproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		Button bs = (Button) findViewById(R.id.settings);
		bs.setOnClickListener(this);

		Button ba = (Button) findViewById(R.id.About);
		ba.setOnClickListener(this);

		Button bh = (Button) findViewById(R.id.Help);
		bh.setOnClickListener(this);
	}

	@Override
	public void onClick(View va) {
		// TODO Auto-generated method stub
		if (va.getId() == R.id.settings) {
			Intent inte = new Intent(Home.this, Settings.class);
			startActivity(inte);
		} else if (va.getId() == R.id.About) {
			Intent inte = new Intent(Home.this, About.class);
			startActivity(inte);
		} else if (va.getId() == R.id.Help) {
			Intent inte = new Intent(Home.this, Help.class);
			startActivity(inte);
		}
	}
}
