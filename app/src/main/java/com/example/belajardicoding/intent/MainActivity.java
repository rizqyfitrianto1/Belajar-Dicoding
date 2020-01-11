package com.example.belajardicoding.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.belajardicoding.R;
import com.example.belajardicoding.intent.model.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_main);

        Button btnMove = findViewById(R.id.btn_move);
        btnMove.setOnClickListener(this);

        Button btnMoveData = findViewById(R.id.btn_move_data);
        btnMoveData.setOnClickListener(this);

        Button btnMoveObject = findViewById(R.id.btn_move_activity_object);
        btnMoveObject.setOnClickListener(this);

        Button btnDial = findViewById(R.id.btn_dial_number);
        btnDial.setOnClickListener(this);

        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move:
                Intent intent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_move_data:
                Intent intentData = new Intent(MainActivity.this, MoveDataActivity.class);
                intentData.putExtra(MoveDataActivity.EXTRA_NAME, "Rizqy");
                intentData.putExtra(MoveDataActivity.EXTRA_AGE, 24);
                startActivity(intentData);
                break;

            case R.id.btn_move_activity_object:
                Person person = new Person();
                person.setName("Rizqy F");
                person.setEmail("rizqy@gmail.com");
                person.setAge(24);
                person.setCity("Jakarta");

                Intent intentObject = new Intent(MainActivity.this, MoveObjectActivity.class);
                intentObject.putExtra(MoveObjectActivity.EXTRA_PERSON, person);
                startActivity(intentObject);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "083838708870";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhone);
                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
