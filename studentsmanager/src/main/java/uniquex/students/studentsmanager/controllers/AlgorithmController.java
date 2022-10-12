package uniquex.students.studentsmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniquex.students.studentsmanager.domain.Algorithm;
import uniquex.students.studentsmanager.dtos.SortStudentsRequest;
import uniquex.students.studentsmanager.dtos.SortStudentsResponse;
import uniquex.students.studentsmanager.services.IAlgorithmService;

import java.util.ArrayList;

@RestController
@RequestMapping("/algorithm")
public class AlgorithmController {
    private IAlgorithmService algorithmService;

    public AlgorithmController(IAlgorithmService algorithmService) {
        this.algorithmService = algorithmService;
        this.algorithmService.seed();
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<Algorithm>> getAllAlgorithms(){
        ArrayList<Algorithm> algorithms = algorithmService.getAllAlgorithms();
        return new ResponseEntity<>(algorithms, HttpStatus.OK);
    }

    @PutMapping("/sort")
    public ResponseEntity<SortStudentsResponse> applyAlgorithms(@RequestBody SortStudentsRequest sortStudentsRequest){
        long timer = algorithmService.applyAlgorithm(sortStudentsRequest.getSelectedAlgorithm(), sortStudentsRequest.getStudents());
        return new ResponseEntity<>(new SortStudentsResponse(timer, sortStudentsRequest.getStudents()), HttpStatus.OK);
    }
}