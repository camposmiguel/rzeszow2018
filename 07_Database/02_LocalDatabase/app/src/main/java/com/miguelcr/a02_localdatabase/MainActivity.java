package com.miguelcr.a02_localdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    RealmResults<StudentItem> studentItemList;
    Realm realm;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        lista = findViewById(R.id.listView);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewStudentActivity.class);
                startActivity(i);
            }
        });

        loadStudentListDb();
    }

    private void loadStudentListDb() {
        // Initialize the database
        realm = Realm.getDefaultInstance();

        // SELECT * FROM Students
        studentItemList = realm.where(StudentItem.class).findAll();

        // Adapter
        studentAdapter = new StudentAdapter(
                MainActivity.this,
                R.layout.student_item,
                studentItemList
        );

        // Connect the adapter and lista
        lista.setAdapter(studentAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // SELECT * FROM Students
        studentItemList = realm.where(StudentItem.class).findAll();
        studentAdapter.notifyDataSetChanged();
    }
}
