package com.example.quizapplication.MainQuiz;

public class Question {

    private static final String DIFFICULTY_EASY = "Easy";
    private static final String DIFFICULTY_HARD = "Hard";
    private static final String DIFFICULTY_MEDIUM = "Medium";

    // constants to get  the various categories
    public static final String CATEGORY_BIOLOGY = "Biology";
    public static final String CATEGORY_PHYSICS = "Physics";
    public static final String CATEGORY_MATHS = "Maths";
    public static final String CATEGORY_ICT = "ICT";

    private String Question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int answerNr;
    private String difficulty;
    private String category;

    /**
     * @param question
     * @param optionA
     * @param optionB
     * @param optionC
     * @param optionD
     * @param answerNr
     * @param difficulty
     * @param category
     */
    public Question(String question, String optionA, String optionB,
                    String optionC, String optionD, int answerNr,
                    String difficulty, String category) {
        Question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answerNr = answerNr;
        this.difficulty = difficulty;
        this.category = category;
    }



    public Question() {

    }

    public int getAnswerNr() {
        return answerNr;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static String[] getDifficultyLevel() {
        return new String[]{
                DIFFICULTY_EASY, DIFFICULTY_MEDIUM, DIFFICULTY_HARD
        };
    }

    public static String[] getAllCategories() {
        return new String[]{
                CATEGORY_BIOLOGY, CATEGORY_ICT, CATEGORY_MATHS, CATEGORY_PHYSICS
        };
    }

}
