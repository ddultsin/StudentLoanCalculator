package com.example.studentloancalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        EditText loanAmount = (EditText) findViewById(R.id.loanAmount);
        EditText interestRate = (EditText) findViewById(R.id.interestRate);
        EditText loanTerm = (EditText) findViewById(R.id.loanTerm);
        EditText loanFees = (EditText) findViewById(R.id.loanFees);
        Button calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View result) {
                double loanAmountVal = (double) Integer.parseInt(loanAmount.getText().toString());
                double interestRateVal = (double) Integer.parseInt(interestRate.getText().toString());
                double loanTermVal = (double) Integer.parseInt(loanTerm.getText().toString());
                double loanFeesVal = (double) Integer.parseInt(loanFees.getText().toString());
                double totalPaid = (loanFeesVal + loanAmountVal) * Math.pow((1.0 + interestRateVal/100.0), loanTermVal);
                double monthlyPayment = Math.round((totalPaid / 12.0 / loanTermVal) * 100.0) / 100.0;
                double totalInterest = Math.round((totalPaid - loanAmountVal) * 100.0) / 100.0;
                //double sum = loanAmountVal + interestRateVal + loanTermVal + loanFeesVal;
                Toast.makeText(getApplicationContext(), "Monthly Payment: $" + String.valueOf(monthlyPayment) + "\n Total Interest: $" + String.valueOf(totalInterest), Toast.LENGTH_LONG).show();

            }
        });
    }
}