package uniquex.students.studentsmanager.services;

import org.springframework.web.multipart.MultipartFile;
import uniquex.students.studentsmanager.domain.Student;

import java.util.ArrayList;

public interface IStudentsService {
    Student newStudent(String name, double performance);
    boolean addStudent(Student student);
    ArrayList<Student> getAllStudents();
    void importStudentsFromFile(MultipartFile file);
}