package com.example.elearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class content_Activity4 extends AppCompatActivity {
    ListView listView;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ArrayAdapter<String> adapter3;
    int progres;
    String proval;
    SharedPreferences sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_4);

        listView= findViewById(R.id.content_view3);
        stringArrayList.add("STEP 1: Purchase equipment frugally");
        stringArrayList.add("STEP 2: Camera Basics 1");
        stringArrayList.add("STEP 3: Camera Basics 2");
        stringArrayList.add("STEP 4: Camera Basics 3");
        stringArrayList.add("STEP 5: Exposure and Metering");
        stringArrayList.add("STEP 6: Aperture");
        stringArrayList.add("STEP 7: Shutter speed");
        stringArrayList.add("STEP 8: ISO");
        stringArrayList.add("STEP 9: Lighting");
        stringArrayList.add("STEP 10: Lenses");
        stringArrayList.add("STEP 11: Practical Photography");
        stringArrayList.add("STEP 12: Lightroom Tutorial 1");
        stringArrayList.add("STEP 13: Lightroom Tutorial 2");
        stringArrayList.add("STEP 14: Lightroom Tutorial 3");
        stringArrayList.add("STEP 15: Lightroom Tutorial 4");

        adapter3 = new ArrayAdapter<>(content_Activity4.this, android.R.layout.simple_list_item_1, stringArrayList);
        listView.setAdapter(adapter3);

        sp2=getSharedPreferences("Myprogress3", Context.MODE_PRIVATE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    progres=7;
                    proval="7";
                    gotoUrl("https://photographyconcentrate.com/camera-buying-guide/");
                    shared();

                }
                if (position==1){
                    progres=14;
                    proval="14";
                    gotoUrl("https://youtu.be/ixRKeQMa7Nc");
                    shared();

                }
                if (position==2){
                    progres=21;
                    proval="21";
                    gotoUrl("https://youtu.be/tovy7hpnA7k");
                    shared();

                }
                if (position==3){
                    progres=28;
                    proval="28";
                    gotoUrl("https://youtu.be/-IwrkGuvVMs");
                    shared();

                }
                if (position==4){
                    progres=35;
                    proval="35";
                    gotoUrl("https://youtu.be/5V4uuNdmRHc");
                    shared();

                }
                if (position==5){
                    progres=42;
                    proval="42";
                    gotoUrl("https://youtu.be/jmY3Nac26yc");
                    shared();

                }
                if (position==6){
                    progres=49;
                    proval="49";
                    gotoUrl("hhttps://youtu.be/EdxKl5np9KE");
                    shared();

                }
                if (position==7){
                    progres=56;
                    proval="56";
                    gotoUrl("https://youtu.be/10lKVagFwaw");
                    shared();

                }
                if (position==8){
                    progres=63;
                    proval="63";
                    gotoUrl("https://youtu.be/VMl_kdPC2MI");
                    shared();

                }
                if (position==9){
                    progres=70;
                    proval="70";
                    gotoUrl("https://youtu.be/r9zJYHXhuII");
                    shared();

                }
                if (position==10){
                    progres=75;
                    proval="75";
                    gotoUrl("https://youtu.be/x68a4QDIMgY");
                    shared();

                }
                if (position==11){
                    progres=80;
                    proval="80";
                    gotoUrl("https://youtu.be/iGp8Z97F1CY");
                    shared();

                }
                if (position==12){
                    progres=85;
                    proval="85";
                    gotoUrl("https://youtu.be/9laSIoyp3xE");
                    shared();

                }
                if (position==13){
                    progres=90;
                    proval="90";
                    gotoUrl("https://youtu.be/dK-BTYqf_Pc");
                    shared();

                }
                if (position==14){
                    progres=95;
                    proval="95";
                    gotoUrl("https://youtu.be/YwrL8gIzoXU");
                    shared();

                }
                if (position==15){
                    progres=100;
                    proval="100";
                    gotoUrl("https://youtu.be/XakGd7BEAWg");
                    shared();

                }

            }
        });
    }

    private void shared() {
        SharedPreferences.Editor editor = sp2.edit();
        editor.putInt("PROG",progres);
        editor.putString("PROVAL",proval);
        editor.commit();

    }

    private void gotoUrl(String s) {
        Uri uri =Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_search,menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter3.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.pro1){
            Intent int1 = new Intent(content_Activity4.this,progressbar3.class);
            startActivity(int1);
        }

        return super.onOptionsItemSelected(item);
    }
}