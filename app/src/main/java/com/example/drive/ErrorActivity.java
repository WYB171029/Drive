package com.example.drive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ErrorActivity extends AppCompatActivity {

    private TextView tv;
    private ImageButton ib_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        initView();
        Intent intent = getIntent();
        String position = intent.getStringExtra("position");
//        Toast.makeText(this, position, Toast.LENGTH_SHORT).show();
        tv.setText(position);
        ib_back=findViewById(R.id.ib_back);
        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplication(),MainActivity.class);

                finish();
            }
        });
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }
}
