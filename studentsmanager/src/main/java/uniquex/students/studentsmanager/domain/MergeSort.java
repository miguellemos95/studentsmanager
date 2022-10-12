package uniquex.students.studentsmanager.domain;

import uniquex.students.studentsmanager.utils.MergeSortAlgorithm;

import java.util.ArrayList;

public class MergeSort extends Algorithm  implements Sortable {

    public MergeSort(int index, String name) {
        super.setIndex(index);
        super.setName(name);
    }

    @Override
    public void sort(ArrayList<Student> studentsList) {
        MergeSortAlgorithm.sort(studentsList);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MergeSort) {
            return super.equals(o);
        }
        return false;
    }
}
