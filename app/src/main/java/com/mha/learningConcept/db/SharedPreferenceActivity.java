package com.mha.learningConcept.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.mha.learningConcept.Keys.Keys;
import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivitySharedPreferenceBinding;

import java.security.Key;

public class SharedPreferenceActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySharedPreferenceBinding binding;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySharedPreferenceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getSharedPreferences("mha_prefs", MODE_PRIVATE);
        editor = preferences.edit();

        binding.btnSubmit.setOnClickListener(this);
        binding.btnClear.setOnClickListener(this);

        binding.tvResult.setText(preferences.getString(Keys.FIRST_NAME, "")+" "+preferences.getString(Keys.LAST_NAME, ""));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
            editor.putString(Keys.FIRST_NAME, binding.tvFname.getEditText().getText().toString());
            editor.putString(Keys.LAST_NAME, binding.tvLname.getEditText().getText().toString());
            editor.putString(Keys.PHONE_NUMBER, binding.tvPhone.getEditText().getText().toString());
            editor.commit();

            break;
            case R.id.btn_clear:
                editor.clear();
                editor.commit();
                binding.tvResult.setText("");

                break;
        }
    }
}