package uniquex.students.studentsmanager.services;

import org.springframework.stereotype.Service;
import uniquex.students.studentsmanager.domain.*;
import uniquex.students.studentsmanager.utils.BubbleSortAlgorithm;
import uniquex.students.studentsmanager.utils.HeapSortAlgorithm;
import uniquex.students.studentsmanager.utils.MergeSortAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class AlgorithmService implements IAlgorithmService {
    private final Map<Algorithm, Consumer<ArrayList<Student>>> algorithms = new HashMap<>();

    public void AlgorithmsSeed() {
    }

    public void seed(){
        algorithms.clear();
        addAlgorithm(new BubbleSort(1, "Bubble Sort"), this::BubbleSort);
        addAlgorithm(new HeapSort(2, "Heap Sort"), this::HeapSort);
        addAlgorithm(new MergeSort(3, "Merge Sort"), this::MergeSort);
    }
    public ArrayList<Algorithm> getAllAlgorithms() {
        return new ArrayList<>(algorithms.keySet());
    }

    public long applyAlgorithm(Algorithm key, ArrayList<Student> students) {
        long start = 0, finish = 0;

        if (algorithms.containsKey(key)) {
            start = System.currentTimeMillis();
            algorithms.get(key).accept(students);
            finish = System.currentTimeMillis();
        }
        return finish - start;
    }

    private Consumer<ArrayList<Student>> addAlgorithm(Algorithm key, Consumer<ArrayList<Student>> value) {
        return algorithms.put(key, value);
    }

    private void BubbleSort(ArrayList<Student> studentsList) {
        BubbleSortAlgorithm.sort(studentsList);
    }

    private void HeapSort(ArrayList<Student> studentsList) {
        HeapSortAlgorithm.sort(studentsList);
    }

    private void MergeSort(ArrayList<Student> studentsList) {
        MergeSortAlgorithm.sort(studentsList);
    }
}