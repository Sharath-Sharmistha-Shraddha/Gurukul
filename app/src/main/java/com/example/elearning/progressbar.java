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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class progressbar extends AppCompatActivity {

    int progr1=0;
    ProgressBar pb;
    TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        prog();

    }

    public void prog() {
        pb = findViewById(R.id.progress_bar1);
        textView = findViewById(R.id.text_view_progress1);


        SharedPreferences sp= getApplicationContext().getSharedPreferences("Myprogress", Context.MODE_PRIVATE);

        progr1 = sp.getInt("PROG",0);
        String pro = sp.getString("PROVAL","0");
        if (progr1<=100){

            pb.setProgress(progr1);
            textView.setText((pro)+"%");


        }
    }


}