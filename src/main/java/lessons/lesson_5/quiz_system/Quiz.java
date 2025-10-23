package lessons.lesson_5.quiz_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String title;
    private List<Question> questions = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting the quiz: " + title);

        for (Question q : questions) {
            System.out.println("\nQuestion: " + q.getQuestion());
            List<String> answers = q.getAnswersList();
            for (int i = 0; i < answers.size(); i++) {
                System.out.println((i + 1) + ". " + answers.get(i));
            }

            for (Team team : teams) {
                System.out.println("\n" + team.getName() + "'s turn!");
                for (Player player : team.getPlayersList()) {
                    System.out.print(player.getName() + ", choose your answer: ");
                    int answer = scanner.nextInt();
                    if (answer == q.getCorrectAnswer()) {
                        System.out.println("Correct!");
                        player.addScore(1);
                    } else {
                        System.out.println("Incorrect!");
                    }
                }
            }
        }

        showResults();
    }

    private void showResults() {
        System.out.println("\n___FINAL RESULTS___");
        for (Team team : teams) {
            System.out.println(team.getName() + ": " + team.getTotalScore() + " points");
        }
    }

}
