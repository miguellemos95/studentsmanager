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
    /**private final Map<Algorithm, Consumer<ArrayList<Student>>> algorithms = new HashMap<>();**/
    private final Map<Integer, Algorithm> algorithms = new HashMap<>();

    public void AlgorithmsSeed() {
    }

    public void seed(){
        algorithms.clear();
        addAlgorithm(1, new BubbleSort(1, "Bubble Sort"));
        addAlgorithm(2, new HeapSort(2, "Heap Sort"));
        addAlgorithm(3, new MergeSort(3, "Merge Sort"));
        /**addAlgorithm(new BubbleSort(1, "Bubble Sort"), this::BubbleSort);
         addAlgorithm(new HeapSort(2, "Heap Sort"), this::HeapSort);
         addAlgorithm(new MergeSort(3, "Merge Sort"), this::MergeSort);**/
    }
    public ArrayList<Algorithm> getAllAlgorithms() {
        return new ArrayList<>(algorithms.values());
    }

    public long applyAlgorithm(Algorithm key, ArrayList<Student> students) {
        long start = 0, finish = 0;

        Sortable algorithm = (Sortable) algorithms.get(key.getIndex());
        if (algorithm != null) {
            start = System.currentTimeMillis();
            algorithm.sort(students);
            finish = System.currentTimeMillis();
        }
        return finish - start;
    }

    private Algorithm addAlgorithm(Integer key, Algorithm value) {
        return algorithms.put(key, value);
    }

    /**private Consumer<ArrayList<Student>> addAlgorithm(Algorithm key, Consumer<ArrayList<Student>> value) {
     return algorithms.put(key, value);
     }**/

    /**    public long applyAlgorithm(Algorithm key, ArrayList<Student> students) {
     long start = 0, finish = 0;

     if (algorithms.containsKey(key)) {
     start = System.currentTimeMillis();
     algorithms.get(key).accept(students);
     finish = System.currentTimeMillis();
     }
     return finish - start;
     }**/

    /**private void BubbleSort(ArrayList<Student> studentsList) {
        BubbleSortAlgorithm.sort(studentsList);
    }

    private void HeapSort(ArrayList<Student> studentsList) {
        HeapSortAlgorithm.sort(studentsList);
    }

    private void MergeSort(ArrayList<Student> studentsList) {
        MergeSortAlgorithm.sort(studentsList);
    }**/
}