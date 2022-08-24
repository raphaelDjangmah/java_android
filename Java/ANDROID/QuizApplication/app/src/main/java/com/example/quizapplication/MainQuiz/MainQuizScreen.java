package com.example.quizapplication.MainQuiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapplication.R;
import com.example.quizapplication.Resources.MyCountDown;
import com.example.quizapplication.Resources.MyMusicPlayer;

import java.util.Collections;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class MainQuizScreen extends AppCompatActivity {

    List<Question> questionList;
    TextView tvHighscore, tvQuestion, tvTimerSeconds, tvTimerMinutes, tvDifficulty;
    TextView tvScore, tvQuestionCount;
    Button confirm_answer;
    RadioButton rb1, rb2, rb3, rb4;
    ColorStateList radioTextColor, timerColor;
    RadioGroup radioGroup;
    private int questionCount, questionCountTotal;
    private int score;
    private boolean answered;
    private Question currentQuestion;
    public static final String SCORE = "score";
    private MyCountDown myCountDown;
    private CountDownTimer timer;
    private MyMusicPlayer timerSound;
    private boolean timeUp;
    private boolean isLastQuestion;

    /* this method helps to find the id's of the widgets in our xml file

     * */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_screen_activity);

        tvScore = findViewById(R.id.score);
        tvQuestionCount = findViewById(R.id.question_count);
        radioGroup = findViewById(R.id.radio_group);
        tvHighscore = findViewById(R.id.highscore);
        tvQuestion = findViewById(R.id.question);
        tvTimerSeconds = findViewById(R.id.timer_seconds);
        tvTimerMinutes = findViewById(R.id.timer_minutes);
        tvDifficulty = findViewById(R.id.show_difficulty);
        confirm_answer = findViewById(R.id.confirm);
        rb1 = findViewById(R.id.option_1);
        rb2 = findViewById(R.id.option_2);
        rb3 = findViewById(R.id.option_3);
        rb4 = findViewById(R.id.option_4);
        radioTextColor = rb1.getTextColors();
        timerColor = tvTimerSeconds.getTextColors();
        timerSound = new MyMusicPlayer(this, R.raw.police_wistle);
        DatabaseHelper database = new DatabaseHelper(this);

        Intent intent = getIntent();
        String difficulty = intent.getStringExtra(HomeScreen.DIFFICULTY_LEVEL);
        String category = intent.getStringExtra(HomeScreen.CATEGORY);
        tvDifficulty.setText("Difficulty : " + difficulty);
        questionList = database.getQuestionWithSpecialities(difficulty,category);
        questionCountTotal = questionList.size();
        checkNoQuestion(questionCountTotal);

        Collections.shuffle(questionList);

        showNextQuestion();

        confirm_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!answered) {

                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();

                    } else if (timeUp) {
                        showNextQuestion();
                    } else {
                        Toasty.error(MainQuizScreen.this, "Select An Answer First", Toast.LENGTH_LONG).show();;
                    }

                }else if(isLastQuestion){
                    endQuiz();

                } else {
                    showNextQuestion();
                }


            }
        });

    }

    private void checkAnswer() {

        answered = true;

        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());

        int solution_nr = radioGroup.indexOfChild(rbSelected) + 1;

        if (solution_nr == currentQuestion.getAnswerNr()) {
            score++;
            tvScore.setTextColor(Color.RED);
            tvScore.setText(score + "");
            tvQuestion.setTextColor(Color.rgb(21, 111, 48));
            tvQuestion.setText("CORRECT");
            tvQuestion.setTextSize(50);

        } else if (timeUp && (!rb1.isChecked() && !rb2.isChecked() && !rb3.isChecked() && !rb4.isChecked()) ) {
            tvQuestion.setTextColor(Color.rgb(230, 70, 20));
            tvQuestion.setTextSize(50);
            tvQuestion.setText("TIME UP");

            radioGroup.check(returnIdOfRadioButton(currentQuestion.getAnswerNr()));
            timeUp = false;
        } else {
            tvQuestion.setTextColor(Color.rgb(215, 0, 0));
            tvQuestion.setTextSize(50);
            tvQuestion.setText("WRONG");

        }

        showSolution();


    }


    // Method showSolution shows solution unto the screen and set the color to the radio button with the color green

    private void showSolution() {

        timer.cancel();

        stopSound();

        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()) {

            case 1:
                rb1.setTextColor(Color.GREEN);
                break;

            case 2:
                rb2.setTextColor(Color.GREEN);
                break;

            case 3:
                rb3.setTextColor(Color.GREEN);
                break;

            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }


        if (questionCount < questionCountTotal) {
            confirm_answer.setText("NEXT");

        } else {
            confirm_answer.setText("FINISH");
        }
    }

    // we reset the color of the radio button and show the next question to the screen

    public void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(radioTextColor);
        rb2.setTextColor(radioTextColor);
        rb3.setTextColor(radioTextColor);
        rb4.setTextColor(radioTextColor);
        tvQuestion.setTextColor(Color.BLACK);
        tvQuestion.setTextSize(25);
        tvQuestion.setPadding(10, 10, 10, 10);
        tvTimerSeconds.setTextColor(timerColor);
        myCountDown = new MyCountDown(0, 0, 20);
        startCountdown();

        if (questionCount < questionCountTotal) {

            currentQuestion = questionList.get(questionCount);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOptionA());
            rb2.setText(currentQuestion.getOptionB());
            rb3.setText(currentQuestion.getOptionC());
            rb4.setText(currentQuestion.getOptionD());
            questionCount++;
            tvQuestionCount.setText("Question : " + questionCount + "/" + questionCountTotal);
            answered = false;
            confirm_answer.setText("Answer");

            if(questionCount == questionCountTotal){
                isLastQuestion = true;
            }
        }

    }


    private void checkNoQuestion(int x){
        if(x==0){
            Toasty.info(this,"No Questions", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    // we end the quiz if the questions are finished

    public void endQuiz() {

        String message;

        if (score <= HomeScreen.highScore && score <= 3) {
            message = "Hey Geek You scored " + score + " Out of " + questionCountTotal;
        } else {
            message = "Wow Buddy\nNEW HIGHSCORE RECOREDED\nYou Scored " + score + " Out of " + questionCountTotal;
        }

        showAlert(message);
    }


    // showAlert help to build an alertDialog
    private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent resultIntent = new Intent();
                            resultIntent.putExtra(SCORE, score);
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    }
                }).setCancelable(false);

        AlertDialog alert = builder.create();
        alert.show();
    }

    //Countdown to time the questions

    private void startCountdown() {

        timer = new CountDownTimer(myCountDown.getTimeLeft(), 1000) {
            @Override
            public void onTick(long timeNow) {
                myCountDown.setTimeLeft(timeNow);
                myCountDown.timeUpdater();
                timerUpdater();
            }

            @Override
            public void onFinish() {
                timeUp = true;
                checkAnswer();
            }
        }.start();

    }

    private void timerUpdater() {

        String timeString = String.valueOf(myCountDown.getSeconds());

        if (myCountDown.getSeconds() < 10) {

            if (myCountDown.getSeconds() == 1) {
                startSound();
            }
            timeString = "0".concat(timeString);
            tvTimerSeconds.setTextColor(Color.RED);
        }


        tvTimerSeconds.setText(timeString);

    }

    private int returnIdOfRadioButton(int answerNumber) {
        switch (answerNumber) {
            case 1:
                return rb1.getId();
            case 2:
                return rb2.getId();
            case 3:
                return rb3.getId();
            case 4:
                return rb4.getId();

            default:
                return 0;
        }
    }

    // MUSIC PLAYER CLASS
    private void startSound() {
        timerSound = new MyMusicPlayer(this, R.raw.police_wistle);
        timerSound.play();
    }

    private void stopSound() {
        timerSound.stop();
    }


    // WHEN THE USER PRESSES THE BACK BUTTON WHEN THE APP IS IN PROGRESS
    @Override
    public void onBackPressed() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("You are leaving the app\nAll data will be lost.\nContinue Anyways?").
                setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        timer.cancel();
                        stopSound();
                        finish();
                    }
                }).
                setNegativeButton("NO", null).
                setCancelable(true);

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        stopSound();
        finish();
    }
}

