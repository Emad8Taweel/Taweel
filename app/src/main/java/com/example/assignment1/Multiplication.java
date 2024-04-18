package com.example.assignment1;

import static android.graphics.Color.rgb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class Multiplication extends AppCompatActivity {
    private EditText editText1 ,editText2 ;
    private TextView tx_1number1,tx_1number2 , tx_2number1,tx_2number2,tx_error1,tx_error2;
    private Button submit,back ;
    Spinner spinner1 ,spinner2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.multiplication);
        editText1 = findViewById(R.id.hed1);
        tx_1number1 = findViewById(R.id.tx_h1number1);
        tx_1number2 = findViewById(R.id.tx_h1number2);
        editText2 = findViewById(R.id.hed2);
        tx_2number1 = findViewById(R.id.tx_h2number1);
        tx_2number2 = findViewById(R.id.tx_h2number2);
        tx_error1 = findViewById(R.id.tx_error1);
        tx_error2 = findViewById(R.id.tx_error2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        back = findViewById(R.id.back);
        submit = findViewById(R.id.submit);


        int random1Number1 = ThreadLocalRandom.current().nextInt(20);
        tx_1number1.setText(random1Number1 + "");
        int random1Number2 = ThreadLocalRandom.current().nextInt(10);
        tx_1number2.setText(random1Number2 + "");
        int random2Number1 = ThreadLocalRandom.current().nextInt(20);
        tx_2number1.setText(random2Number1 + "");
        int random2Number2 = ThreadLocalRandom.current().nextInt(15);
        tx_2number2.setText(random2Number2 + "");

        int correctAnswer1 = random1Number1 * random1Number2;
        int rad11 = ThreadLocalRandom.current().nextInt(correctAnswer1);
        int rad12 = ThreadLocalRandom.current().nextInt(correctAnswer1);

        String str_rad11 = rad11 + "";
        String str_rad12 = rad12 + "";

        String str_answer1 = correctAnswer1 + "";


        String[] array = {str_rad11, str_rad12, str_answer1};
        List<String> list = Arrays.asList(array);


        Collections.shuffle(list);

        list.toArray(array);

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);


        int correctAnswer2 = random2Number1 * random2Number2;
        int rad21 = ThreadLocalRandom.current().nextInt(correctAnswer2);
        int rad22 = ThreadLocalRandom.current().nextInt(correctAnswer2);

        String str_rad21 = rad21 + "";
        String str_rad22 = rad22 + "";
        String str_answer2 = correctAnswer2 + "";


        String[] array2 = {str_rad21, str_answer2, str_rad22};
        List<String> list2 = Arrays.asList(array2);


        Collections.shuffle(list2);

        list2.toArray(array2);
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Multiplication.this, OperationSelectionActivity.class);
                startActivity(intent2);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    int userAnswer1 = Integer.parseInt(editText1.getText().toString());
                    int userAnswer2 = Integer.parseInt(editText2.getText().toString());

                    tx_error1.setText(userAnswer1 == correctAnswer1 ? "" : "The answer is wrong");
                    tx_error2.setText(userAnswer2 == correctAnswer2 ? "" : "The answer is wrong");

                    if (userAnswer1 == correctAnswer1 && userAnswer2 == correctAnswer2) {
                        tx_error1.setText("The answer is correct");
                        tx_error1.setTextColor(rgb(99, 162, 112));
                        tx_error2.setText("The answer is correct");
                        tx_error2.setTextColor(rgb(99, 162, 112));

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(Multiplication.this, Multiplication.class);
                                startActivity(intent);
                                finish();
                            }
                        }, 2000);
                    }
                } catch (Exception e) {
                    tx_error1.setText("The answer is wrong");
                    tx_error2.setText("The answer is wrong");
                }
            }
        });
    }
}