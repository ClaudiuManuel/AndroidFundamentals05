package com.android.androidfundamentalsgroup1;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private TextView firstName;
    private TextView lastName;
    private LinearLayout linearLayout;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);

        firstName = itemView.findViewById(R.id.firstNameText);
        lastName = itemView.findViewById(R.id.lastNameText);
        linearLayout = itemView.findViewById(R.id.linearLayoutStudents);
    }

    public TextView getFirstName() {
        return firstName;
    }

    public TextView getLastName() {
        return lastName;
    }

    public LinearLayout getLinearLayout(){
        return linearLayout;
    }
}
