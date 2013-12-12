package com.adam.com.app.mediaplayer;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private MediaPlayer mp = new MediaPlayer();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public void onPlay(View v) {
		try {
            mp.setDataSource("/sdcard/music/testmp3.mp3");
            mp.prepare();
            mp.start();
         } catch (IllegalArgumentException e) {
            e.printStackTrace();
         } catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
		
		 
	}
	
	public void onPause(View v) {
		if(mp != null){
            mp.pause();
         }
	}

	public void onStop(View v) {
		if(mp != null){
            mp.stop();
         }
	}
	
	@Override
    protected void onDestroy() {
       if(mp != null)
           mp.release();
       super.onDestroy();
    }

}