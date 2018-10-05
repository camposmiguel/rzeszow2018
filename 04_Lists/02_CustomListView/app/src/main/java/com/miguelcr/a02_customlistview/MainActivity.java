package com.miguelcr.a02_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<StudentItem> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.listViewStudents);

        // Student list
        students = new ArrayList<>();

        students.add(new StudentItem("Albert",19, "https://s3.amazonaws.com/uifaces/faces/twitter/ashleyford/128.jpg"));
        students.add(new StudentItem("Oscar",19, "https://s3.amazonaws.com/uifaces/faces/twitter/kerem/128.jpg"));
        students.add(new StudentItem("Norbert",19, "https://s3.amazonaws.com/uifaces/faces/twitter/sillyleo/128.jpg"));

        // Adapter
        StudentAdapter adapter = new StudentAdapter(
                this,
                R.layout.student_item,
                students
        );
    }
}
