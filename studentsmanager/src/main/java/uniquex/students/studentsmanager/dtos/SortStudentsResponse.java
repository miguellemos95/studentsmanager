package uniquex.students.studentsmanager.dtos;

import uniquex.students.studentsmanager.domain.Student;

import java.util.ArrayList;

public class SortStudentsResponse {
    private long timer;
    private ArrayList<Student> students;

    public SortStudentsResponse(long timer, ArrayList<Student> students) {
        this.timer = timer;
        this.students = students;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
