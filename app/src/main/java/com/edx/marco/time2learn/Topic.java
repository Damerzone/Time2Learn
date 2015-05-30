package com.edx.marco.time2learn;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.ListMenuItemView;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class Topic extends ActionBarActivity {

    private int             _topicId;
    private String          _topicName;
    private List<String>    _topicList;
    private String[]        _topicArray;
    private int             _nbVid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        ListView lv = (ListView) this.findViewById(R.id.topicList);

        _topicArray = new String[4];
        this._topicArray[0] = "Science";
        this._topicArray[1] = "Biology";
        this._topicArray[2] = "Social sciences & Law";
        this._topicArray[3] = "Art & Culture";
        this._topicList = new List<String>() {
            @Override
            public void add(int location, String object) {

            }

            @Override
            public boolean add(String object) {
                return false;
            }

            @Override
            public boolean addAll(int location, Collection<? extends String> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public String get(int location) {
                return null;
            }

            @Override
            public int indexOf(Object object) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<String> listIterator(int location) {
                return null;
            }

            @Override
            public String remove(int location) {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public String set(int location, String object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<String> subList(int start, int end) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };


        CustomListAdapter listAdapter = new CustomListAdapter(this , R.layout.custom_list, this._topicList);
        lv.setAdapter(listAdapter);

        addOnList(lv);
        itemListener(lv);
    }

    public void itemListener(ListView lv) {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int arg2, long arg3) {
                Intent nextLayout = new Intent(Topic.this, SubTopic.class);
                Bundle bundle = new Bundle();

                bundle.putString("stuff", ((TextView) arg1).getText().toString());
                nextLayout.putExtras(bundle);
                startActivity(nextLayout);
            }
        });
    }
    public void addTopic(String name)
    {
        this._topicArray[this._topicArray.length] = name;
    }

    public void setTopicId(int id) {
        this._topicId = id;
    }

    public void addOnList(ListView lv)
    {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this._topicArray);
        lv.setAdapter(arrayAdapter);
    }

    public void set_topicName(String name) {
        this._topicName = name;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_topic, menu);
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