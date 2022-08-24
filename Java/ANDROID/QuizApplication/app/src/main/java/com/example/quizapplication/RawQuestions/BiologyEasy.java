package com.example.quizapplication.RawQuestions;

import com.example.quizapplication.AppResources.SaveHighScore.DatabaseConstants;
import com.example.quizapplication.MainQuiz.Question;

/**
 * <P>All Easy biology Question with their answers will be saved here</P>
 *
 * @return <Span>Returns a String array containing all the Question</Span>
 */
public class BiologyEasy {


    public static Question[] allQuestions() {

        return getQuestions();

    }


    private static String[] setQuestion() {

        String[] newQuestion = new String[]{
                "At what temperature does water boil?",
                "How many legs does all Mammals have",
                "How many percentage of water is in the human body system",
                "What is the normal body temperature of human",
                "The term biology is divides into two part : Bios and logos. What does logos means?",
                "Which of the following is a characteristics of a living organism",
                "Which of these is not a branch of biology",
                "What are cells?",
                "Which of these is an agent of Pollination?",
                "Diffusion can occur in"
        };

        return newQuestion;
    }

    private static String[][] options() {
        String[][] options =
                {
                        {"37 degrees", "100 degrees", "87 degrees", "90 degrees"},
                        {"6", "2", "4", "It depends on the organism"},
                        {"50%", "30%", "80%", "70%"},
                        {"42 degrees", "37 degrees", "33 degrees", "35 degrees"},
                        {"Life", "Style", "Organism", "Study"},
                        {"Movement", "Water", "Wind", "Crying"},
                        {"Zoology", "MicroBiology", "Anatomy", "Organism"},
                        {"Living organism that can feed", "Characteristics of man", "Basic building block of all organisms", "None of the above"},
                        {"Metal", "Plastic", "Wood", "Wind"},
                        {"Solids", "Liquids", "Gases", "All of the above"}
                };

        return options;
    }

    private static int[] answerNumber() {
        int[] answer_number = {2, 3, 4, 2, 4, 1, 4, 3, 4, 4};
        return answer_number;
    }


    private static Question[] getQuestions() {

        Question[] questions = new Question[setQuestion().length];


        for (int x = 0; x <questions.length; x++) {
            Question currentQuestion = new Question();
            currentQuestion.setQuestion(setQuestion()[x]);
            currentQuestion.setAnswerNr(answerNumber()[x]);
            currentQuestion.setCategory(DatabaseConstants.TableConstants.SUBJECT_BIOLOGY);
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
