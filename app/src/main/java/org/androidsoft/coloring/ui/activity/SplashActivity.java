
package org.androidsoft.coloring.ui.activity;

import org.androidsoft.coloring.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class SplashActivity extends Activity  {

	private Button mButtonPlay, mButtonPlay2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.splash);

		mButtonPlay = (Button) findViewById(R.id.button_go);
		//mButtonPlay.setOnClickListener(this);
		mButtonPlay2 = (Button) findViewById(R.id.button_go2);
		//mButtonPlay2.setOnClickListener(this);

		ImageView image = (ImageView) findViewById(R.id.image_splash);
		image.setImageResource(R.drawable.splach_icon);

	}

	/**
	 * {@inheritDoc }
	 */
	public void onClick(View v) {
		if (v == mButtonPlay) {
			Intent intent = new Intent(this, PaintActivity.class);
			startActivity(intent);
		} else if (v == mButtonPlay2) {
			
		}
	}

	
}