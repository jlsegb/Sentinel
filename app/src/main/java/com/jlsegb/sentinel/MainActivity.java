package com.jlsegb.sentinel;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity {

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null) {

        }
        else {
            
        }
    }

    /*
    @Override
    public void onResume(){
        super.onResume();..
    }
    */

    /**/
    public void onLogInClick(View view) {
        TextView usernameObject = findViewById(R.id.editUsername);
        TextView passwordObject = findViewById(R.id.editPassword);
        username = usernameObject.getText().toString();
        password = passwordObject.getText().toString();
        Log.d("main", "username: " + username);
        Log.d("main", "password: " + password);


    }
    /**/

    //save users log in info
    /*
    public void savedInfo (View view){
        SharedPreferences sharedPref = getSharedPreferences()
    }*/
}
