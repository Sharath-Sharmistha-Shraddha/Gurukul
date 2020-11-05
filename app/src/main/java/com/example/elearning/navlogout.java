package com.example.elearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class navlogout extends AppCompatActivity {
    NavigationView nav;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navlogout);
        nav= findViewById(R.id.navmen);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.lout:
                        SharedPreferences logs = getSharedPreferences("checkbox",MODE_PRIVATE);
                        SharedPreferences.Editor editor = logs.edit();
                        editor.putString("remember","false");
                        editor.apply();
                        Intent intent= new Intent(navlogout.this,login.class);

                        startActivity(intent);

                        finish();
                        break;
                        
                }
                return true;
            }
        });


    }




}