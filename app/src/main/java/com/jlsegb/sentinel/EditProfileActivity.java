package com.jlsegb.sentinel;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileActivity extends AppCompatActivity {

    EditText editName;
    EditText editLocation;
    EditText editAboutMe;
    EditText editFrequency;
    FloatingActionButton buttonSubmit;

    DatabaseReference databaseProfiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //this didn't need to be used but will leave just in case it is needed later on @jose
        // Added by Jose to see if it fixed the app's crashing
        //FirebaseApp.initializeApp(getApplicationContext());@jose

        databaseProfiles = FirebaseDatabase.getInstance().getReference("profiles");

        //*************Jose **************//
        //write message 'm' to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");
        //***********************************//

        editName = (EditText) findViewById(R.id.editName);
        editLocation = (EditText) findViewById(R.id.editLocation);
        editAboutMe = (EditText) findViewById(R.id.editAboutMe);
        editFrequency = (EditText) findViewById(R.id.editFrequency);

        buttonSubmit = (FloatingActionButton) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProfile();
            }
        });
    }

    private void addProfile() {
        String name = editName.getText().toString().trim();
        String location = editLocation.getText().toString().trim();
        String aboutMe = editAboutMe.getText().toString().trim();
        String frequency = editFrequency.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){

            String id = databaseProfiles.push().getKey();

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
}
