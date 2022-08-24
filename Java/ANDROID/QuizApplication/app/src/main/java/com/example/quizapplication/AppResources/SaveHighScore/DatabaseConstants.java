package com.example.quizapplication.AppResources.SaveHighScore;

import android.provider.BaseColumns;

public class DatabaseConstants {

    private DatabaseConstants() {
    }

    public class TableDetails implements BaseColumns {
        public static final String DATABASE_NAME = "SaveHighScore";
        public static final String TABLE_NAME = "HighScore";
        public static final String COLUMN_DIFFICULTY = "difficulty";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_HIGHSCORE = "highscore";
    }


    public static class TableConstants {

        // difficulty constants
        public static final String DIFFICULTY_EASY = "Easy";
        public static final String DIFFICULTY_MEDIUM = "Medium";
        public static final String DIFFICULTY_HARD = "Hard";

        public String[] difficulties() {
            return new String[]{DIFFICULTY_EASY, DIFFICULTY_MEDIUM, DIFFICULTY_HARD};
        }

        // subject constants
        public static final String SUBJECT_PHYSICS = "Physics";
        public static final String SUBJECT_MATHS = "Maths";
        public static final String SUBJECT_ICT = "ICT";
        public static final String SUBJECT_BIOLOGY = "Biology";

        public String[] subjects() {
            return new String[]{SUBJECT_BIOLOGY, SUBJECT_PHYSICS, SUBJECT_MATHS, SUBJECT_ICT};
        }

    }


}
