package com.example.personalworkouttimer.ProjectResources;

public class MyCountdown
{
    private int hours, minutes, seconds;
    public static final long ONESECONDINMILLIS = 1000;
    public static final long ONEMINUTEINMILLIS = 60000;
    public static final long ONEHOURINMILLIS   = 3600000;
    private long timeLeft;

    public MyCountdown(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        setTimeLeft((hours*ONEHOURINMILLIS)+ (minutes*ONEMINUTEINMILLIS) + (seconds*ONESECONDINMILLIS));
        updateVariables();
    }

    public int getHours() {
        return hours;
    }

    public void setHours() {
        hours = (int) ((int)getTimeLeft()/ONEHOURINMILLIS);
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes() {
        minutes = (int) (getTimeLeft()%ONEHOURINMILLIS / ONEMINUTEINMILLIS);
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds() {
        seconds = (int) (getTimeLeft() % ONEMINUTEINMILLIS / ONESECONDINMILLIS);
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }


    //we update the variables inside the setter functions

    public void updateVariables(){
        setHours();
        setMinutes();
        setSeconds();

    }

}
