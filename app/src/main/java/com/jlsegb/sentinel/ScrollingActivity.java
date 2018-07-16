package com.jlsegb.sentinel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;



public class ScrollingActivity extends AppCompatActivity {

    DatabaseReference databaseProfiles;
    Profile p;
    ArrayList<Profile> profileList;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        databaseProfiles = FirebaseDatabase.getInstance().getReference("profiles");

        display(i);

    }



    @Override
    protected void onStart() {
        super.onStart();

        profileList.clear();

        databaseProfiles.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot profileSnapshot : dataSnapshot.getChildren()) {

                    //String sProfile = new String();
                    //this gets the object back and adds it to a list
                    //every profile is added here!
                    p = profileSnapshot.getValue(Profile.class);
                    profileList.add(p);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });
    }


    Profile getProfile(String username){
        for (Profile p: profileList){
            if (p.profileId == username)
                return p;
        }

        return null;
    }

    Profile getProfile(int i){
        return profileList.get(i);
    }

    void display(int i){
        p = getProfile(i);
        setContentView(R.layout.content_scrolling);
        TextView textViewName = (TextView) findViewById(R.id.tvNumber1);
        TextView textViewAboutMe = (TextView) findViewById(R.id.tvNumber2);
        TextView textViewCommunication = (TextView) findViewById(R.id.tvNumber3);
        TextView textViewNumber = (TextView) findViewById(R.id.tvNumber4);
        TextView textViewLocation = (TextView) findViewById(R.id.tvNumber5);
        TextView textViewAboutFrequency = (TextView) findViewById(R.id.tvNumber6);

        textViewAboutFrequency.setText(p.getFrequency());
        textViewAboutMe.setText(p.getAboutMe());
        textViewName.setText(p.aboutMe);
        textViewNumber.setText(p.aboutMe);
        textViewLocation.setText(p.getLocation());
        textViewCommunication.setText("Preferred method...");

    }

}