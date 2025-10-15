package lessons.lesson_5.course_system;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private final String id;
    private final Map<Course, Double> grades = new HashMap<>();

    public Student(String name, String email, String id) {
        super(name, email);
        this.id = id;
    }

    public void setGrade(Course course, double grade){
        grades.put(course, grade);
    }

    public void getGrade(Course course){
        grades.get(course);
    }

    public String getId() {
        return id;
    }

    public String getGrades(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Course, Double> entry : grades.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void showInfo(){
        System.out.println(getFullName() + ", " + getEmail() + ", " + getGrades());
    }


}
