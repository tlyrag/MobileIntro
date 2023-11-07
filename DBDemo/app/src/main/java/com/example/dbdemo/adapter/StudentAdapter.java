package com.example.dbdemo.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dbdemo.databinding.LayoutStudentitemBinding;
import com.example.dbdemo.model.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<Student> studentList;
    LayoutStudentitemBinding itemBinding;
    public final String TAG = "DBDemo";

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
        Log.d(TAG, "StudentAdapter: " + studentList);
    }

    @Override
    public int getCount() {

        return studentList.size();
    }

    @Override
    public Object getItem(int i) {

        return studentList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            itemBinding = LayoutStudentitemBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
        }
        if(i==0) {
            itemBinding.txtViewStudName.setText("StudName");
            itemBinding.txtViewStudId.setText("StudID");
            itemBinding.txtViewDept.setText("Dept");
            itemBinding.txtViewDept.setTextColor(Color.RED);
            itemBinding.txtViewStudId.setTextColor(Color.RED);
            itemBinding.txtViewStudName.setTextColor(Color.RED);
        } else  {
            itemBinding.txtViewStudId.setText(studentList.get(i-1).getStudID());
            itemBinding.txtViewDept.setText(studentList.get(i-1).getStudDept());
            itemBinding.txtViewStudName.setText(studentList.get(i-1).getStudName());
            itemBinding.txtViewDept.setTextColor(Color.BLACK);
            itemBinding.txtViewStudId.setTextColor(Color.BLACK);
            itemBinding.txtViewStudName.setTextColor(Color.BLACK);

        }


        return itemBinding.getRoot();
    }
}
