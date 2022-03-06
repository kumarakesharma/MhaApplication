package com.mha.learningConcept.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivityDialogBinding;
import com.mha.learningConcept.databinding.CustomDialogBinding;

public class DialogActivity extends AppCompatActivity {

    private ActivityDialogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                builder.setTitle(R.string.app_name);
                builder.setMessage("Do you want to exit?");
                builder.setIcon(R.drawable.ic_report);
                builder.setCancelable(false);
                builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Toast.makeText(DialogActivity.this, "Pressed exit button", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = builder.create();
//                builder.show();
                alertDialog.show();
                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setAllCaps(false);
                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.RED);
            }
        });

//        binding.btnCustomDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CustomDialogBinding customDialogBinding = CustomDialogBinding.inflate(getLayoutInflater());
//                Dialog dialog = new Dialog(DialogActivity.this);
//                dialog.setContentView(customDialogBinding.getRoot());
//                dialog.setCancelable(false);
//                dialog.show();
//
//                Window window = dialog.getWindow();
//                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//
//                customDialogBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(DialogActivity.this, customDialogBinding.etFname.getText().toString(), Toast.LENGTH_SHORT).show();
//                        binding.tvDisplay.setText(customDialogBinding.etFname.getText().toString());
//                        dialog.cancel();
//                    }
//                });
//            }
//        });

    }
}