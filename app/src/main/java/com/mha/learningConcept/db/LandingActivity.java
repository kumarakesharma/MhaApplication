package com.mha.learningConcept.db;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivityLandingBinding;
import com.mha.learningConcept.databinding.LayoutAddBinding;
import com.mha.learningConcept.databinding.LayoutCustomToastBinding;
import com.mha.learningConcept.models.Information;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {
    private DbAdapter dbAdapter;
    private ActivityLandingBinding binding;
    private Context context;
    private Cursor cursor;
    private ListAdapter adapter;
    private List<Information> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        dbAdapter = new DbAdapter(this);
        dbAdapter.openDatabase();

        binding.btnAdd.setOnClickListener(this);

        showList();

    }

    @Override
    public void onClick(View view) {
        LayoutAddBinding bindingAdd = LayoutAddBinding.inflate(getLayoutInflater());
        Dialog dialog = new Dialog(LandingActivity.this);
        dialog.setContentView(bindingAdd.getRoot());
        dialog.setCancelable(false);
        dialog.show();

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

       bindingAdd.btnSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dbAdapter.insertData(context, bindingAdd.tvFname.getEditText().getText().toString(), bindingAdd.tvLname.getEditText().getText().toString(),
                       bindingAdd.tvMobNo.getEditText().getText().toString());
               dialog.dismiss();
               showList();

           }
       });

    }

    public List<Information> getDataFromDb(){
        cursor = dbAdapter.getData();
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            list = new ArrayList<>();
            do{
                Information information = new Information();
                information.setFirstName(cursor.getString(1));
                information.setLastName(cursor.getString(2));
                information.setMobileNo(cursor.getString(3));
                list.add(information);
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void showList(){
        adapter = new ListAdapter(context, getDataFromDb());
        binding.listView.setAdapter(adapter);
    }
}