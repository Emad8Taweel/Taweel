package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class OperationSelectionActivity extends AppCompatActivity {

    ListView listView;
    String[] itemList = {"Addition", "Multiplication","Subtract"};
    int[] itemIcons = {R.drawable.convenient, R.drawable.convenient,R.drawable.convenient};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.operation_selection);

        listView = findViewById(R.id.listv);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), itemList, itemIcons);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemList[position];
                Intent intent = null;
                switch (selectedItem) {
                    case "Addition":
                        intent = new Intent(OperationSelectionActivity.this, Addition.class);
                        break;
//
                    case "Multiplication":
                        intent = new Intent(OperationSelectionActivity.this, Multiplication.class);
                        break;
                    case "Subtract":
                        intent = new Intent(OperationSelectionActivity.this, Subtract.class);
                        break;

                    default:
                        Log.e("LevelSelectionActivity", "Unexpected item selected: " + selectedItem);
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }


}