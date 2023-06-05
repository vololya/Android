package com.example.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.content.Context;
import androidx.annotation.Nullable;


public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        input1 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        input2 = (EditText) findViewById(R.id.editTextTextPassword);
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        if (sharedPreferences.getString("email","") != null) {
            //input1.setText(sharedPreferences.getString("email",""));
        }
        if (sharedPreferences.getString("password","") != null) {
            //input2.setText(sharedPreferences.getString("password",""));
        }

        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this,
                "OnCreate", Toast.LENGTH_SHORT).show();
        Log.i("AppLogger", "Вызван метод OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startNewActivity(View v){
        input1 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String name1 = input1.getText().toString();
        Intent intent = new Intent(this, DataListActivity.class);
        intent.putExtra("name", name1);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this,
                "OnStart", Toast.LENGTH_SHORT).show();
        Log.i("AppLogger", "Вызван метод OnStart");
        super.onStart();
    }

    @Override
    protected void onResume() {

        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this,
                "OnResume", Toast.LENGTH_SHORT).show();
        Log.i("AppLogger", "Вызван метод OnResume");
        super.onResume();

    }

    @Override
    protected void onPause() {
        input1 = (EditText) findViewById(R.id.editTextTextEmailAddress);
        String email = input1.getText().toString();

        input2 = (EditText) findViewById(R.id.editTextTextPassword);
        String password = input2.getText().toString();
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this,
                "OnPause", Toast.LENGTH_SHORT).show();
        Log.i("AppLogger", "Вызван метод OnPause");
        super.onPause();

    }

    @Override
    protected void onStop() {
        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this,
                "OnStop", Toast.LENGTH_SHORT).show();
        Log.i("AppLogger", "Вызван метод OnStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast mytoast = new Toast(this);
        Toast.makeText(MainActivity.this,
                "OnDestroy", Toast.LENGTH_SHORT).show();
        Log.i("AppLogger", "Вызван метод OnDestroy");
        super.onDestroy();
    }

}