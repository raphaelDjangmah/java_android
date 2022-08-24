package com.example.quizapplication.RawQuestions;

import com.example.quizapplication.AppResources.SaveHighScore.DatabaseConstants;
import com.example.quizapplication.MainQuiz.Question;

public class ICTEasy {

    /**
     * <P>All Easy ICT questions with their answers will be saved here</P>
     * @return <Span>Returns a String array containing all the questions</Span>
     *
     */

    public static Question[] allQuestions(){

        return getQuestions();

    }


    private static String[] setQuestion() {

        String[] newQuestion = new String[]{
                "Which of the following is an input device",
                "A non-Scientific calculator is a computer",
                "Data is an unprocessed data that can consist of ",
                "Computers can be classified into how many types",
                "ATM is an abbreviation for?",
                "Information is a processed data",
                "MainFrame Computers are more powerful than minicomputers",
                "The information processing cycle involves all of the following except",
                "The floppy disk can be described as a Hardware components of the computer",
                "What does RAM stands for"
        };

        return newQuestion;
    }

    private static String[][] options() {
        String[][] options =
                {
                        {"The computer", "The RAM", "The monitor", "The joystick"},
                        {"True", "False", "It depends", "Non of the above"},
                        {"names", "music", "","Only A", "Both A and B"},
                        {"2", "3", "4", "1"},
                        {"Automated Teller Machine", "Auto Transferee of Money", "All Transfer Money", "Automated Telling Mechanics"},
                        {"True", "False", "Maybe", "None of the above"},
                        {"True", "False", "It depends",""},
                        {"Storage","Input","Typing","Distribution"},
                        {"It depends on the computer","Not anymore","No","Yes"},
                        {"Read Access Memory","Random Access Module", "Random Access Memory", "Read Accessible Memory"}
                };

        return options;
    }

    private static int[] answerNumber() {
        int[] answer_number = {4,2,4,2,1,1,2,3,4,3};
        return answer_number;
    }



    private static Question[] getQuestions() {

        Question[] questions = new Question[setQuestion().length];


        for (int x = 0; x <questions.length; x++) {
            Question currentQuestion = new Question();
            currentQuestion.setQuestion(setQuestion()[x]);
            currentQuestion.setAnswerNr(answerNumber()[x]);
            currentQuestion.setCategory(DatabaseConstants.TableConstants.SUBJECT_ICT);
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
