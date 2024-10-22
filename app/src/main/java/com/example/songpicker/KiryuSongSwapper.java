package com.example.songpicker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class KiryuSongSwapper extends AppCompatActivity {
    /**
     * initial variable and constants setup
     */
    private int currentSong = 0;

    private boolean isPlaying = false;

    private static MediaPlayer player;
    private ImageButton legend;
    private ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiryu_song_swapper);
        isPlaying = false;
        /**
         * setup background secret
         */
        background = (ImageView) findViewById(R.id.kiryuBg);
        legend = (ImageButton) findViewById(R.id.Legend);
        legend.setBackground(null);
        /**
         * secret ( ͡° ͜ʖ ͡°)
         */
        legend.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                playLegend();
                return false;
            }
        });
    }

    /**
     * button triggers
     * @param v
     */
    public void playBrawler(View v) {
        playCheck(1);
        legendCheck(false);
    }

    public void playRush(View v) {
        playCheck(2);
        legendCheck(false);
    }

    public void playBeast(View v) {
        playCheck(3);
        legendCheck(false);
    }

    public void playLegend(){
        playCheck(4);
        legendCheck(true);
    }

    /**
     * Checks if the same song is playing. If it is, pause the music instead.
     * @param song
     */
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

    /**
     * terrible switch statement that definitely could be in another class if I could get it to work.
     * Changes the music.
     * @param i
     */
    public void play(int i) {
            if (player != null) {
                isPlaying = true;
                player.stop();
            }
            switch (i) {
                case 1:
                    player = MediaPlayer.create(KiryuSongSwapper.this, R.raw.a_force_addiction);
                    isPlayCheck(7230);
                    break;
                case 2:
                    player = MediaPlayer.create(KiryuSongSwapper.this, R.raw.b_parry_addiction);
                    isPlayCheck(7020);
                    break;
                case 3:
                    player = MediaPlayer.create(KiryuSongSwapper.this, R.raw.c_crash_addiction);
                    isPlayCheck(4835);
                    break;
                case 4:
                    player = MediaPlayer.create(KiryuSongSwapper.this, R.raw.d_recieve_you);
                    break;
                default:
                    break;
            }
        player.start();
    }

    /**
     * Checks if song is currently playing. If song is currently playing, skip to the "active" portion of the song
     */
    public void isPlayCheck(int milli){
        if (isPlaying){
            player.seekTo(milli);
        } else{
            player.seekTo(0);
        }
    }

    /**
     * Changes the background from black and white to full color when Legend mode is active.
     * @param isLegend
     */
    public void legendCheck(boolean isLegend){
        if(isLegend){
            background.setImageResource(R.drawable.kiryu_c);
        }else{
            background.setImageResource(R.drawable.kiryu_bw);
        }
    }

    /**
     * stops music and switches character
     * @param v
     */
    public void majimaSwap(View v){
        //checks if player is playing music - if it is, stop the music.
        if (player != null) {
            player.stop();
        }
        Intent majimaSwap = new Intent(this,  MajimaSongSwapper.class);
        majimaSwap.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(majimaSwap, 0);
        overridePendingTransition(0, 0);
    }
}
