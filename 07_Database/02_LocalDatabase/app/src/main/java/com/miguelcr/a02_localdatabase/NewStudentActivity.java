package com.miguelcr.a02_localdatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class NewStudentActivity extends AppCompatActivity {
    EditText editTextName, editTextAge, editTextPhoto;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextPhoto = findViewById(R.id.editTextPhotoUrl);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStudent();
            }
        });

        realm = Realm.getDefaultInstance();
    }

    private void saveStudent() {
        final String name = editTextName.getText().toString();
        final int age = Integer.parseInt(editTextAge.getText().toString());
        final String photoUrl = editTextPhoto.getText().toString();

        if(name.equals("") || age < 0 || photoUrl.equals("")) {
            Toast.makeText(this, "Complete the student info!", Toast.LENGTH_SHORT).show();
        } else {
            // The information is correct, we can create the student
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    StudentItem newStudentItem = new StudentItem();
                    newStudentItem.setName(name);
                    newStudentItem.setAge(age);
                    newStudentItem.setPhotoUrl(photoUrl);

                    // save the new student in the DB
                    realm.copyToRealm(newStudentItem);

                    // destroy the current activity to close it
                    finish();
                }
            });
        }
    }

}
