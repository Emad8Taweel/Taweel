package com.example.assignment1;

import static android.graphics.Color.rgb;

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

public class Subtract extends AppCompatActivity {

    private EditText editText, editText2;
    private TextView tx_number1, tx_number2, tx_2number1, tx_2number2, tx_error1, tx_error2;
    private Button submit, back;
    private Spinner spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.subtract);

        editText = findViewById(R.id.ed1);
        tx_number1 = findViewById(R.id.tx_number1);
        tx_number2 = findViewById(R.id.tx_number2);
        editText2 = findViewById(R.id.ed2);
        tx_2number1 = findViewById(R.id.tx_2number1);
        tx_2number2 = findViewById(R.id.tx_2number2);
        tx_error1 = findViewById(R.id.tx_error1);
        tx_error2 = findViewById(R.id.tx_error2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        submit = findViewById(R.id.submit);
        back = findViewById(R.id.back);

        int randomNumber1 = ThreadLocalRandom.current().nextInt(20);
        int randomNumber2 = ThreadLocalRandom.current().nextInt(randomNumber1);
        int randomNumber5 = ThreadLocalRandom.current().nextInt(20);
        int randomNumber6 = ThreadLocalRandom.current().nextInt(randomNumber5);


        tx_number1.setText(String.valueOf(randomNumber1));
        tx_number2.setText(String.valueOf(randomNumber2));
        tx_2number1.setText(String.valueOf(randomNumber5));
        tx_2number2.setText(String.valueOf(randomNumber6));

        int correctAnswer1 = randomNumber1 - randomNumber2;
        int rad11 =  ThreadLocalRandom.current().nextInt(correctAnswer1);
        int rad12 =  ThreadLocalRandom.current().nextInt(correctAnswer1);

        String str_rad11 = rad11 + "";
        String str_rad12 = rad12 + "";
        String str_answer1 = correctAnswer1 + "";
        String[] array = {str_rad11, str_rad12, str_answer1};
        List<String> list = Arrays.asList(array);
        Collections.shuffle(list);
        list.toArray(array);
        Collections.shuffle(Collections.singletonList(array));
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, array);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        int correctAnswer2 = randomNumber5 - randomNumber6;
        int rad21 =  ThreadLocalRandom.current().nextInt(correctAnswer2);
        int rad22 =  ThreadLocalRandom.current().nextInt(correctAnswer2);

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
                Intent intent = new Intent(Subtract.this, OperationSelectionActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int userAnswer1 = Integer.parseInt(editText.getText().toString());
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
                                Intent intent = new Intent(Subtract.this, Subtract.class);
                                startActivity(intent);
                                finish();
                            }
                        }, 2000);
                    }
                } catch (Exception e) {
                    tx_error1.setText("Invalid input");
                    tx_error2.setText("Invalid input");
                }
            }
        });
    }
}
