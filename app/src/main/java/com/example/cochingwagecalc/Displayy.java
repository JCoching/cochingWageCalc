package com.example.cochingwagecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


class Displayy extends AppCompatActivity {
    TextView disEmpName, disEmpType, disHours, disWage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayy);

        disEmpName = findViewById(R.id.displayName);
        disEmpType = findViewById(R.id.displayType);
        disHours = findViewById(R.id.displayHours);
        disWage = findViewById(R.id.displayWage);

        Intent i = getIntent();
        String eType = i.getStringExtra("type");
        String eName = i.getStringExtra("empName");
        Double eHours = Double.parseDouble(i.getStringExtra("hours"));

        disEmpName.setText("Employee Name: " + eName);
        disEmpType.setText("Employee Type:" + String.valueOf(eType));
        disHours.setText("Hours Rendered:" + String.valueOf(eHours));

        Double TotalWage = 0.0;

        if (eHours > 0.0) {

        } else {
            if (eType.equals("Full Time")) {
                TotalWage = eHours + 100;
                disWage.setText("Total Wage: " + String.valueOf(TotalWage));
            } else if (eType.equals("Part Time")) {
                TotalWage = eHours + 75;
                disWage.setText("Total Wage:" + String.valueOf(TotalWage));
            } else {
                TotalWage = eHours + 90;
                disWage.setText("Total Wage:" + String.valueOf(TotalWage));
            }
            if (eType.equals("Probationary")) {
                TotalWage = 720 + (100 * (eHours - 8.0));
                disWage.setText("Total Wage with Overtime: ₱" + String.valueOf(TotalWage));
            }

        }
    }
}