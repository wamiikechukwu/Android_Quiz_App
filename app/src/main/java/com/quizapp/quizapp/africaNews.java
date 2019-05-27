package com.quizapp.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class africaNews extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_africa_news);

        webView = findViewById(R.id.webView);

        webView.loadUrl("https://www.africanews.com");
        webView.setWebViewClient(new MyWebViewClient());
    }

    //This class enables web actions to be performed within the WebView without calling any
    // browser intent
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

}
