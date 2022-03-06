package com.mha.learningConcept.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.mha.learningConcept.R;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button button, btnPopupMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button = findViewById(R.id.btn_context_memu);
        btnPopupMenu = findViewById(R.id.btn_popup_memu);

        registerForContextMenu(button);
        btnPopupMenu.setOnClickListener(this);
    }

    // TODO : Options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // TODO : event on options dmenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_4:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //TODO : Contextual menu


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.option_menu_item, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_4:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        //TODO : Popup menu work
        PopupMenu popupMenu = new PopupMenu(MenuActivity.this, view);
        popupMenu.getMenuInflater().inflate(R.menu.option_menu_item,popupMenu.getMenu());
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_1:
                        Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.item_2:
                        Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.item_3:
                        Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.item_4:
                        Toast.makeText(MenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}