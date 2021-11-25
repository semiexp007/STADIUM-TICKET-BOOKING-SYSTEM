package com.akmadheshiya.qui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ChooseLoginRegistrationActivity extends AppCompatActivity {
    private Button mLogin,mregister;

 FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login_registration);

        mLogin=findViewById(R.id.signin);
        mregister=findViewById(R.id.signup);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseLoginRegistrationActivity.this,showing.class));


            }
        });
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseLoginRegistrationActivity.this,RegistrationActivity.class));

            }
        });
    }
}