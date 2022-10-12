package uniquex.students.studentsmanager.utils;

import java.util.ArrayList;

public class BubbleSortAlgorithm {
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                // is left larger than right?
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    // swap j and j + 1
                    T tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
    }
}
