package opgave2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentNo;
    private String name;
    private List<Integer> grades = new ArrayList<>();

    public Student(int studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
    }

    public int getStudentNo() {
        return this.studentNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public double calcAverage() {
        double sum = 0.0;
        for (Integer integer : grades) {
            sum += integer;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return "Student #" + getStudentNo() + " " + getName();
    }
}
