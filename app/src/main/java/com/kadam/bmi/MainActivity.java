package com.kadam.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        EditText editweight ,editheightft ,editheightinch;
        TextView result;
        Button clbtn;
        LinearLayout main;

        editweight = findViewById(R.id.editweight);
        editheightft =findViewById(R.id.editheightft);
        editheightinch =findViewById(R.id.editheightinch);
        clbtn =findViewById(R.id.clbtn);
        result =findViewById(R.id.result);
        main =findViewById(R.id.main);


        clbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt= Integer.parseInt( editweight.getText().toString());
                int ft=Integer.parseInt(editheightft.getText().toString());
                int inch=Integer.parseInt(editheightinch.getText().toString());

                int totalIn=ft*12 + inch;
                double toatlCm =totalIn*2.53;
                double totalM=toatlCm/100;
                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    result.setText("You are Overweight");
                    main.setBackgroundColor(getResources().getColor(R.color.colorow));
                } else if (bmi<18) {
                    result.setText("You are under weight");
                    main.setBackgroundColor(getResources().getColor(R.color.coloruw));
                } else {
                    result.setText("You are healthy");
                    main.setBackgroundColor(getResources().getColor(R.color.colornr));
                }

            }
        });

    }
}