package com.example.quizapplication.MainQuiz;

import android.provider.BaseColumns;

public final class QuizDatabaseDetails {

    private QuizDatabaseDetails(){}

    public static final class QuestionTable implements BaseColumns {

        public static final String TABLE_NAME      = "QuizTable";
        public static final String COLUMN_QUESTION = "question";
        public static final String OPTIONA_COLUMN  = "optionA";
        public static final String OPTIONB_COLUMN  = "optionB";
        public static final String OPTIONC_COLUMN  = "optionC";
        public static final String OPTIOND_COLUMN  = "optionD";
        public static final String ANSWER_NR       = "Answer_Number";
        public static final String DIFFICULTY_LEVEL = "Difficulty_Level";
        public static final String CATEGORY        = "category";


    }

}
