package com.neeraj.helloandroid;

import android.os.Bundle;
import android.widget.Button;
//import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExpenseListActivity extends AppCompatActivity {

    private ExpenseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expense_list);

        RecyclerView expenseRecyclerView = findViewById(R.id.expenseRecyclerView);

        expenseRecyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        adapter = new ExpenseAdapter(MainActivity.expenses);
        //Toast.makeText(this, "Expenses: " + MainActivity.expenses.size(), Toast.LENGTH_LONG).show();

        expenseRecyclerView.setAdapter(adapter);

        Button addExpensesButton = findViewById(R.id.addExpensesButton);

        addExpensesButton.setOnClickListener(v -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );
                    return insets;
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}