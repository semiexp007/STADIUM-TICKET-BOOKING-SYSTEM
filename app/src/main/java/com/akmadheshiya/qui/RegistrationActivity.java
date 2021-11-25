package com.akmadheshiya.qui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {


      Button mregistration;
      EditText memail,mname,mpassword,mseat;
      FirebaseAuth auth;
      RadioGroup mRadiogroup;
    //FirebaseAuth.AuthStateListener firebaseAuthStaticListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        auth=FirebaseAuth.getInstance();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mseat=findViewById(R.id.seatno);
        memail=findViewById(R.id.email);
        mname=findViewById(R.id.name);
        mpassword=findViewById(R.id.passward);
        mregistration=findViewById(R.id.register);
        mRadiogroup=findViewById(R.id.rg);

        mregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email= memail.getText().toString();
                String name=mname.getText().toString();
                String password=mpassword.getText().toString();
                String seatno=mseat.getText().toString();
                int selectedid= mRadiogroup.getCheckedRadioButtonId();
              RadioButton radioButton=findViewById(selectedid);
              String cat=radioButton.getText().toString();

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(!task.isSuccessful()){

                            Toast.makeText(RegistrationActivity.this,"Booking  failed",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                             String userId=auth.getCurrentUser().getUid();
                            DatabaseReference currentuserDb= FirebaseDatabase.getInstance().getReference().child("Tickets").child(cat).child(userId);

                            Map userinfo=new HashMap();
                            userinfo.put("name",name);
                            userinfo.put("ticket no",password);
                            userinfo.put("seat no",seatno);
                            currentuserDb.updateChildren(userinfo);
                            Toast.makeText(RegistrationActivity.this,"Ticket is booked ",Toast.LENGTH_SHORT).show();
                            mname.setText("");
                            mpassword.setText("");
                            memail.setText("");
                            mseat.setText("");


                        }

                    }
                });

            }
        });
    }


}