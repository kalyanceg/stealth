package com.example.budget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
 
public class WebViewActivity extends Activity {
 
	private WebView webView;
 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webtrial);
 
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/graphs.html");
		webView.setWebViewClient(new WebViewClient());
	}
	public void onBackPressed() {
		Intent intent = new Intent(WebViewActivity.this, MainActivity.class);
        startActivity(intent);      
        finish();  
	}
 
}