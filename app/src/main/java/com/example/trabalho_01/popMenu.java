package com.example.trabalho_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.PopupMenu;

public class popMenu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_menu);
    }

    public void showPopup(View view){
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu);
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
                return true;
             // ...
             // ...
            default:
                return false;
        }
    }

    //Pop-up Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //Pop-up Menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.voltar:
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.item1:
                Intent intent2 = new Intent(getApplicationContext(), ListaTarefas.class);
                startActivity(intent2);
                return true;
            case R.id.item2:
                Intent intent3 = new Intent(getApplicationContext(), toggleButton.class);
                startActivity(intent3);
                return true;
            case R.id.item3:
                Intent intent4 = new Intent(getApplicationContext(), CliqueLongo.class);
                startActivity(intent4);
                return true;
            case R.id.item4:
                Intent intent5 = new Intent(getApplicationContext(), TextSpinner.class);
                startActivity(intent5);
                return true;
            case R.id.item5:
                Intent intent6 = new Intent(getApplicationContext(), Tabbed.class);
                startActivity(intent6);
                return true;
            case R.id.item6:
                Intent intent7 = new Intent(getApplicationContext(), PlayMusic.class);
                startActivity(intent7);
                return true;
            case R.id.item7:
                Intent intent8 = new Intent(getApplicationContext(), grid.class);
                startActivity(intent8);
                return true;
            case R.id.item8:
                Intent intent9 = new Intent(getApplicationContext(), popMenu.class);
                startActivity(intent9);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}