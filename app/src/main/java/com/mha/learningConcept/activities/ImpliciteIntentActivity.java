package com.mha.learningConcept.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mha.learningConcept.Keys.Keys;
import com.mha.learningConcept.R;

public class ImpliciteIntentActivity extends AppCompatActivity {

    EditText etInput;
    Button btnSubmit, btnImpliciteIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicite_intent);

        etInput = findViewById(R.id.et_input);
        btnSubmit = findViewById(R.id.btn_submit);
        btnImpliciteIntent = findViewById(R.id.btn_implicit_intent);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO : share data using Intent

                Intent intent = new Intent(ImpliciteIntentActivity.this, SecondActivity.class);
//                intent.putExtra(Keys.KEY_MOBILE, etInput.getText().toString());
//                startActivity(intent);

                //TODO : share data through Bundle
                Bundle bundle = new Bundle();
                bundle.putString(Keys.KEY_MOBILE, etInput.getText().toString());
                intent.putExtra(Keys.KEY_BUNDLE, bundle);
                startActivity(intent);


            }
        });

        btnImpliciteIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/reference/android/content/Intent"));
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9162769252"));
//                startActivity(intent);


                if (ContextCompat.checkSelfPermission(ImpliciteIntentActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9625033237"));
                    startActivity(intent);
                }else {
                    ActivityCompat.requestPermissions(ImpliciteIntentActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9625033237"));
                startActivity(intent);
            }else {
                Toast.makeText(this, "Please allow permission", Toast.LENGTH_SHORT).show();
            }
        }

    }
}