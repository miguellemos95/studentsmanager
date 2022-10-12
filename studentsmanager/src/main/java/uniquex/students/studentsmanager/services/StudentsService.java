package uniquex.students.studentsmanager.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uniquex.students.studentsmanager.domain.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class StudentsService implements IStudentsService {
    private final ArrayList<Student> studentsList;

    public StudentsService() {
        studentsList = new ArrayList<>();
    }

    public ArrayList<Student> getAllStudents() {
        return studentsList;
    }

    public Student newStudent(String name, double performance){
        return new Student(name, performance);
    }

    public boolean addStudent(Student student) {
        return studentsList.add(student);
    }

    public void importStudentsFromFile(MultipartFile file) {
        InputStream is = null;
        try {
            is = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner input = new Scanner(is);

        input.useDelimiter(";|\n");

        while(input.hasNext()) {
            String nameRead = input.next();
            double gradeRead = Double.valueOf(input.next());

            Student student = newStudent(nameRead, gradeRead);
            if(!addStudent(student)){
                return;
            }
        }
    }
}
