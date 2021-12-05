package com.akmadheshiya.qui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class WelcomePage extends AppCompatActivity {

    LinearLayout mlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        mlay=findViewById(R.id.splash);
        final int splashTimeOut = 200;

        Thread splashThread = new Thread(){
            int wait = 0;
            @Override
            public void run() {
                try {
                    super.run();
                    while(wait < splashTimeOut){
                        sleep(200);
                        wait += 20;
                    }
                } catch (Exception e) {
                }finally{

                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    Intent intent =new Intent(WelcomePage.this,ChooseLoginRegistrationActivity.class);

                    startActivity(intent);
                    finish();
                }
            }
        };
        splashThread.start();

    }
}