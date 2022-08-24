package com.example.quizapplication.Resources;

public class MyCountDown{

    /**
     * CLASS DECLARATIONS TO PROVIDE US WITH ALL WE NEED
     * 1 millis = 1000 normal seconds
     * therefore 60,000ms means one minute
     * timeLeft will give us the value of the countdown in millis after every second
     * startRunning will determine if the countdown is already running
     */
    private int hours;
    private int minutes;
    private int seconds;
    private long timeLeft;
    private final int oneMinuteInMillis = 60000;
    private final int oneSecondInTenseMillis = 1000;
    private final long oneHourInMillis = 3600000;


    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setHours() {
        hours = (int) ((int)getTimeLeft()/oneHourInMillis);
    }

    public void setMinutes() {
         minutes = (int)getTimeLeft()%(int)oneHourInMillis / oneMinuteInMillis;
    }

    public void setSeconds() {
        seconds = (int)getTimeLeft()%oneMinuteInMillis / oneSecondInTenseMillis;
    }

    public MyCountDown(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        setTimeLeft((hours * oneHourInMillis) + (minutes * oneMinuteInMillis) + (seconds*oneSecondInTenseMillis));

        timeUpdater();
    }

    public void timeUpdater(){
        setHours();
        setMinutes();
        setSeconds();
    }

}
