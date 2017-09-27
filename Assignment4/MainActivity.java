package com.a290.kevin.assignment4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<ToDo> myToDoList = new ArrayList<ToDo>();
    int pos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final android.app.FragmentManager fmanager = getFragmentManager();
        final android.app.FragmentTransaction ftransaction = fmanager.beginTransaction();

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        ftransaction.commit();




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final android.app.FragmentManager fmanager = getFragmentManager();
                final android.app.FragmentTransaction ftransaction = fmanager.beginTransaction();
                Fragment toDoInput = new ToDoInput();
                ftransaction.replace(R.id.main_activity_layout, toDoInput);
                ftransaction.commit();
                ListView currentList = (ListView) findViewById(R.id.myToDoListView);
                System.out.println(currentList.getVisibility());
                currentList.setVisibility(View.INVISIBLE);
            }
        });

        populateListView();
    }

    private void populateListView() {
        ArrayAdapter<ToDo> myAdapter = new myListAdapter();
        final ListView myListViewer = (ListView) findViewById(R.id.myToDoListView);
        myListViewer.setAdapter(myAdapter);
        myListViewer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                final android.app.FragmentManager fmanager = getFragmentManager();
                final android.app.FragmentTransaction ftransaction = fmanager.beginTransaction();
                Fragment toDoChange = new ToDoChange();
                ftransaction.replace(R.id.main_activity_layout, toDoChange);
                ftransaction.commit();

                pos = position;
                ToDo currentToDo = myToDoList.get(position);


                ListView currentList = (ListView) findViewById(R.id.myToDoListView);
                currentList.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void populateList(String title, String description) {
        myToDoList.add(new ToDo(title, description));
    }

    public void saveButtonHandler(View view) {
        TextView titleTextView = (TextView) findViewById(R.id.titleChange);
        String title = titleTextView.getText().toString();
        TextView descriptionTextView = (TextView) findViewById(R.id.contentsChange);
        String description = descriptionTextView.getText().toString();
        populateList(title, description);
        ListView currentList = (ListView) findViewById(R.id.myToDoListView);
        currentList.setVisibility(View.VISIBLE);
        View input = (View) findViewById(R.id.toDoInputView);
        input.setVisibility(View.GONE);
    }

    public void deletebuttonhandler(View view) {
        myToDoList.remove(pos);
        populateListView();
        ListView currentList = (ListView) findViewById(R.id.myToDoListView);
        currentList.setVisibility(View.VISIBLE);
        View input = (View) findViewById(R.id.toDoInputView);
        input.setVisibility(View.GONE);

    }

    public void editsaveButtonHandler(View view) {
        myToDoList.remove(pos);
        EditText titleTextView = (EditText) findViewById(R.id.titleEdit);
        String title = titleTextView.getText().toString();
        TextView descriptionTextView = (TextView) findViewById(R.id.contentsEdit);
        String description = descriptionTextView.getText().toString();
        myToDoList.add(new ToDo(title, description));
        populateListView();
        ListView currentList = (ListView) findViewById(R.id.myToDoListView);
        currentList.setVisibility(View.VISIBLE);
        View input = (View) findViewById(R.id.toDoInputView);
        input.setVisibility(View.GONE);
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
