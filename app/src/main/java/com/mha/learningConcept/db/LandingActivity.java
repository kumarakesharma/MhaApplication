package com.mha.learningConcept.db;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.mha.learningConcept.R;
import com.mha.learningConcept.databinding.ActivityLandingBinding;
import com.mha.learningConcept.databinding.LayoutAddBinding;
import com.mha.learningConcept.databinding.LayoutCustomToastBinding;
import com.mha.learningConcept.databinding.LayoutUpdateBinding;
import com.mha.learningConcept.models.Information;
import com.mha.learningConcept.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    private DbAdapter dbAdapter;
    private ActivityLandingBinding binding;
    private Context context;
    private Cursor cursor;
    private ListAdapter adapter;
    private List<Information> list;
    private int position;
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

        registerForContextMenu(binding.listView);
        binding.listView.setOnItemLongClickListener(this);

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_update_delete_option, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_update:
                LayoutUpdateBinding updateBinding = LayoutUpdateBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(context);
                dialog.setContentView(updateBinding.getRoot());
                dialog.setCancelable(false);
                dialog.show();

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

                cursor.moveToPosition(position);
                String rowId = cursor.getString(0);
                String fName = cursor.getString(1);
                String lName = cursor.getString(2);
                String mobNo = cursor.getString(3);

                updateBinding.tvFname.getEditText().setText(fName);
                updateBinding.tvLname.getEditText().setText(lName);
                updateBinding.tvMobNo.getEditText().setText(mobNo);

                updateBinding.btnUpdaste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dbAdapter.updateData(context, rowId, updateBinding.tvFname.getEditText().getText().toString(),
                                updateBinding.tvLname.getEditText().getText().toString(), updateBinding.tvMobNo.getEditText().getText().toString());

                        dialog.dismiss();
                        showList();

                    }
                });

                break;

            case R.id.item_delete:
                cursor.moveToPosition(position);
                String id = cursor.getString(0);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(false);
                builder.setMessage("Do you want to delete?");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbAdapter.deleteSingleRowData(context, id);
                        showList();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
        this.position = position;
        return false;
    }
}