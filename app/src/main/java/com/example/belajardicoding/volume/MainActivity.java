package com.example.belajardicoding.volume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.belajardicoding.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLength, edtWidth, edtHeight;
    private Button btnCalculate;
    private TextView tvResult;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_main);

        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        edtWidth = findViewById(R.id.edt_width);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate){
            String inputLength = edtLength.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields){
                double volume = Double.valueOf(inputLength) * Double.valueOf(inputHeight) * Double.valueOf(inputWidth);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }


}
