package com.example.drive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class ErrorActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        initView();
        Intent intent = getIntent();
        String position = intent.getStringExtra("position");
//        Toast.makeText(this, position, Toast.LENGTH_SHORT).show();
        tv.setText(position);
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }
}
