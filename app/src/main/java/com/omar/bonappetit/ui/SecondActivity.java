package com.omar.bonappetit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.omar.bonappetit.R;

public class SecondActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setupUI();
	}

	private void setupUI() {
		final Toolbar toolbar;

		/* apply default app theme */
		setTheme(R.style.AppTheme);

		/* view main app content */
		setContentView(R.layout.activity_second);

		/* attach views */
		toolbar = findViewById(R.id.second_toolbar);

		/* setup toolbar */
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}
}
