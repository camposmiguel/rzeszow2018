package com.miguelcr.a01_simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get the listView reference into the variable "lista"
        lista = findViewById(R.id.listViewStudents);

        // 2. List of students
        // 2.1. create the list
        students = new ArrayList<>();
        // 2.2. add students to the list
        students.add("Albert");
        students.add("Oscar");
        students.add("Eliza");
        students.add("Marek");
        students.add("Milosz");
        students.add("Mateusz I");
        students.add("Joachim");
        students.add("Wojtek");
        students.add("Lukasz");
        students.add("Norbert");
        students.add("Krystian");
        students.add("Wiktoria");
        students.add("Mateusz II");
        students.add("Patryk");
        students.add("Sylwia");

        // 3. Adapter
        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        // 4. Connect the adapter to the ListView lista
        lista.setAdapter(adapter);

        // 5. Create the list item click
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String nameClicked = students.get(position);
        Toast.makeText(this, "Student: " + nameClicked, Toast.LENGTH_SHORT).show();

        view.animate().rotationX(360).setDuration(1000).start();
    }
}
