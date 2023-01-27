package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordListHolder>  {

    LayoutInflater mInflater;
    LinkedList<String> mWordList;

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordListHolder onCreateViewHolder(ViewGroup parent, int viewType){ // Inflate an item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,null,false);
        return new WordListHolder(view);
    }

    @Override
    public void onBindViewHolder(WordListHolder holder, int position) {
        holder.asignarDatos(mWordList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    public class WordListHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView datos;
        public WordListHolder(@NonNull View itemView) {
            super(itemView);
            datos = (TextView) itemView.findViewById(R.id.datos);
        }

        public void asignarDatos(String s) {
            datos.setText(s);
        }

        @Override
        public void onClick(View v) {
            datos.setText ("Clicked! "+ datos.getText());
        }
    }
}
