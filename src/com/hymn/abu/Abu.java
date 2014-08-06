package com.hymn.abu;

import java.util.Calendar;

import org.apache.cordova.Config;
import org.apache.cordova.DroidGap;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class Abu extends DroidGap {

	int days = 1000 * 60 * 60 * 24 * 7;

	private static final String AdMob_Ad_Unit = "ca-app-pub-5097311674810020/5242974795";
	private AdView adView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");
		super.setIntegerProperty("splashscreen", R.drawable.abu);
		super.loadUrl(Config.getStartUrl(), 5000);

		Intent myIntent = new Intent(Abu.this, AlarmReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(Abu.this, 0,
		myIntent, 0);
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

		Calendar car = Calendar.getInstance();
		car.setTimeInMillis(System.currentTimeMillis());
		car.set(Calendar.DAY_OF_WEEK, 1);
		car.set(Calendar.HOUR_OF_DAY, 7);
		car.set(Calendar.MINUTE, 0);
		car.set(Calendar.SECOND, 0);

		alarmManager.set(AlarmManager.RTC, car.getTimeInMillis(), pendingIntent);
		
		if (alarmManager != null){
			alarmManager.cancel(pendingIntent);
		}

		adView = new AdView(this, AdSize.BANNER, AdMob_Ad_Unit);
		LinearLayout layout = super.root;
		layout.addView(adView);
		AdRequest request = new AdRequest();
		request.setTesting(true);
		adView.loadAd(request);

	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.abu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.hymn.abu.ABOUT");
			startActivity(i);
			break;

		case R.id.preface:
			Intent p = new Intent("com.hymn.abu.PREF");
			startActivity(p);

			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;
	}
}