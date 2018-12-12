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

public class Submission extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    List<Model>modelList;
    Database2 database2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        recyclerView = findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        dataList();
    }


    private void dataList()
    {
        database2 = new Database2(this);
        modelList = new ArrayList<>();
        Cursor cursor = database2.showAllData();
        assert cursor != null;
        while (cursor.moveToNext())
        {
            String firstValue = cursor.getString(0);
            String secondValue = cursor.getString(1);
            String thirdValue = cursor.getString(2);
            modelList.add(new Model(firstValue,secondValue,thirdValue));
            Log.d("first",firstValue);
            Log.d("sec",secondValue);
            Log.d("third",thirdValue);
        }





        CustomAdapter adapter =  new CustomAdapter(this,modelList);
        recyclerView.setAdapter(adapter);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());



    }

}


