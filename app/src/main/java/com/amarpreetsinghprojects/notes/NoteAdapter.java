package com.amarpreetsinghprojects.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kulvi on 06/26/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NotesViewHolder>{

    ArrayList<Contents> contentsArrayList;


    public NoteAdapter(ArrayList<Contents> contentsArrayList) {
        this.contentsArrayList = contentsArrayList;
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = (LayoutInflater.from(parent.getContext())).inflate(R.layout.content_single_item,parent,false);
        return new NotesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        Contents c = contentsArrayList.get(position);
        holder.title.setText(c.getTitle());
        String contents = c.getContents();
       /* if (contents.length()>10){
            String subcontents = contents.substring(0,10)+".....";
            holder.contents.setText(subcontents);
        }
        else {*/
            holder.contents.setText(c.getContents());
        //}

    }



    @Override
    public int getItemCount() {
        return contentsArrayList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {

        TextView title, contents;

        public NotesViewHolder(View itemView) {
            super(itemView);

            title =(TextView)itemView.findViewById(R.id.titleTV);
            contents = (TextView)itemView.findViewById(R.id.contentsTV);
        }
    }
}
