package com.example.personalworkouttimer.ProjectResources;

public class RestartTimer
{

    private int initMinutes;
    private int initHours;
    private int initSeconds;

    public RestartTimer(int initHours, int initMinutes, int initSeconds) {
        this.initMinutes = initMinutes;
        this.initHours = initHours;
        this.initSeconds = initSeconds;
    }

    public int getInitMinutes() {
        return initMinutes;
    }

    public void setInitMinutes(int initMinutes) {
        this.initMinutes = initMinutes;
    }

    public int getInitHours() {
        return initHours;
    }

    public void setInitHours(int initHours) {
        this.initHours = initHours;
    }

    public int getInitSeconds() {
        return initSeconds;
    }

    public void setInitSeconds(int initSeconds) {
        this.initSeconds = initSeconds;
    }
}
