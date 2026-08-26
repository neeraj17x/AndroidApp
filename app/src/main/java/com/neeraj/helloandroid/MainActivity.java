package com.neeraj.helloandroid;

import android.os.Bundle;
import android.widget.Button;
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
        // Adding button functionality
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.textView);
            String text = String.valueOf(textView.getText()).replace("!", "");
            textView.setText(String.format("%s again!", text));
        });

        // Adding clear button
        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(v -> {
            TextView textView = findViewById(R.id.textView);
            textView.setText("welcome Neeraj");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}