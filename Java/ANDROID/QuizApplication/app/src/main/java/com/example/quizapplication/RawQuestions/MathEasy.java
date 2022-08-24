package com.example.quizapplication.RawQuestions;

import com.example.quizapplication.AppResources.SaveHighScore.DatabaseConstants;
import com.example.quizapplication.MainQuiz.Question;

public class MathEasy {

    /**
     * <P>All Easy biology questions with their answers will be saved here</P>
     * @return <Span>Returns a String array containing all the questions</Span>
     *
     */


    private final String DIFFICUTY = DatabaseConstants.TableConstants.DIFFICULTY_EASY;
    private final String SUBJECT = DatabaseConstants.TableConstants.SUBJECT_MATHS;


    public static Question[] allQuestions(){

        return getQuestions();

    }


    private static String[] setQuestion() {

        String[] newQuestion = new String[]{
                "What is the square root of 4",
                "what is 0!",
                "Find x in the equation x+2! = 4",
                "What is the square of 0",
                "Solve for x in the equation x+y =1 ",
                "Solve log(100)",
                "What does 2! means",
                "Find the value of m-2n if n = log(8) to the base 2",
                "If the length of sum of two sides of a square is 12cm,\nWhat will the area of the square",
                "if the square root of 0 is undefined, What will be the square root of 01 ?"
        };

        return newQuestion;
    }

    private static String[][] options() {
        String[][] options =
                {
                        {"8", "4", "2", "16"},
                        {"0", "1", "0.1", "None of the above"},
                        {"2!", "1", "0","2"},
                        {"0","1","it depends", "Non of the above"},
                        {"x+1", "y+1", "y-1", "1-y"},
                        {"10", "1", "100", "Undefined"},
                        {"2x1x0", "2x1", "2x2x1", "2x2x1x0"},
                        {"m-3", "m-6", "3","m-2(log8)"},
                        {"144","24","36","6"},
                        {"Undefined","1","0","None of the above"},
                };

        return options;
    }

    private static int[] answerNumber() {
        int[] answer_number = {2,1,4,1,4,1,2,2,3,1};
        return answer_number;
    }



    private static Question[] getQuestions() {

        Question[] questions = new Question[setQuestion().length];


        for (int x = 0; x <questions.length; x++) {
            Question currentQuestion = new Question();
            currentQuestion.setQuestion(setQuestion()[x]);
            currentQuestion.setAnswerNr(answerNumber()[x]);
            currentQuestion.setCategory(DatabaseConstants.TableConstants.SUBJECT_MATHS);
            currentQuestion.setDifficulty(DatabaseConstants.TableConstants.DIFFICULTY_EASY);

            currentQuestion.setOptionA(options()[x][0]);
            currentQuestion.setOptionB(options()[x][1]);
            currentQuestion.setOptionC(options()[x][2]);
            currentQuestion.setOptionD(options()[x][3]);


            questions[x] = currentQuestion;
        }

        return questions;
    }
}
