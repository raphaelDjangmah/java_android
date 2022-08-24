package com.example.quizapplication.MainQuiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.AppResources.RateApp;
import com.example.quizapplication.AppResources.SaveHighScore.DatabaseManagement;
import com.example.quizapplication.R;

public class HomeScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener { //we implement to use the select listener in  the spinner

    TextView tvHighscore;
    Button startQuiz;
    public static int highScore;
    private final int REQUEST_CODE = 1;
    public static final String DIFFICULTY_LEVEL = "difficulty";
    public static final String CATEGORY = "category";
    private DatabaseManagement database;
    private Spinner difficulty_dropdown, categories_dropdown;  // our difficulty difficulty_dropdown selector

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_activity);

        startQuiz = (Button) findViewById(R.id.start_quiz);
        tvHighscore = (TextView) findViewById(R.id.highscore);
        difficulty_dropdown = (Spinner) findViewById(R.id.difficulty_dropdown);
        categories_dropdown = findViewById(R.id.category_dropdown);

        database = new DatabaseManagement(this);

        final String[] difficultyLevels = Question.getDifficultyLevel();
        final String[] categories = Question.getAllCategories();
        setDropDownAttributes(difficulty_dropdown, difficultyLevels);
        setDropDownAttributes(categories_dropdown, categories);

        loadHighScore(getDifficulty(), getCategory());
        highScore = database.getHighScore(getDifficulty(),getCategory());
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, MainQuizScreen.class);
                intent.putExtra(DIFFICULTY_LEVEL, difficulty_dropdown.getSelectedItem().toString());
                intent.putExtra(CATEGORY, categories_dropdown.getSelectedItem().toString());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MainQuizScreen.RESULT_OK) {
                int newScore = data.getIntExtra(MainQuizScreen.SCORE, 0);

                if (newScore > database.getHighScore(getDifficulty(), getCategory())) {

                    updateHighScore(getDifficulty(),  getCategory(), newScore);

                }
            }
        }
        loadHighScore(getDifficulty(),getCategory());
    }

    private void updateHighScore(String difficulty, String category, int highscore) {
        database.updateHighScore(difficulty, category, highscore);
        highScore = database.getHighScore(difficulty,category);
    }

    private void loadHighScore(String difficulty, String category) {
        tvHighscore.setText("HighScore : " + (database.getHighScore(difficulty, category)));
    }


    /**
     * we are adding a menu to the rating bar
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rateAppMenu:
                startActivity(new Intent(this, RateApp.class));
                break;
            case R.id.resetHighscore:
                resetHighScore();
                break;
        }

        return true;
    }

    /**
     * This method assigns a listener and an adapter to fetch the difficulty levels of the Spinner
     */

    private void setDropDownAttributes(Spinner dropdown, String[] difficultyLevels) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, difficultyLevels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
    }

    /**
     * We reset the highscore and the shared preferences when the user resets the highscore in a
     * particular difficulty state
     */
    private void resetHighScore() {

        updateHighScore(getDifficulty(), getCategory(), 0);
        loadHighScore(getDifficulty(), getCategory());

     }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        getDifficulty();
        getCategory();
        loadHighScore(difficulty_dropdown.getSelectedItem().toString(), categories_dropdown.getSelectedItem().toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public String getDifficulty(){
        return difficulty_dropdown.getSelectedItem().toString();
    }

    public String getCategory(){
        return categories_dropdown.getSelectedItem().toString();
    }

}
