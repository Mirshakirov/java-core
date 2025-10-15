package lessons.lesson_5.course_system;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {
    private String id;
    private Map<Course, Double> grades = new HashMap<>();

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

    public String getGrades(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Course, Double> entry : grades.entrySet()) {
            sb.append(entry.getKey() + " -> " + entry.getValue() + "\n");
        }
        return sb.toString();
    }

    @Override
    public void showInfo(){
        System.out.println(getFullName() + ", " + getEmail() + ", " + getGrades());
    }


}
