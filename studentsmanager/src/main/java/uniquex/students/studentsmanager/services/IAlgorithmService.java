package uniquex.students.studentsmanager.services;

import uniquex.students.studentsmanager.domain.Algorithm;
import uniquex.students.studentsmanager.domain.Sortable;
import uniquex.students.studentsmanager.domain.Student;

import java.util.ArrayList;

public interface IAlgorithmService {
    void seed();
    ArrayList<Algorithm> getAllAlgorithms();
    /**long applyAlgorithm(Algorithm key, ArrayList<Student> students);**/
    long applyAlgorithm(Algorithm key, ArrayList<Student> students);

}
