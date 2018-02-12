package opgave2;

import java.util.LinkedHashMap;
import java.util.Map;

public class College {
    private String name;
    private Map<Integer, Student> students = new LinkedHashMap<>();

    public College(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addStudent(Student student) {
        students.put(student.getStudentNo(), student);
    }

    public void removeStudent(Student student) {
        students.remove(student.getStudentNo());
    }

    public double calcAverage() {
        double sum = 0.0;
        for (Student student : students.values()) {
            sum += student.calcAverage();
        }
        return sum / students.size();
    }

    public Student findStudent(int studentNo) {
        return students.get(studentNo);
    }

    @Override
    public String toString() {
        return "College name: " + getName();
    }
}
