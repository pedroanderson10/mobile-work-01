package com.example.trabalho_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void entrarSistema(View view) {
        Intent intent1 = new Intent(getApplicationContext(), ListaTarefas.class);
        startActivity(intent1);
    }


}