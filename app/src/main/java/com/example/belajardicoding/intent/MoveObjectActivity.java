package com.example.belajardicoding.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.belajardicoding.R;
import com.example.belajardicoding.intent.model.Person;

public class MoveObjectActivity extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_move_object);

        TextView tvObject = findViewById(R.id.tv_object_received);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + person.getName() + "\nEmail : " + person.getEmail() + "\nAge : " + person.getAge() + "\nCity : " + person.getCity() ;
        tvObject.setText(text);
    }
}
