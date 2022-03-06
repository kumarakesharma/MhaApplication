package com.mha.learningConcept.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivityDataPickerBinding;

import java.util.Calendar;

public class DataPickerActivity extends AppCompatActivity {
    ActivityDataPickerBinding binding;
    private Calendar calendar;
    int DAY, MONTH, YEAR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataPickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        calendar = Calendar.getInstance();

        DAY = calendar.get(Calendar.DAY_OF_MONTH); // TODAY DATE
        MONTH = calendar.get(Calendar.MONTH); // CURRENT MONTH
        YEAR = calendar.get(Calendar.YEAR); // CURRENT YEAR

        binding.btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                binding.tvDisplay.setText(DAY+"/"+(MONTH + 1)+"/"+YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(DataPickerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        binding.tvDisplay.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                    }
                }, YEAR, MONTH, DAY);
                datePickerDialog.show();
            }
        });
    }
}