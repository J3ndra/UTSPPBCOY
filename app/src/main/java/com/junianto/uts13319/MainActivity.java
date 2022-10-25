package com.junianto.uts13319;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRv = findViewById(R.id.btn_rv);

        btnRv.setOnClickListener(v -> {
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        });
    }
}