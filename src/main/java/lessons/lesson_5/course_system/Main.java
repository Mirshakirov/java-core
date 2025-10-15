package lessons.lesson_5.course_system;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Teacher teacher = new Teacher("John Smith", "john.smith@email.com", "Java Programming");

        Student s1 = new Student("Alice Brown", "alice@email.com", "S001");
        Student s2 = new Student("Bob Green", "bob@email.com", "S002");

        // Create course
        Course javaCourse = new Course("Java Fundamentals", teacher, Arrays.asList(s1, s2));

        // Mark attendance
        javaCourse.markAttendance(s1, true);
        javaCourse.markAttendance(s2, false);

        // Add grades
        javaCourse.addGrade(s1, javaCourse, 95.0);
        javaCourse.addGrade(s2, javaCourse, 80.5);

        // Show teacher info
        System.out.println("=== Teacher Info ===");
        teacher.showInfo();

        // Show student info
        System.out.println("\n=== Students Info ===");
        s1.showInfo();
        s2.showInfo();
    }
}
