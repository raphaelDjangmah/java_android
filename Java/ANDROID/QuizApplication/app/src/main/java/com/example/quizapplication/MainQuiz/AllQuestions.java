package com.example.quizapplication.MainQuiz;

import com.example.quizapplication.RawQuestions.BiologyEasy;
import com.example.quizapplication.RawQuestions.ICTEasy;
import com.example.quizapplication.RawQuestions.MathEasy;

public class AllQuestions {

    private Question[] allQuestion = new Question[loopLength()];
    private int loopCounter =0;

    public Question[] returnQuestions() {

        setQuestions(BiologyEasy.allQuestions());
        setQuestions(ICTEasy.allQuestions());
        setQuestions(MathEasy.allQuestions());

        return allQuestion;
    }

    private void setQuestions(Question[] questions){

        for(int x=0; x<questions.length; x++){
            Question currentQuestion = new Question();
            currentQuestion.setQuestion(questions[x].getQuestion());
            currentQuestion.setOptionA(questions[x].getOptionA());
            currentQuestion.setOptionB(questions[x].getOptionB());
            currentQuestion.setOptionC(questions[x].getOptionC());
            currentQuestion.setOptionD(questions[x].getOptionD());
            currentQuestion.setCategory(questions[x].getCategory());
            currentQuestion.setAnswerNr(questions[x].getAnswerNr());
            currentQuestion.setDifficulty(questions[x].getDifficulty());

            allQuestion[loopCounter] = currentQuestion;
            loopCounter++;
        }

    }

    private int loopLength(){
        return BiologyEasy.allQuestions().length +
                MathEasy.allQuestions().length +
                ICTEasy.allQuestions().length;
    }
}