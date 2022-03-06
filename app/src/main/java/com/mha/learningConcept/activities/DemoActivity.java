package com.mha.learningConcept.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mha.learningConcept.R;

public class DemoActivity extends AppCompatActivity /*implements View.OnClickListener */{
    private String TAG = "_tag";
    private Button btnSubmit, btnClick, btnHit;
//    private Button btnClick;
//    private Button btnHit;
    private EditText etInput;
    private TextView textDisplay;
    private RadioGroup rbGroup;
    private CheckBox cbJava, cbAndroid, cbKotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Log.d(TAG, "onCreate()");


        btnSubmit = findViewById(R.id.btn_submit);
//        btnClick = findViewById(R.id.btn_click);
//        btnHit = findViewById(R.id.btn_hit);
        etInput = findViewById(R.id.et_input);
        textDisplay = findViewById(R.id.tv_display);
        rbGroup = findViewById(R.id.rb_group);
        cbJava = findViewById(R.id.cb_java);
        cbAndroid = findViewById(R.id.cb_android);
        cbKotlin = findViewById(R.id.cb_kotlin);


        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int chekedItem) {
                RadioButton radioButton = findViewById(chekedItem);
                Toast.makeText(DemoActivity.this, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        cbJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(DemoActivity.this, cbJava.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(DemoActivity.this, cbAndroid.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        cbKotlin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(DemoActivity.this, cbKotlin.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(DemoActivity.this, "You clicked Submit Button", Toast.LENGTH_LONG).show();
//                Toast.makeText(DemoActivity.this, etInput.getText().toString(), Toast.LENGTH_SHORT).show();
//                textDisplay.setText(etInput.getText().toString());
            }
        });

//        btnClick.setOnClickListener(this);

//        btnHit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(DemoActivity.this, "You clicked Hit button", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

//    @Override
//    public void onClick(View view) {
//        Toast.makeText(this, "You clicked click button", Toast.LENGTH_SHORT).show();
//    }
}