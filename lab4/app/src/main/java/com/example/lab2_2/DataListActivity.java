package com.example.lab2_2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import android.content.Context;


public class DataListActivity extends AppCompatActivity {

    EditText input;
    ListView list;
    int last_pos = 0;
    ArrayAdapter<String> adapter;
    SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("name").toString();
        setContentView(R.layout.activity_data_list);
        input = (EditText) findViewById(R.id.editTextTextPersonName2);
        list = (ListView) findViewById(R.id.listview1);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        list.setAdapter(adapter);

        // Инициализация SharedPreferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        // Загрузка сохраненных данных из SharedPreferences
        Set<String> savedData = sharedPreferences.getStringSet("dataList", null);
        if (savedData != null) {
            adapter.addAll(savedData);
            adapter.notifyDataSetChanged();
        }

        adapter.add(name);
        adapter.notifyDataSetChanged();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                last_pos = position;

            } });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Set<String> strings_to_save = new HashSet<String>();
        for (int i = 0; i < adapter.getCount(); i++) {
            String item = (String) adapter.getItem(i);
            strings_to_save.add(item);
        }
        // Сохранение данных из ListView в SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("dataList", strings_to_save);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Загрузка сохраненных данных из SharedPreferences
        Set<String> savedData = sharedPreferences.getStringSet("dataList", null);
        if (savedData != null) {
            adapter.clear();
            adapter.addAll(savedData);
            adapter.notifyDataSetChanged();
        }
    }

    public void addToList(View view) {
        int length = adapter.getCount();
        String str1 = input.getText().toString();
        for (int i = 0; i < length; i++) {
             if (str1.equals(adapter.getItem(i))) {
                 return;
             }
        }
        adapter.add(str1);
        adapter.notifyDataSetChanged();
        input.setText("");
        last_pos = adapter.getCount()-1;
    }

    public void deleteFromList(View view) {
        if (last_pos >= 0 && adapter.getCount() > 0) {
        adapter.remove(adapter.getItem(last_pos));
        adapter.notifyDataSetChanged();
        last_pos = adapter.getCount()-1;
        }
    }
}