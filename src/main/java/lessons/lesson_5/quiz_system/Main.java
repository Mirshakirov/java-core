package lessons.lesson_5.quiz_system;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Java Basics Quiz");

        Question q1 = new Question(
                "Which keyword is used to inherit a class in Java?",
                Arrays.asList("this", "extends", "implements", "inherits"),
                2
        );

        Question q2 = new Question(
                "What is the default value of an int variable?",
                Arrays.asList("0", "null", "undefined", "1"),
                1
        );

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        Team teamA = new Team();
        teamA.setName("Team Alpha");
        teamA.addMember(new Player("Alice"));
        teamA.addMember(new Player("Bob"));

        Team teamB = new Team();
        teamB.setName("Team Beta");
        teamB.addMember(new Player("Charlie"));
        teamB.addMember(new Player("Diana"));

        quiz.addTeam(teamA);
        quiz.addTeam(teamB);

        quiz.start();
    }
}