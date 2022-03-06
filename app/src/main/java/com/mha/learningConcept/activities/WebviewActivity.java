package com.mha.learningConcept.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivityWebviewBinding;

public class WebviewActivity extends AppCompatActivity {
    ActivityWebviewBinding binding;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading... please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();

        binding.webView.loadUrl("https://developer.android.com/reference/android/webkit/WebView");
        binding.webView.setWebViewClient(new MyWebViewClient());
    }

    class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressDialog.dismiss();
            Toast.makeText(WebviewActivity.this, "FINISHED", Toast.LENGTH_SHORT).show();
        }
    }
}