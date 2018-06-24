package com.jlsegb.sentinel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String username;
    private String password;
    public GoogleSignInClient mGoogleSignInClient;
    public GoogleSignInAccount account;
    public int RC_SIGN_IN = 9001; // stack overflow said this could be any number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Google sign-in stoof
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        /* Check for existing Google Sign In account, if the user is already signed in,
        the GoogleSignInAccount will be non-null. */
        account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account); // part of tutorial
    }

    // button handling for google sign-in
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
        }
    }

    // google sign-in
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    // for google sing-in
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Log.d("sign-in", "requestCode == RC_SIGN_IN");
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    // for google sign-in
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("sign-in", "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }

    // This will be how we get to the next activity
    private void updateUI(GoogleSignInAccount account) {
        if (account != null) {
            Log.d("sign-in", "account email = " + account.getEmail());
        }
        else {
            Log.d("sign-in", "account = null");
            Toast.makeText(this.getBaseContext(), "Sign your entire phone into google before using this app!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /*
    @Override
    public void onResume(){
        super.onResume();..
    }
    */

    // for old sign-in method
    public void onLogInClick(View view) {
        TextView usernameObject = findViewById(R.id.editUsername);
        TextView passwordObject = findViewById(R.id.editPassword);
        username = usernameObject.getText().toString();
        password = passwordObject.getText().toString();
        Log.d("main", "username: " + username);
        Log.d("main", "password: " + password);
    }

    //save users log in info
    /*44444
    public void savedInfo (View view){
        SharedPreferences sharedPref = getSharedPreferences()
    }*/
}
