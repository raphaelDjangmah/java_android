package com.example.quizapplication.AppResources.SaveHighScore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.quizapplication.AppResources.SaveHighScore.DatabaseConstants.TableConstants;
import com.example.quizapplication.AppResources.SaveHighScore.DatabaseConstants.TableDetails;

public class DatabaseManagement extends SQLiteOpenHelper {

    private static String DATABASE_NAME = TableDetails.DATABASE_NAME;
    private static int DATABASE_VERSION = 1;
    private SQLiteDatabase db;


    public DatabaseManagement(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_TABLE = "CREATE TABLE " + TableDetails.TABLE_NAME + " (" +
                TableDetails._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TableDetails.COLUMN_DIFFICULTY + " TEXT, " +
                TableDetails.COLUMN_CATEGORY + " TEXT, " +
                TableDetails.COLUMN_HIGHSCORE + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_TABLE);

        fillInitials();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableDetails.TABLE_NAME);
        onCreate(db);
    }

    private void fillInitials() {

        ContentValues values = new ContentValues();
        TableConstants table = new TableConstants();

        for(int x=0; x<table.difficulties().length; x++){
            for(int y=0; y<table.subjects().length;y++){
                values.put(TableDetails.COLUMN_DIFFICULTY, table.difficulties()[x]);
                values.put(TableDetails.COLUMN_CATEGORY, table.subjects()[y]);
                values.put(TableDetails.COLUMN_HIGHSCORE, 0);

                db.insert(TableDetails.TABLE_NAME, null, values);
            }
        }

    }

    public void updateHighScore(String difficulty, String category, int newScore) {

        db = getWritableDatabase();

        HighScoreData data = new HighScoreData(difficulty,category,newScore);

        ContentValues update = new ContentValues();
        update.put(TableDetails.COLUMN_HIGHSCORE, data.getHighscore());

        String[] updateArgs = new String[]{difficulty, category};

        db.update(TableDetails.TABLE_NAME, update,
                TableDetails.COLUMN_DIFFICULTY + " = ?" +
                        " AND " + TableDetails.COLUMN_CATEGORY + " =? ", updateArgs);

    }

    public int getHighScore(String difficulty, String category){

        int highscore =0;
        db = getReadableDatabase();

        String[] selectionArgs = new String[]{difficulty, category};
        final String SELECTION_QUERY = "SELECT * " +
                                        " FROM " + TableDetails.TABLE_NAME +
                                        " WHERE " + TableDetails.COLUMN_DIFFICULTY + " = ? " +
                                        " AND " + TableDetails.COLUMN_CATEGORY + " = ? ";

        Cursor selection = db.rawQuery(SELECTION_QUERY, selectionArgs);

        if(selection.moveToFirst()){
            HighScoreData data = new HighScoreData();
            data.setHighscore(selection.getInt(selection.getColumnIndex(TableDetails.COLUMN_HIGHSCORE)));
            highscore = data.getHighscore();
        }

        return highscore;
    }


}
