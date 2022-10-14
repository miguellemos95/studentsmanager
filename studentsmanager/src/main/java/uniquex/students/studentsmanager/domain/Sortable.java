package uniquex.students.studentsmanager.domain;

import java.util.ArrayList;

public interface Sortable {
    <T extends Comparable<T>> void sort(ArrayList<T> list);
}