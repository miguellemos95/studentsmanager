package uniquex.students.studentsmanager.domain;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable, Comparable<Student> {
    private String name;
    private Performance performance;

    public Student(String name, double grade) {
        this.name = name;
        performance = new Performance(grade);
    }

    public Student(){
        performance = new Performance();
    }

    public String getName() {
        return name;
    }

    public Performance getPerformance() {
        return performance;
    }

    public double getPerformanceGrade() {
        return performance.getGrade();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) && performance.equals(student.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, performance);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", performance=" + performance +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.getPerformanceGrade() - o.getPerformanceGrade());
    }
}