package com.mha.learningConcept.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mha.learningConcept.Keys.Keys;
import com.mha.learningConcept.R;

public class SecondActivity extends AppCompatActivity {
    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvDisplay = findViewById(R.id.tv_display);

        Intent intent = getIntent();
//        String mobileNo = intent.getStringExtra(Keys.KEY_MOBILE);
        Bundle bundle = intent.getBundleExtra(Keys.KEY_BUNDLE);
        String mobileNo = bundle.getString(Keys.KEY_MOBILE);
        tvDisplay.setText(mobileNo);
    }
}