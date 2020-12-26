package com.android.androidfundamentalsgroup1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerViewEmails;
    private RecyclerView recylerViewStudents;

    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // seteaza layout-ul asociat activatii MainActivity
        // setContentView(R.layout.activity_main);
        // asociem views_sample_1 ca layout al activitatii MainActivity
        // setContentView(R.layout.views_sample_1);
        // displayViewsSample1();

        // run ScrollView sample
        // setContentView(R.layout.views_sample_scroll_view);

        // run WebView sample
        // setContentView(R.layout.views_sample_web_view);
        // loadUrlInWebView();

        // run Spinner sample
        // setContentView(R.layout.views_sample_spinner);
        // setupSpinnerAdapter();

        // run RecyclerView sample
        setContentView(R.layout.code_challenge_recyclerview);
        displayEmailsList();
    }

    // RecyclerView implementation
    // get data source
    private void inbox() {
        students = new ArrayList<Student>();
        Student student = null;
        for (int i = 0; i < 25; i++) {
            student = new Student("First Name","Last Name");
            students.add(student);
        }
    }

    // set the layout manager, in our case LinearLayoutManager because it's a list of emails
    private void setStudentsLayoutManager() {
        /*recyclerViewEmails = findViewById(R.id.recyclerViewEmails);*/
        recylerViewStudents = findViewById(R.id.recyclerViewStudents);
        recylerViewStudents.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setStudentAdapter() {
        recylerViewStudents.setAdapter(new StudentAdapter(this, students));
    }

    private void displayEmailsList() {
        inbox();
        setStudentsLayoutManager();
        setStudentAdapter();
    }
}
