package lessons.lesson_5.course_system;

import java.util.HashMap;
import java.util.Map;

public class AttendanceJournal {
    private final Map<Student, Boolean> attendance = new HashMap<>();

    public void markAttendance(Student student, Boolean present){
        attendance.put(student, present);
    }

    public Map<Student, Boolean> getAttendance() {
        return attendance;
    }
}
