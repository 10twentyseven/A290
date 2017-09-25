package com.a290.kevin.assignment5;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<ToDo> myToDoList = new ArrayList<ToDo>();
    android.app.FragmentManager fmanager = getFragmentManager();
    android.app.FragmentTransaction ftransaction = fmanager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment toDoInput = new ToDoInput();
                ftransaction.replace(R.id.myToDoListView, toDoInput);
            }
        });

        populateListView();
        populateList();
    }

    private void populateListView() {
        ArrayAdapter<ToDo> myAdapter = new myListAdapter();
        ListView myListViewer = (ListView) findViewById(R.id.myToDoListView);
        myListViewer.setAdapter(myAdapter);
    }

    private void populateList() {
        myToDoList.add(new ToDo("Aerosmith", "Rock and Roll BAYBEEEEE"));
    }

    private class myListAdapter extends ArrayAdapter<ToDo> {
        public myListAdapter() {
            super(MainActivity.this, R.layout.todo_layout, myToDoList);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            if (itemView ==null){
                itemView = getLayoutInflater().inflate(R.layout.todo_layout, parent, false);
            }

            ToDo currentToDo = myToDoList.get(position);

            TextView itemDescription = (TextView) itemView.findViewById(R.id.toDoDescription);
            itemDescription.setText(currentToDo.getDescription());

            TextView itemTitle = (TextView) itemView.findViewById(R.id.title);
            itemTitle.setText(currentToDo.getTitle());

            return itemView;
        }

    }

}
