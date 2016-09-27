package com.taberu.todolist;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ToDoActivity extends AppCompatActivity implements
        NewItemFragment.OnNewItemAddedListener{
    public ArrayAdapter<String> aa;
    public ArrayList<String> todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        // Get references to the Fragment
        FragmentManager fm = getFragmentManager();
        ToDoListFragment todoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.TodoListFragment);

        todoItems = new ArrayList<>();

        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoItems);

        todoListFragment.setListAdapter(aa);
    }

    public void onNewItemAdded(String newItem) {
        todoItems.add(newItem);
        aa.notifyDataSetChanged();
    }
}
