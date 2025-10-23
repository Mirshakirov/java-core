package lessons.lesson_5.course_system;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String title;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private final AttendanceJournal attendanceJournal = new AttendanceJournal();

    public Course(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    public Course(String title, Teacher teacher, List<Student> students) {
        this.title = title;
        this.teacher = teacher;
        this.students = students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void markAttendance(Student s, boolean present) {
        attendanceJournal.markAttendance(s, present);
    }

    public void addGrade(Student student, Course course, Double grade){
        student.setGrade(course, grade);
    }

    @Override
    public String toString() {
        return title;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
