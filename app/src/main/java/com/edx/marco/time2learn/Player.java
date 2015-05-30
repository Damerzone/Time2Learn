package com.edx.marco.time2learn;

import android.media.AudioManager;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;


public class Player extends ActionBarActivity {

    public MediaPlayer player = new MediaPlayer();
    private VideoView myVideoView;
    private int position = 0;
    private ProgressDialog progressDialog;
    private MediaController mediaControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        myVideoView = (VideoView) findViewById(R.id.videoView);

        progressDialog = new ProgressDialog(Player.this);
        progressDialog.setTitle("Time2Learn");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        try {
            if (mediaControls == null) {
                mediaControls = new MediaController(Player.this);
            }
            myVideoView.setMediaController(mediaControls);

            //set the uri of the video to be played
            myVideoView.setVideoURI(Uri.parse("https://s3.amazonaws.com/edx-course-videos/edx-edx101/EDXSPCPJSP13-H010000_100.mp4"));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        myVideoView.requestFocus();
        //we also set an setOnPreparedListener in order to know when the video file is ready for playback

        myVideoView.setOnPreparedListener(new OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                // close the progress bar and play the video
                progressDialog.dismiss();
                //if we have a position on savedInstanceState, the video playback should start from here
                myVideoView.seekTo(position);
                myVideoView.start();
            }
        });

       // play();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void stop() {
        Toast.makeText(getApplicationContext(), "Stop...", Toast.LENGTH_SHORT).show();
        if (player.isPlaying()) {
            player.stop();
        }
    }

    public void play() {
        if (player.isPlaying()) {
            Toast.makeText(getApplicationContext(), "Exec !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Preparation...", Toast.LENGTH_SHORT).show();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setAudioStreamType(AudioManager.STREAM_NOTIFICATION);
            try {
                player.setDataSource(this, Uri.parse("https://s3.amazonaws.com/edx-course-videos/edx-edx101/EDXSPCPJSP13-H010000_100.mp4"));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                player.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
