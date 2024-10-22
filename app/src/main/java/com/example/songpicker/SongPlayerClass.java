package com.example.songpicker;

import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.songpicker.R.raw;

public class SongPlayerClass extends AppCompatActivity {
    private static MediaPlayer player;

    public void play(int i) {
        if (player != null) {
            player.stop();
        }
        switch (i) {
            case 1:
                player = MediaPlayer.create(SongPlayerClass.this, R.raw.a_force_addiction);
                break;
            case 2:
                player = MediaPlayer.create(SongPlayerClass.this, R.raw.b_parry_addiction);
                break;
            case 3:
                player = MediaPlayer.create(SongPlayerClass.this, R.raw.c_crash_addiction);
                break;
            case 4:
                player = MediaPlayer.create(SongPlayerClass.this, raw.d_recieve_you);
                break;
            case 5:
                player = MediaPlayer.create(SongPlayerClass.this, raw.e_one_eyed_assassin);
                break;
            case 6:
                player = MediaPlayer.create(SongPlayerClass.this, raw.f_one_eyed_dancer);
                break;
            case 7:
                player = MediaPlayer.create(SongPlayerClass.this, raw.g_one_eyed_slugger);
                break;
            case 8:
                player = MediaPlayer.create(SongPlayerClass.this, raw.h_reign);
                break;
            default:
                break;
        }
        player.start();
    }
}
