package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<String> mWordList;
    RecyclerView recycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.reciclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mWordList = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            mWordList.add("Dato "+i);

        }
        WordListAdapter adapter = new WordListAdapter(this,mWordList);
        recycler.setAdapter(adapter);
    }
    //Crear un bot
}