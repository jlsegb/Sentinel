package com.jlsegb.sentinel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName;
    EditText editLocation;
    EditText editAboutMe;
    EditText editFrequency;
    FloatingActionButton buttonSubmit;
    FloatingActionButton skipActivity;
    DatabaseReference databaseProfiles;

    ListView listViewProfiles;

    List<Profile> profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //this didn't need to be used but will leave just in case it is needed later on @jose
        // Added by Jose to see if it fixed the app's crashing
        //FirebaseApp.initializeApp(getApplicationContext());@jose
        databaseProfiles = FirebaseDatabase.getInstance().getReference("profiles");

        listViewProfiles = (ListView) findViewById(R.id.listViewProfiles);

        profileList = new ArrayList<>();
        databaseProfiles = FirebaseDatabase.getInstance().getReference("profiles");

        databaseProfiles.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                profileList.clear();
                for(DataSnapshot profileSnapshot: dataSnapshot.getChildren()){
                    Profile profile = profileSnapshot.getValue(Profile.class);

                    profileList.add(profile);
                }

                //ProfileList adapter = new ProfileList(EditProfileActivity.this, profileList);

                //listViewProfiles.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Profile p = new Profile();
        SharedPreferences settings = getSharedPreferences("MY_KEYS",
                Context.MODE_PRIVATE);
        String id = settings.getString("MY_KEY", "defaultvalue");

        //look for this specific profile
        for (Profile p1 : profileList){
            if (p1.profileId == id){
                p = p1;
            }
        }

        editName = (EditText) findViewById(R.id.editName);
        editLocation = (EditText) findViewById(R.id.editLocation);
        editAboutMe = (EditText) findViewById(R.id.editAboutMe);
        editFrequency = (EditText) findViewById(R.id.editFrequency);

        editName.setText(p.getName1());
        editLocation.setText(p.getLocation());
        editAboutMe.setText(p.getAboutMe());
        editFrequency.setText(p.getFrequency());

        buttonSubmit = (FloatingActionButton) findViewById(R.id.buttonSubmit);
        skipActivity = (FloatingActionButton) findViewById(R.id.skipActivity);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProfile();
            }
        });
        skipActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skipActivity();
            }
        });    }

    private void addProfile() {
        String name = editName.getText().toString().trim();
        String location = editLocation.getText().toString().trim();//now this is contact info
        String aboutMe = editAboutMe.getText().toString().trim();
        String frequency = editFrequency.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){

            SharedPreferences settings = getSharedPreferences("MY_KEYS",
                    Context.MODE_PRIVATE);
            String id = settings.getString("MY_KEY", "defaultvalue");

            //String id = PreferenceManager.getDefaultSharedPreferences(this).getString("MYKEY", "defaultStringIfNothingFound");
            //String id = databaseProfiles.push().getKey();

            Profile profile = new Profile(id, name, location, aboutMe, frequency);

            databaseProfiles.child(id).setValue(profile);

            Toast.makeText(this, "Profile created", Toast.LENGTH_LONG).show();

            try {
                startActivity(new Intent(this, ScrollingActivity.class) );
            } catch (Exception e) {
                Toast.makeText(EditProfileActivity.this, "well frick", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "You must enter a name", Toast.LENGTH_LONG).show();
        }
    }
    public void skipActivity() {
        try {
            startActivity(new Intent(this, ScrollingActivity.class) );
        } catch (Exception e) {
            Toast.makeText(EditProfileActivity.this, "well frick", Toast.LENGTH_SHORT).show();
        }
    }
}
