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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class content_Activity2 extends AppCompatActivity {
    ListView listView;
    ArrayList<String> stringArrayList = new ArrayList<>();
    ArrayAdapter<String> adapter1;
    int progres;
    String proval;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_2);


        listView= findViewById(R.id.content_view1);
        stringArrayList.add("STEP 1: System Engineer Specialization");
        stringArrayList.add("STEP 2: Reference material 1");
        stringArrayList.add("STEP 3: Reference material 2");


        adapter1 = new ArrayAdapter<>(content_Activity2.this, android.R.layout.simple_list_item_1, stringArrayList);
        listView.setAdapter(adapter1);

        sp=getSharedPreferences("Myprogress", Context.MODE_PRIVATE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    progres=50;
                    proval="50";

                    gotoUrl("https://www.youtube.com/playlist?list=PLxn52v8fxX5l5tGzU1NAxRDkgqxK0k5UZ");
                    shared();

                }
                if (position==1){
                    progres=75;
                    proval="75";


                    gotoUrl("https://b-ok.asia/book/1035461/d61b56");
                    shared();

                }
                if (position==2){
                    progres=100;
                    proval="100";

                    gotoUrl("https://b-ok.asia/book/2553833/e48ad4");
                    shared();
                }
            }
        });

    }

    private void shared() {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("PROG",progres);
        editor.putString("PROVAL",proval);
        editor.commit();
    }


    private void gotoUrl(String s) {

        Uri uri =Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);


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
                adapter1.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.pro1){
            Intent int1 = new Intent(content_Activity2.this,progressbar.class);
            startActivity(int1);
        }

        return super.onOptionsItemSelected(item);
    }
}
