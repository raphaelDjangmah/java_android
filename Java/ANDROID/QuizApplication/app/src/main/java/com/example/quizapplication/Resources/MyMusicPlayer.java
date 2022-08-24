package com.example.quizapplication.Resources;

import android.content.Context;
import android.media.MediaPlayer;

public class MyMusicPlayer {

    private MediaPlayer player;
    private Context context;
    private int file;

    /**
     *<p> This class helps us to create a music player </p>
     *<p> method isRunning and setState are a getter and setter for the toggler variable to check if the app is already running or not</p>
     *<p>
     * method checkState checks the toggler and if its true, it calls the play method
     * meaning the user wants to play
     * And calls the pause method if toggler is false
     * The stop function is called whenever we want to stop the player
     * </p>
     */

    public MyMusicPlayer(Context context, int file){
        this.context = context;
        this.file = file;
    }



    public void pause(){
        if(player != null){
            player.pause();
        }
    }

    public void play(){
        if(player == null){
            player = MediaPlayer.create(context, file);
        }else {
            System.out.println("An error occured");
        }

        player.start();
    }



    public void stop(){
        if(player != null){
            player.release();
            player = null;
          }
    }
}
