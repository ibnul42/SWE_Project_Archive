package project.mahmud.com.swe.sweprojectarchive;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Project extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    List<ProjectModel>modelList;
    Database4 database4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        recyclerView = findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        dataList();
    }


    private void dataList()
    {
        database4= new Database4(this);
        modelList = new ArrayList<>();
        Cursor cursor = database4.showAllData();
        assert cursor != null;
        while (cursor.moveToNext())
        {
            String firstValue = cursor.getString(0);
            String secondValue = cursor.getString(1);
            String thirdValue = cursor.getString(2);
            modelList.add(new ProjectModel(firstValue,secondValue,thirdValue));
            Log.d("first",firstValue);
            Log.d("sec",secondValue);
            Log.d("third",thirdValue);
        }





        ProjectAdapter adapter =  new ProjectAdapter(this,modelList);
        recyclerView.setAdapter(adapter);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());



    }

}


