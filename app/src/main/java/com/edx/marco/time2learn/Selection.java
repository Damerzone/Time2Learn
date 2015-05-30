package com.edx.marco.time2learn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Selection extends ActionBarActivity {
    private CoverFlow   _coverFlow;
    private Integer[]   _imageTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        //this._coverFlow = (Gallery) findViewById(R.id.coursesSelection);
        this._coverFlow = new CoverFlow(this);
        getSelectionById(1);
        this._coverFlow.setAdapter(new ImageAdapter(this, this._imageTab));
        ImageAdapter coverImageAdapter =  new ImageAdapter(this, this._imageTab);

        coverImageAdapter.createReflectedImages();

        this._coverFlow.setAdapter(coverImageAdapter);

        this._coverFlow.setSpacing(-25);
        this._coverFlow.setSelection(4, true);
        this._coverFlow.setAnimationDuration(1000);
        TextView txt = (TextView) findViewById(R.id.desc);
        txt.setText("Video: Welcome ! - Null");

        galleryListener();
        addButtonListener();
    }

    public void addButtonListener()
    {
        Button button = (Button) findViewById(R.id.buttonPlay);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent nextLayout = new Intent(Selection.this, Player.class);
                startActivity(nextLayout);
            }
        });
    }
    public void getSelectionById(int id)
    {
        switch (id) {
            case 1:
                getScienceList();
                break;
            case 2:
                getBiologyList();
                break;
            case 3:
                getSocialScienceList();
                break;
            case 4:
                getCulturalList();
                break;
            default:
        }
    }

    public void getScienceList()
    {
        this._imageTab = new Integer[5];
        for (int i = 0; i < this._imageTab.length; i++)
        {
            this._imageTab[i] = R.drawable.logo;
        }
    }

    public void getBiologyList()
    {
        this._imageTab = new Integer[5];
        for (int i = 0; i < this._imageTab.length; i++)
        {
            this._imageTab[i] = i;
        }
    }

    public void getSocialScienceList()
    {
        this._imageTab = new Integer[5];
        for (int i = 0; i < this._imageTab.length; i++)
        {
            this._imageTab[i] = i;
        }
    }

    public void getCulturalList()
    {
        this._imageTab = new Integer[5];
        for (int i = 0; i < this._imageTab.length; i++)
        {
            this._imageTab[i] = i;
        }
    }

    public void galleryListener()
    {
       this._coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               System.out.println(position);
           }
       });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selection, menu);
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
