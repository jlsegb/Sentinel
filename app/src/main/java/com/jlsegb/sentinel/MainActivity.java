package com.jlsegb.sentinel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    @Override
    public void onResume(){
        super.onResume();
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
}
