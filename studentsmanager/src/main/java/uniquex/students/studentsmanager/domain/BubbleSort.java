package uniquex.students.studentsmanager.domain;

import uniquex.students.studentsmanager.utils.BubbleSortAlgorithm;

import java.util.ArrayList;

public class BubbleSort extends Algorithm implements Sortable {
    public BubbleSort(int index, String name) {
        super.setIndex(index);
        super.setName(name);
    }

    @Override
    public <T extends Comparable<T>> void sort(ArrayList<T> list) {
        BubbleSortAlgorithm.sort(list);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BubbleSort) {
            return super.equals(o);
        }
        return false;
    }
}