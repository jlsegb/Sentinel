package com.jlsegb.sentinel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.widget.Toast.LENGTH_LONG;


public class ScrollingActivity extends AppCompatActivity {

    DatabaseReference databaseProfiles;

    List<Profile> profileList;
    Profile p;

    int i = 0;
    DatabaseReference databaseProfiles;

    ListView listViewProfiles;

    List<Profile> profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "On crestion", Toast.LENGTH_LONG).show();

        databaseProfiles = FirebaseDatabase.getInstance().getReference("profiles");
        System.out.print("***************************1*********************************");

        profileList = new ArrayList<>();
        databaseProfiles.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                profileList.clear();
                for (com.google.firebase.database.DataSnapshot profileSnapshot : dataSnapshot.getChildren()) {

                    //String sProfile = new String();
                    //this gets the object back and adds it to a list
                    //every profile is added here!
                    Profile p1 = profileSnapshot.getValue(Profile.class);
                    profileList.add(p1);

                    System.out.print(i);
                    i++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Toast.makeText(this, "On crestion3", Toast.LENGTH_LONG).show();


        if (profileList.size() > i)
            p = profileList.get(i);


        setContentView(R.layout.activity_scrolling);

        databaseProfiles = FirebaseDatabase.getInstance().getReference("profiles");
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        listViewProfiles = (ListView) findViewById(R.id.listViewProfiles);

        profileList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView textViewName = (TextView) findViewById(R.id.tvNumber1);
        TextView textViewAboutMe = (TextView) findViewById(R.id.tvNumber2);
        TextView textViewCommunication = (TextView) findViewById(R.id.tvNumber3);
        TextView textViewNumber = (TextView) findViewById(R.id.tvNumber4);
        TextView textViewLocation = (TextView) findViewById(R.id.tvNumber5);
        TextView textViewAboutFrequency = (TextView) findViewById(R.id.tvNumber6);

        textViewAboutFrequency.setText("Meeting Frequency");
        textViewAboutMe.setText("More about what I've been through and who I am");
        textViewName.setText("My name is...");
        textViewNumber.setText("(123) 456-7895");
        textViewLocation.setText("Rexburg");
        textViewCommunication.setText("Phone calls or in Person");
        System.out.print("****************************3********************************");

        //Deny button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
        databaseProfiles.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                profileList.clear();
                for(DataSnapshot profileSnapshot: dataSnapshot.getChildren()){
                    Profile profile = profileSnapshot.getValue(Profile.class);

                    profileList.add(profile);
                }

                ProfileList adapter = new ProfileList(ScrollingActivity.this, profileList);

                listViewProfiles.setAdapter(adapter);
            }

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Accept!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);



    }
}