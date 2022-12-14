package uniquex.students.studentsmanager.domain;

import uniquex.students.studentsmanager.utils.HeapSortAlgorithm;

import java.util.ArrayList;

public class HeapSort extends Algorithm implements Sortable {

    public HeapSort(int index, String name) {
        super.setIndex(index);
        super.setName(name);
    }

    @Override
    public <T extends Comparable<T>> void sort(ArrayList<T> list) {
        HeapSortAlgorithm.sort(list);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof HeapSort) {
            return super.equals(o);
        }
        return false;
    }
}