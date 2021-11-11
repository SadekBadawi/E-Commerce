package com.sadek.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sadek.myapplication.R;

public class ChoseLoginActivity extends AppCompatActivity {
    private TextView txtSignUpActivityChoseLogin , txtSignInActivityChoseLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_login);

        findViewByIdes();

        txtSignUpActivityChoseLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtSignInActivityChoseLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void findViewByIdes() {
        txtSignUpActivityChoseLogin = (TextView) findViewById(R.id.txtSignUpActivityChoseLogin);
        txtSignInActivityChoseLogin = (TextView) findViewById(R.id.txtSignInActivityChoseLogin);
    }
}