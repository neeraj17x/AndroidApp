package com.neeraj.helloandroid;

import android.annotation.SuppressLint;
//import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExpenseListActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expense_list);

        Button addExpensesButton = findViewById(R.id.addExpensesButton);
        addExpensesButton.setOnClickListener(v -> {
            //Intent intent = new Intent(ExpenseListActivity.this, MainActivity.class);
            //startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayExpenses();
    }

    private void displayExpenses() {
        TextView expenseListText = findViewById(R.id.expenseListText);
        StringBuilder expenseText = new StringBuilder();

        for (Expense expense : MainActivity.expenses) {
            expenseText.append("₹")
                    .append(expense.getAmount())
                    .append(" | ")
                    .append(expense.getDescription())
                    .append(" | ")
                    .append(expense.getPaymentType())
                    .append(" | ")
                    .append(expense.getDate())
                    .append("\n\n");
        }

        if (expenseText.length() == 0) {
            expenseListText.setText("No expenses added yet");
        } else {
            expenseListText.setText(expenseText.toString());
        }
    }
}