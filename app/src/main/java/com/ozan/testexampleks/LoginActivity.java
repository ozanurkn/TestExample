package com.ozan.testexampleks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ozan.testexampleks.helper.UserInfoUtil;

public class LoginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button login;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initLogin();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                manageLogin(userName.getText().toString(), password.getText().toString());
            }
        });
    }

    private void initLogin() {
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.passwordEdit);
        login = findViewById(R.id.loginButton);
        imageView = findViewById(R.id.errorImageView);
    }

    public void manageLogin(String username,String password){
        if ((TextUtils.isEmpty(username) || TextUtils.isEmpty(password)))
        {
            showErrorIcon();
        }
        else
        {
            if (username.equals(UserInfoUtil.EXAMPLE_USER_NAME) && password.equals(UserInfoUtil.EXAMPLE_USER_PASSWORD))
            {
                loginSuccess();
            }
            else
            {
                loginFail();
            }
        }
    }

    public void loginSuccess(){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    public void loginFail(){
        Toast.makeText(this, "HATALI GİRİŞ", Toast.LENGTH_SHORT).show();
    }

    public void showErrorIcon(){
        imageView.setVisibility(View.VISIBLE);
    }
}
