package com.android.androidfundamentalsgroup1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.WHITE;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private Context context;
    private List<Student> students;

    public StudentAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View studentView = LayoutInflater.from(context).inflate(R.layout.students_layout,parent,false);
        return new StudentViewHolder(studentView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.getFirstName().setText(student.getFirstName() + " " + position);
        holder.getLastName().setText(student.getLastName() + " " + position);

        if(position%2 == 0){
            holder.getLinearLayout().setBackgroundColor(GRAY);
        } else {
            holder.getLinearLayout().setBackgroundColor(WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
