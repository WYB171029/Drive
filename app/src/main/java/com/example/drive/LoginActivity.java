package com.example.drive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_psw, et_user_name;
    private TextView tv_quick_register;
    private Button btn_login;
    private DBUtils dbUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbUtils = DBUtils.getInstance(getApplicationContext());
        initView();
    }

    private void initView() {
        et_user_name = findViewById(R.id.et_user_name);
        et_psw = findViewById(R.id.et_psw);
        tv_quick_register = findViewById(R.id.tv_quick_register);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        tv_quick_register.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_quick_register:
                Intent intent=new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                String userName=et_user_name.getText().toString().trim();
                String psw=et_psw.getText().toString().trim();
                if (TextUtils.isEmpty(userName)){
                    Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;

                }else if (TextUtils.isEmpty(psw)){
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;

                } else if (dbUtils.userLogin(userName,psw)){
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent data=new Intent();
                    data.putExtra("loginUserName",userName);
                    setResult(RESULT_OK,data);
                    finish();
                }
                break;
        }
    }
}






