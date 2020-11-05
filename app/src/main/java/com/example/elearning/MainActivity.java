package com.example.elearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.MenuItemCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public CardView cac6,cac8,cac11;

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cac6 = findViewById(R.id.c6);
        cac8 = findViewById(R.id.c8);
        cac11 = findViewById(R.id.c11);

        img = findViewById(R.id.nav);

        cac6.setOnClickListener(this);
        cac8.setOnClickListener(this);
        cac11.setOnClickListener(this);
        img.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.c6:
                intent = new Intent(this,makeup.class);
                startActivity(intent);
                break;

            case R.id.c8:
                intent = new Intent(this,content_Activity4.class);
                startActivity(intent);
                break;

            case R.id.c11:
                intent = new Intent(this,content_Activity2.class);
                startActivity(intent);
                break;
            case R.id.nav:
                intent = new Intent(this,navlogout.class);
                startActivity(intent);
                
                break;
        }

    }
}
