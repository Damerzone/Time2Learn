package com.edx.marco.time2learn;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.AnnotatedElement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SubTopic extends ActionBarActivity {

    private List<String>    _topicList;
    private String[]        _topicArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_topic);
        ListView lv = (ListView) this.findViewById(R.id.subTopic);
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("stuff");

        getList(stuff);
        addOnList(lv);
        itemListener(lv);
    }

    public void addOnList(ListView lv)
    {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this._topicArray);
        lv.setAdapter(arrayAdapter);
    }
    public void itemListener(ListView lv) {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int arg2, long arg3) {
                Intent nextLayout = new Intent(SubTopic.this, Time.class);
                Bundle bundle = new Bundle();

                bundle.putString("stuff", ((TextView) arg1).getText().toString());
                nextLayout.putExtras(bundle);
                startActivity(nextLayout);
            }
        });
    }
    public void getList(String stuff)
    {
        switch (stuff) {
            case "Science":
                setScience();
                break;
            case "Biology":
                setBiolgy();
                break;
            case "Social sciences & Law":
                setSocial();
                break;
            case "Art & Culture":
                setCultural();
                break;
            default:
        }
    }

    public void setCultural() {
        this._topicArray = new String[6];
        this._topicArray[0] = "Architecture";
        this._topicArray[1] = "Art & Culture";
        this._topicArray[2] = "History";
        this._topicArray[3] = "Literature";
        this._topicArray[4] = "Music";
        this._topicArray[5] = "Philosophy & Ethics";
    }

    public void setSocial() {
        this._topicArray = new String[6];
        this._topicArray[0] = "Business & Management";
        this._topicArray[1] = "Statistics & Data Analysis";
        this._topicArray[2] = "Communication";
        this._topicArray[3] = "Economics & Finance";
        this._topicArray[4] = "Education";
        this._topicArray[5] = "Social Sciences";
    }

    public void setScience() {
        this._topicArray = new String[8];
        this._topicArray[0] =   "Chemistry";
        this._topicArray[1] =   "Computer Science";
        this._topicArray[2] =   "Electronics";
        this._topicArray[3] =   "Engineering";
        this._topicArray[4] =   "Ethics";
        this._topicArray[5] =   "Math";
        this._topicArray[6] =   "Physics";
        this._topicArray[7] =   "Science";
    }

    public void setBiolgy() {
        this._topicArray = new String[7];
        this._topicArray[0] ="Biology & Life Science";
        this._topicArray[1] ="Energy & Earth Sciences";
        this._topicArray[2] ="Environmental Studies";
        this._topicArray[3] ="Food & Nutrition";
        this._topicArray[4] ="Health & Safety";
        this._topicArray[5] ="Humanities";
        this._topicArray[6] ="Medicine";
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub_topic, menu);
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
