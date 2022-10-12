package uniquex.students.studentsmanager.utils;

import java.util.ArrayList;

public class MergeSortAlgorithm {
    public static <T extends Comparable<? super T>> void sort(ArrayList<T> L){
        int size=L.size();
        if(size<2){
            return;
        }
        int half=size/2;
        ArrayList<T> L1=new ArrayList<T>(L.subList(0,half));
        ArrayList<T> L2=new ArrayList<T>(L.subList(half,size));

        sort(L1);
        sort(L2);

        merge(L1,L2,L);
    }

    private static <T extends Comparable<? super T>> void merge(ArrayList<T> L1, ArrayList<T> L2, ArrayList<T> L){
        int i=0;
        int j=0;
        int k=0;
        while(i < L1.size() && j < L2.size()) {
            if(L1.get(i).compareTo(L2.get(j)) < 0) {
                L.set(k++, L1.get(i++));
            }else {
                L.set(k++, L2.get(j++));
            }
        }
        while(i < L1.size()) {
            L.set(k++, L1.get(i++));
        }
        while(j < L2.size()) {
            L.set(k++, L2.get(j++));
        }
    }
}