package lessons.lesson_5.quiz_system;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private final String question;
    private List<String> answersList = new ArrayList<>();
    private final int correctAnswer;

    public Question(String question, List<String> answersList, int correctAnswer) {
        this.question = question;
        this.answersList = answersList;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion(){
        return question;
    }

    public List<String> getAnswersList(){
        return answersList;
    }
    public int getCorrectAnswer(){
        return correctAnswer;
    }
}
