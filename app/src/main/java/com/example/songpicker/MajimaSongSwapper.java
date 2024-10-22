package com.example.songpicker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MajimaSongSwapper extends AppCompatActivity {

    private int currentSong = 0;

    private boolean isPlaying = false;

    private static MediaPlayer player;
    private ImageButton legend;
    private ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majima_song_swapper);
        isPlaying = false;

        background = (ImageView) findViewById(R.id.majimaBg);
        legend = (ImageButton) findViewById(R.id.Legend);
        legend.setBackground(null);

        legend.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                playLegend();
                return false;
            }
        });
    }

    public void playThug(View v) {
        playCheck(1);
        legendCheck(false);
    }


    public void playBreaker(View v) {
        playCheck(2);
        legendCheck(false);
    }


    public void playSlugger(View v) {
        playCheck(3);
        legendCheck(false);
    }

    public void playLegend(){
        playCheck(4);
        legendCheck(true);
    }

    public void playCheck(int song){
        if(song != currentSong){
            play(song);
            currentSong = song;
        }else{
            player.stop();
            player = null;
            isPlaying = false;
            currentSong = 0;
        }
    }

    public void play(int i) {
        if (player != null) {
            isPlaying = true;
            player.stop();
        }
        switch (i) {
            case 1:
                player = MediaPlayer.create(MajimaSongSwapper.this, R.raw.e_one_eyed_assassin);
                isPlayCheck(5500);
                break;
            case 2:
                player = MediaPlayer.create(MajimaSongSwapper.this, R.raw.f_one_eyed_dancer);
                isPlayCheck(6240);
                break;
            case 3:
                player = MediaPlayer.create(MajimaSongSwapper.this, R.raw.g_one_eyed_slugger);
                isPlayCheck(7360);
                break;
            case 4:
                player = MediaPlayer.create(MajimaSongSwapper.this, R.raw.h_reign);
                isPlayCheck(11685);
                break;
            default:
                break;
        }
        player.start();
    }

    public void isPlayCheck(int milli){
        if (isPlaying){
            player.seekTo(milli);
        } else{
            player.seekTo(0);
        }
    }

    public void legendCheck(boolean isLegend){
        if(isLegend){
            background.setImageResource(R.drawable.majima_c);
        }else{
            background.setImageResource(R.drawable.majima_bw);
        }
    }

    public void kiryuSwap(View v){
        isPlaying = false;
        if (player != null) {
            player.stop();
        }
        Intent kiryuSwap = new Intent(this,  KiryuSongSwapper.class);
        kiryuSwap.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(kiryuSwap, 0);
        overridePendingTransition(0, 0);
    }
}