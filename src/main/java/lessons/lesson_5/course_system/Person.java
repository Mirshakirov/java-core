package lessons.lesson_5.course_system;

public abstract class Person {
    private String fullName;
    private String email;

    public Person(String name, String email) {
        this.fullName = name;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void updateFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void showInfo(){
        System.out.println(getFullName() + getEmail());
    }
}
