package com.example.caiosanchez.recyclerviewexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.caiosanchez.recyclerviewexample.Adapter.RecycleViewAdapter;
import com.example.caiosanchez.recyclerviewexample.Dummy.DummyContent;
import com.example.caiosanchez.recyclerviewexample.Model.Item;

public class ScrollingActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter != null) {
                    DummyContent.addNewItem();
                    adapter.notifyDataSetChanged();
                }
            }
        });

        adapter = new RecycleViewAdapter(DummyContent.ITEMS, new IAdapterOnClickListener() {
            @Override
            public void onClickItem(Item item) {
                Snackbar.make(fab, "Tap on: " + item, Snackbar.LENGTH_SHORT).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
