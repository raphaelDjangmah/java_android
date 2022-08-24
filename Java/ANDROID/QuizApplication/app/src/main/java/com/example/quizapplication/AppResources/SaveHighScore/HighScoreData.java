package com.example.quizapplication.AppResources.SaveHighScore;

public class HighScoreData {
    private int Highscore;
    private String category;
    private String difficulty;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public HighScoreData(String difficulty, String category, int highscore) {
        Highscore = highscore;
        this.category = category;
        this.difficulty = difficulty;
    }

    public HighScoreData() {
    }

    public int getHighscore() {
        return Highscore;
    }

    public void setHighscore(int highscore) {
        Highscore = highscore;
    }
}
