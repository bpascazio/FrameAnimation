package com.bytefly.example.frameanimation;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends Activity {

	Button button;
	ImageView image;
	AnimationDrawable animation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_frame_animation);
		button = (Button)findViewById(R.id.buttonstart);
		image = (ImageView)findViewById(R.id.imageView1);
		
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startAnimation();
			}
		});	
	}
	
	class Starter implements Runnable {
		public void run() {
			animation.start();
		}
	}
	
	void startAnimation() {
		animation = new AnimationDrawable();
		animation.addFrame(getResources().getDrawable(R.drawable.h1), 2);
		animation.addFrame(getResources().getDrawable(R.drawable.h2), 2);
		animation.addFrame(getResources().getDrawable(R.drawable.h3), 2);
		animation.addFrame(getResources().getDrawable(R.drawable.h4), 2);
		animation.setOneShot(false);
		
		image.setImageDrawable(animation);
		image.post(new Starter());
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.frame_animation, menu);
		return true;
	}

}
