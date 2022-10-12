package uniquex.students.studentsmanager.domain;

import java.util.Objects;

public class Algorithm {
    private int index;
    private String name;

    public Algorithm() {
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Algorithm algorithm = (Algorithm) obj;

            if (obj instanceof BubbleSort){
                return index == algorithm.index && Objects.equals(name, algorithm.name);
            }
            if (obj instanceof HeapSort){
                return index == algorithm.index && Objects.equals(name, algorithm.name);
            }
            if (obj instanceof MergeSort){
                return index == algorithm.index && Objects.equals(name, algorithm.name);
            }

            return index == algorithm.index && Objects.equals(name, algorithm.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }
}
