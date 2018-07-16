package com.jlsegb.sentinel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import java.util.Objects;

import static android.widget.Toast.LENGTH_LONG;


public class ScrollingActivity extends AppCompatActivity {

    FloatingActionButton checkMark;
    FloatingActionButton xMark;
    Account account = new Account();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        checkMark = (FloatingActionButton) findViewById(R.id.fab3);
        checkMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMark();
            }
        });
        xMark = (FloatingActionButton) findViewById(R.id.fab);
        xMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xMark();
            }
        });
    }

    private void checkMark() {
        Toast.makeText(ScrollingActivity.this, "checkMark!",
                Toast.LENGTH_LONG).show();
        // call account.swipeHistory.addDesirable
    }
    private void xMark() {
        Toast.makeText(ScrollingActivity.this, "xMark!",
                Toast.LENGTH_LONG).show();
        // call account.swipeHistory.addUndesirable
    }

}