package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<String> mWordList;
    RecyclerView recycler;

    ImageButton mImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageButton= (ImageButton) findViewById(R.id.imageButton);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWordList.add("Word " + mWordList.size());
                recycler.getAdapter().notifyItemInserted(mWordList.size());
                recycler.smoothScrollToPosition(mWordList.size());
            }
        });
        recycler = findViewById(R.id.reciclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recycler,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        TextView datos;
                        datos = (TextView) findViewById(R.id.datos);// do whatever
                        datos.setText ("Clicked! "+ datos.getText());
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
        mWordList = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            mWordList.add("Word "+i);

        }

        WordListAdapter adapter = new WordListAdapter(this,mWordList);
        recycler.setAdapter(adapter);

// Scroll to the bottom.

    }



}