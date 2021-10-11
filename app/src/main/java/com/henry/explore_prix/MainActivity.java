package com.henry.explore_prix;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    WebView mywebView;
    TextView url;
    String ruta;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mywebView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        url = (TextView) findViewById(R.id.urls);
    }

    public void cargar(View view) {
        ruta = url.getText().toString();
        mywebView.loadUrl(ruta);
        mywebView.setWebViewClient(webViewClient);
    }

    private WebViewClient webViewClient = new WebViewClient(){
        @Override
        public void onPageFinished(WebView view, String url){
            progressBar.setVisibility(view.GONE);
        }
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            progressBar.setVisibility(view.VISIBLE);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String rute){
            Log.i("","url: "+ruta);
            return super.shouldOverrideUrlLoading(view,rute);
        }
    };
}