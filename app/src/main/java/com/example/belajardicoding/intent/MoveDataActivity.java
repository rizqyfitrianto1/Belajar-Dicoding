package com.example.belajardicoding.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.belajardicoding.R;

public class MoveDataActivity extends AppCompatActivity {

    public  static  final String EXTRA_NAME = "extra_name";
    public  static  final String EXTRA_AGE = "extra_age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_move_data);

        TextView tvDataReeived = findViewById(R.id.tv_data_received);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);

        String text = "Name : " + name + ", Your Age : " + age;
        tvDataReeived.setText(text);

    }
}
