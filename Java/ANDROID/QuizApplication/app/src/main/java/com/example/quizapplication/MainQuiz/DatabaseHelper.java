package com.example.quizapplication.MainQuiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quizapplication.MainQuiz.QuizDatabaseDetails.QuestionTable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DbQuestions";
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_QUESTION_TABLE =
                "CREATE TABLE " + QuestionTable.TABLE_NAME + "( " +
                        QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        QuestionTable.COLUMN_QUESTION + " TEXT, " +
                        QuestionTable.OPTIONA_COLUMN + " TEXT, " +
                        QuestionTable.OPTIONB_COLUMN + " TEXT, " +
                        QuestionTable.OPTIONC_COLUMN + " TEXT, " +
                        QuestionTable.OPTIOND_COLUMN + " TEXT, " +
                        QuestionTable.ANSWER_NR + " INTEGER, " +
                        QuestionTable.DIFFICULTY_LEVEL + " TEXT, " +
                        QuestionTable.CATEGORY + " TEXT " +
                        ")";

        db.execSQL(SQL_QUESTION_TABLE);
        createQuestion();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    public void addQuestion(Question[] question) {

        for (int x = 0; x < question.length; x++) {

            ContentValues cv = new ContentValues();
            cv.put(QuestionTable.COLUMN_QUESTION, question[x].getQuestion());
            cv.put(QuestionTable.OPTIONA_COLUMN, question[x].getOptionA());
            cv.put(QuestionTable.OPTIONB_COLUMN, question[x].getOptionB());
            cv.put(QuestionTable.OPTIONC_COLUMN, question[x].getOptionC());
            cv.put(QuestionTable.OPTIOND_COLUMN, question[x].getOptionD());
            cv.put(QuestionTable.ANSWER_NR, question[x].getAnswerNr());
            cv.put(QuestionTable.DIFFICULTY_LEVEL, question[x].getDifficulty());
            cv.put(QuestionTable.CATEGORY, question[x].getCategory());

            db.insert(QuestionTable.TABLE_NAME, null, cv);
        }
    }

    private void createQuestion() {

        AllQuestions get = new AllQuestions();
        Question[] arrayOfQuestions= get.returnQuestions();
        addQuestion(arrayOfQuestions);


    }

    public ArrayList<Question> getQuestions() {
        ArrayList<Question> questionsList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOptionA(cursor.getString(cursor.getColumnIndex(QuestionTable.OPTIONA_COLUMN)));
                question.setOptionB(cursor.getString(cursor.getColumnIndex(QuestionTable.OPTIONB_COLUMN)));
                question.setOptionC(cursor.getString(cursor.getColumnIndex(QuestionTable.OPTIONC_COLUMN)));
                question.setOptionD(cursor.getString(cursor.getColumnIndex(QuestionTable.OPTIOND_COLUMN)));
                question.setAnswerNr(cursor.getInt(cursor.getColumnIndex(QuestionTable.ANSWER_NR)));
                question.setDifficulty(cursor.getString(cursor.getColumnIndex(QuestionTable.DIFFICULTY_LEVEL)));
                question.setCategory(cursor.getString(cursor.getColumnIndex(QuestionTable.CATEGORY)));
                questionsList.add(question);

            } while (cursor.moveToNext());
        }

        cursor.close();

        return questionsList;
    }


    public ArrayList<Question> getQuestionWithSpecialities(String difficulty, String category) {
        ArrayList<Question> questionsList = new ArrayList<>();
        db = getReadableDatabase();

        String databaseQuery = "SELECT * FROM " + QuestionTable.TABLE_NAME + " WHERE " +
                QuestionTable.DIFFICULTY_LEVEL + " = ? " + " AND " +
                QuestionTable.CATEGORY + " = ?";
        String[] selectionArgs = new String[]{difficulty, category};
        Cursor cursor = db.rawQuery(databaseQuery, selectionArgs);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOptionA(cursor.getString(cursor.getColumnIndex(QuestionTable.OPTIONA_COLUMN)));
                question.setOptionB(cursor.getString(cursor.getColumnIndex(QuestionTable.OPTIONB_COLUMN)));
                question.setOptionC(cursor.getString(cursor.getColumnIndex(QuestionTable.OPTIONC_COLUMN)));
                question.setOptionD(cursor.getString(cursor.getColumnIndex(QuestionTable.OPTIOND_COLUMN)));
                question.setAnswerNr(cursor.getInt(cursor.getColumnIndex(QuestionTable.ANSWER_NR)));
                question.setDifficulty(cursor.getString(cursor.getColumnIndex(QuestionTable.DIFFICULTY_LEVEL)));
                question.setCategory(cursor.getString(cursor.getColumnIndex(QuestionTable.CATEGORY)));
                questionsList.add(question);

            } while (cursor.moveToNext());
        }

        cursor.close();

        return questionsList;
    }


}
