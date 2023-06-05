package com.example.lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HelloActivity extends Activity {
    public int button1_clicked = 0;
    public int button2_clicked = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloact);
        TextView textview1 = findViewById(R.id.TextView1);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        textview1.setText(button1_clicked + "   " + button2_clicked);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1_clicked++;
                textview1.setText(button1_clicked + "   " + button2_clicked);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2_clicked++;
                textview1.setText(button1_clicked + "   " + button2_clicked);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1_clicked = 0;
                button2_clicked = 0;
                textview1.setText(button1_clicked + "   " + button2_clicked);
            }
        });

    }

}
