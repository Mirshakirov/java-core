package lessons.lesson_5.quiz_system;

public abstract class Participant {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void showInfo();
}
