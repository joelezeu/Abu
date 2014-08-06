package com.hymn.abu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class PREFACE extends Activity{
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preface);
		WebView web = (WebView) findViewById(R.id.webView);
		web.loadUrl("file:///android_asset/www/preface.html");
		
		
		//FullScreen Activity
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
	}
}
