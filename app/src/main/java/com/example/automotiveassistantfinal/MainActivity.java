package com.example.automotiveassistantfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import Business.BusinessLogin;
import User.UserLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void CallUsLogin(View View)
    {
        Intent Ulogin = new Intent(this, UserLogin.class);
        startActivity(Ulogin);

    }
    public void CallBsLogin(View View)
    {
        Intent Blogin = new Intent(this, BusinessLogin.class);
        startActivity(Blogin);
    }
}