package uniquex.students.studentsmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uniquex.students.studentsmanager.domain.*;
import uniquex.students.studentsmanager.services.IStudentsService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final IStudentsService studentsService;

    public StudentController(IStudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllEmployees () {
        ArrayList<Student> employees = studentsService.getAllStudents();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<Student>> AddAllEmployees(@RequestParam("file") MultipartFile file) {
        studentsService.importStudentsFromFile(file);
        return new ResponseEntity<>(studentsService.getAllStudents(), HttpStatus.OK);
    }
}