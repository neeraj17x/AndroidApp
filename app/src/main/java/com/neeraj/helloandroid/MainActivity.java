package com.neeraj.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final List<Expense> expenses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Adding control values
        Spinner paymentTypeSpinner = findViewById(R.id.paymentTypeSpinner);

        String[] paymentTypes = {"UPI", "Credit Card", "Cash"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paymentTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentTypeSpinner.setAdapter(adapter);

        // Set Date fields
        EditText dateInput = findViewById(R.id.dateInput);
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dateInput.setText(today.format(formatter));

        EditText amountInput = findViewById(R.id.amountInput);
        EditText descriptionInput = findViewById(R.id.descriptionInput);
        Button addExpenseButton = findViewById(R.id.addExpenseButton);

        addExpenseButton.setOnClickListener(v -> {
            String amount = amountInput.getText().toString();
            String description = descriptionInput.getText().toString();
            String paymentType = paymentTypeSpinner.getSelectedItem().toString();
            String date = dateInput.getText().toString();
            //String message = "₹" + amount + " | " + description + " | " + paymentType + " | " + date;
            //Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            double expenseAmount = Double.parseDouble(amount);
            Expense expense = new Expense(expenseAmount, description, paymentType, date);
            expenses.add(expense);
            Toast.makeText(this, "Expense added!", Toast.LENGTH_SHORT).show();
        });

        Button viewExpensesButton = findViewById(R.id.viewExpensesButton);
        viewExpensesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExpenseListActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}