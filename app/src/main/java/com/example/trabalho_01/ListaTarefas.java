package com.example.trabalho_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaTarefas extends AppCompatActivity {

    //Auto Complete
    AutoCompleteTextView autoCompleteTextView;
    String[] listaTarefas;

    //Lista de Tarefas
    private ArrayList<String> itensTarefas;
    private ArrayAdapter<String> itensAdapter;
    private ListView listView;
    private Button button;

    //Radio Group
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefas);

        //Radio Group
        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);

        Button buttonApply = findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                textView.setText("Sua escolha: " + radioButton.getText());
            }
        });

        //Auto Complete
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.textTarefas);
        listaTarefas = getResources().getStringArray(R.array.tarefas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaTarefas);
        autoCompleteTextView.setAdapter(adapter);

        //Lista de Tarefas
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                addItem(view);
            }
        });

        itensTarefas = new ArrayList<>();
        itensAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itensTarefas);
        listView.setAdapter(itensAdapter);
        setUpListViewListener();

    }

    // Radio Group
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Radio Button" + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    //Lista de Tarefas
    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){
                Context context = getApplicationContext();
                Toast.makeText(context, "item Removed", Toast.LENGTH_LONG).show();

                itensAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    //Lista de Tarefas
    private void addItem(View view) {
        EditText input = findViewById(R.id.textTarefas);
        String itemText = input.getText().toString();

        if(!(itemText.equals(""))){
            itensAdapter.add(itemText);
            input.setText("");
        }else{
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
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