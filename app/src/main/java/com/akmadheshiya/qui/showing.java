package com.akmadheshiya.qui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class showing extends AppCompatActivity {
 RecyclerView mr1,mr2;
 Button mvip,mgen;
 adapterVip adapter1;
 adapterGen adapter2;
 List<ticket>mlist1;
 List<ticket>mlist2;
 String Cat;
    AppCompatAutoCompleteTextView search_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing);
        mgen=findViewById(R.id.butnr2);
        mvip=findViewById(R.id.butnr1);
        mr1=findViewById(R.id.r1);
        mr2=findViewById(R.id.r2);
        search_bar=findViewById(R.id.search_bar);
        mlist1=new ArrayList<>();
        mlist2=new ArrayList<>();
        adapter1=new adapterVip(showing.this,mlist1);
        adapter2=new adapterGen(showing.this,mlist2);

        mr1.setLayoutManager(new LinearLayoutManager(showing.this));
        mr1.setAdapter(adapter1);
        mr2.setLayoutManager(new LinearLayoutManager(showing.this));
        mr2.setAdapter(adapter2);

        mvip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mr1.setVisibility(View.VISIBLE);
                mr2.setVisibility(View.INVISIBLE);
                Cat="VIP";
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Tickets").child("VIP");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        if (snapshot.exists())
                        {
                            mlist1.clear();
                            for (DataSnapshot snapshot1:snapshot.getChildren()){
                                String name=snapshot1.child("name").getValue().toString();
                                String uid=snapshot1.getKey();
                                String tick=snapshot1.child("ticket no").getValue().toString();
                                String seatno=snapshot1.child("seat no").getValue().toString();
                                ticket tk=new ticket(uid,name,tick,seatno,"VIP");
                                mlist1.add(tk);
                            }
                            adapter1.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
            }
        });
        mgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Cat="GENERAL";
                DatabaseReference reference2= FirebaseDatabase.getInstance().getReference().child("Tickets").child("GENERAL");
                reference2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        if (snapshot.exists())
                        {
                            mlist1.clear();
                            for (DataSnapshot snapshot1:snapshot.getChildren()){
                                String name=snapshot1.child("name").getValue().toString();
                                String uid=snapshot1.getKey();
                                String tick=snapshot1.child("ticket no").getValue().toString();
                                String seatno=snapshot1.child("seat no").getValue().toString();
                                ticket tk1=new ticket(uid,name,tick,seatno,"GENERAL");
                                mlist1.add(tk1);
                            }
                            adapter1.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
            }
        });

        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString(),Cat);
            }
        });


    }

    private void filter(String s,String cat) {
        Query reference=FirebaseDatabase.getInstance().getReference().child("Tickets").child(cat);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
               mlist1.clear();
                for(DataSnapshot snap:snapshot.getChildren())
                {
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        String name=snapshot1.child("name").getValue().toString();
                        String uid=snapshot1.getKey();
                        String tick=snapshot1.child("ticket no").getValue().toString();
                        String seatno=snapshot1.child("seat no").getValue().toString();
                        ticket tk1=new ticket(uid,name,tick,seatno,"GENERAL");
                        if(tick.equals(s))
                        {
                            mlist1.add(tk1);
                        }

                    }


                }
                adapter1.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }
}