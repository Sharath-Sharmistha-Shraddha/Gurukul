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

public class makeup extends AppCompatActivity {
    ListView listView;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ArrayAdapter<String> adapter0;
    int progres;
    String proval;
    SharedPreferences sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        listView= findViewById(R.id.content_view0);
        stringArrayList.add("STEP 1: Build a pro makeup kit");
        stringArrayList.add("STEP 2: Makeup tutorials");
        stringArrayList.add("STEP 3: Bobbi Brown Masterclass");
        stringArrayList.add("STEP 4: Bobbi Brown Makeup Manual");

        adapter0 = new ArrayAdapter<>(makeup.this, android.R.layout.simple_list_item_1, stringArrayList);
        listView.setAdapter(adapter0);
        sp1=getSharedPreferences("Myprogress2", Context.MODE_PRIVATE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    progres=25;
                    proval="25";
                    gotoUrl("https://www.makeup.com/product-and-reviews/editors-picks/how-to-build-a-makeup-kit?amp=true");
                    shared();

                }
                if (position==1){
                    progres=25;
                    proval="25";
                    gotoUrl("https://alison.com/course/diploma-in-makeup-artistry");
                    shared();

                }
                if (position==2){
                    progres=25;
                    proval="25";
                    gotoUrl("https://www.youtube.com/playlist?list=PLXsytAFmHsrQHUBSFObbzsZNRd1pXVh0w");
                    shared();

                }
                if (position==3){
                    progres=25;
                    proval="25";
                    gotoUrl("https://b-ok.asia/ireader/2704025");
                    shared();

                }
            }
        });
    }

    private void shared() {
        SharedPreferences.Editor editor = sp1.edit();
        editor.putInt("PROG",progres);
        editor.putString("PROVAL",proval);
        editor.commit();
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
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
                adapter0.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.pro1){
            Intent int1 = new Intent(makeup.this,progressbar2.class);
            startActivity(int1);
        }

        return super.onOptionsItemSelected(item);
    }

}