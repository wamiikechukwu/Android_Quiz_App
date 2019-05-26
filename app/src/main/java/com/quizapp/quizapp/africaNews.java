package com.quizapp.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class africaNews extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(webView);

        webView = findViewById(R.id.webView);

        webView.loadUrl("https://www.africanews.com");

        webView.setWebViewClient(WebViewClient);
    }
}
