package lessons.lesson_5.quiz_system;

public class Player extends Participant {
    private int score = 0;

    Player(String name){
        setName(name);
    }

    public int getScore(){
        return score;
    }

    public void addScore(int score){
        this.score += score;
    }

    @Override
    public void showInfo() {
        System.out.println(getName());
        System.out.println(getScore());
    }
}
