package com.example.yanglei.feedback;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.transition.slide_down,R.transition.slide_top);
        setContentView(R.layout.first_question);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
