package uniquex.students.studentsmanager.domain;

import java.io.Serializable;
import java.util.Objects;

public class Performance implements Serializable {
    private double grade;

    public Performance(double grade) {
        this.grade = grade;
    }

    public Performance(){
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performance that = (Performance) o;
        return Double.compare(that.grade, grade) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade);
    }

    @Override
    public String toString() {
        return "Performance{" +
                "grade=" + grade +
                '}';
    }
}