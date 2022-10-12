package uniquex.students.studentsmanager.dtos;

import uniquex.students.studentsmanager.domain.Algorithm;
import uniquex.students.studentsmanager.domain.Student;

import java.util.ArrayList;

public class SortStudentsRequest {
    private Algorithm selectedAlgorithm;
    private ArrayList<Student> students;

    public SortStudentsRequest() {
    }

    public Algorithm getSelectedAlgorithm() {
        return selectedAlgorithm;
    }

    public void setSelectedAlgorithm(Algorithm selectedAlgorithm) {
        this.selectedAlgorithm = selectedAlgorithm;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
