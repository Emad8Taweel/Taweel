package com.example.assignment1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MathematicsActivity extends AppCompatActivity {
    private EditText edName;
    private Button submit;
    private TextView txError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics);

        edName = findViewById(R.id.edname);
        submit = findViewById(R.id.submit);
        txError = findViewById(R.id.tx_error);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        edName.setText(name);

        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String enteredName = edName.getText().toString().trim();

                if (enteredName.length() < 3) {
                    txError.setText("Please enter your name (at least 3 characters).");
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", enteredName);
                    editor.apply();

                    Intent intent = new Intent(MathematicsActivity.this, OperationSelectionActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }
}
