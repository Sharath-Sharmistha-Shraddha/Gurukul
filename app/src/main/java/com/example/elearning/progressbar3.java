package com.example.elearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class progressbar3 extends AppCompatActivity {
    ProgressBar pb;
    TextView textView;
    int progr3=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar3);

        prog();
    }

    private void prog() {
        pb = findViewById(R.id.progress_bar3);
        textView = findViewById(R.id.text_view_progress3);


        SharedPreferences sp2= getApplicationContext().getSharedPreferences("Myprogress3", Context.MODE_PRIVATE);

        progr3 = sp2.getInt("PROG",0);
        String pro = sp2.getString("PROVAL","0");
        if (progr3<=100){

            pb.setProgress(progr3);
            textView.setText((pro)+"%");


        }
    }
}