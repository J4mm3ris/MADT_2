package com.custom.madt_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;





public class MainActivity extends AppCompatActivity {
    public static int count(int pos, String input){
        if(input.isEmpty()) {
            return -1;
        }
        else{
            int count;
            if(pos == 0){
                count = input.split("[.!?]").length;

            }else if(pos == 1){
                count = input.split("[\\s]").length;

            }else if(pos == 2){
                count = input.length();

            }else{
                count = input.split("\\d", -1).length-1;
            }

            return count;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner spinner = findViewById(R.id.spn1);
        EditText text = findViewById(R.id.txt1);
        Button btn = findViewById(R.id.btn1);
        TextView tv = findViewById(R.id.tv1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spn1_choices,
                android.R.layout.simple_spinner_item
        );
        spinner.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String enteredText = text.getText().toString();
                int pos = spinner.getSelectedItemPosition();

                int result=count(pos, enteredText);

                if(result!=-1){
                    tv.setText("The count is "+ result);
                }
                else{
                    Toast.makeText(MainActivity.this, "Input field is empty", Toast.LENGTH_SHORT).show();
                    tv.setText("ErRoR");
                }
            }
        });
    }
}