package com.akmadheshiya.qui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class uid extends AppCompatActivity {
  TextView muid;
  Button mdel,mcancel;
  String uid,clas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uid);
        muid=findViewById(R.id.uid);
        uid=getIntent().getStringExtra("uid");
        String tickno=getIntent().getStringExtra("tickno");
        muid.setText("Ticket No "+tickno);
        clas=getIntent().getStringExtra("clas");
        mdel=findViewById(R.id.delTick);
        mcancel=findViewById(R.id.cancel);
        mdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             DatabaseReference ref=FirebaseDatabase.getInstance().getReference("Tickets").child(clas).child(uid);
             ref.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        Toast.makeText(uid.this, "Ticket is deleted", Toast.LENGTH_SHORT).show();
                        muid.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        mcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(uid.this,showing.class));
                finish();
            }
        });
    }
}