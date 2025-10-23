package lessons.lesson_5.course_system;

public class Teacher extends Person{
    private String subject;

    public Teacher(String name, String email, String subject) {
        super(name, email);
        this.subject = subject;
    }

    public String getSubject() { return subject; }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void showInfo(){
        System.out.println(getFullName() + ", " + getEmail() + ", " + getSubject());
    }

}
