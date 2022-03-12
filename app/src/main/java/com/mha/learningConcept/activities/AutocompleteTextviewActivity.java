package com.mha.learningConcept.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivityAutocompleteTextviewBinding;
import com.mha.learningConcept.util.Utility;

public class AutocompleteTextviewActivity extends BaseActivity {
    private ActivityAutocompleteTextviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAutocompleteTextviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AutocompleteTextviewActivity.this, android.R.layout.simple_list_item_1, countries);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(AutocompleteTextviewActivity.this, android.R.layout.simple_list_item_1, monthsName);
        binding.tvAutoComplete.setAdapter(arrayAdapter);

        binding.tvMultiAutoComplete.setAdapter(arrayAdapter2);
        binding.tvMultiAutoComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Utility.showShortToast(AutocompleteTextviewActivity.this, binding.tvAutoComplete.getText().toString());
                showCustomToast(binding.tvAutoComplete.getText().toString());
                showShortToast(binding.tvAutoComplete.getText().toString());
            }
        });

        binding.tvAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                showCustomToast(adapterView.getItemAtPosition(position).toString());
            }
        });

        binding.tvMultiAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                showShortToast(binding.tvMultiAutoComplete.getText().toString());
                showCustomToast(adapterView.getItemAtPosition(position).toString());
            }
        });






    }
}