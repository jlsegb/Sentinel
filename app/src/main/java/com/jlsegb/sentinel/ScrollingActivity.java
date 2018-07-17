package com.jlsegb.sentinel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


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

    ListView listViewProfiles;

    List<Profile> profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        databaseProfiles = FirebaseDatabase.getInstance().getReference("profiles");

        listViewProfiles = (ListView) findViewById(R.id.listViewProfiles);

        profileList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

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
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}