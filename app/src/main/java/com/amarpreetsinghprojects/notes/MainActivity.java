package com.amarpreetsinghprojects.notes;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Contents> contentsArrayList = new ArrayList<>();
    EditText titleeditText,contentsEditText;
    NoteAdapter noteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addbutton = (Button)findViewById(R.id.addButton);
        contentsEditText = (EditText)findViewById(R.id.noteETV);
        titleeditText = (EditText)findViewById(R.id.noteTitle);
        addbutton.setOnClickListener(this);

        RecyclerView contentsRV = (RecyclerView)findViewById(R.id.notesRV);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);

        noteAdapter = new NoteAdapter(contentsArrayList);

        contentsRV.setLayoutManager(layoutManager);
        contentsRV.setAdapter(noteAdapter);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void onClick(View v) {
        contentsArrayList.add(new Contents(titleeditText.getText().toString(),contentsEditText.getText().toString()));
        noteAdapter.notifyDataSetChanged();
        contentsEditText.setText(null);
        titleeditText.setText(null);

    }
}
