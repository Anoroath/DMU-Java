package opgave2;

public class MainApp {

    public static void main(String[] args) {
        College c1 = new College("UA");

        Student s1 = new Student(1, "Bjarke");
        c1.addStudent(s1);
        s1.addGrade(10);
        s1.addGrade(12);
        s1.addGrade(2);

        Student s2 = new Student(2, "Bine");
        c1.addStudent(s2);
        s2.addGrade(10);
        s2.addGrade(12);
        s2.addGrade(2);

        Student s3 = new Student(3, "Helle");
        c1.addStudent(s3);
        s3.addGrade(10);
        s3.addGrade(12);
        s3.addGrade(2);

        Student s4 = new Student(4, "Grethe");
        c1.addStudent(s4);
        s4.addGrade(10);
        s4.addGrade(12);
        s4.addGrade(2);

        Student s5 = new Student(5, "Peter");
        c1.addStudent(s4);
        s5.addGrade(10);
        s5.addGrade(12);
        s5.addGrade(2);

        System.out.println(s1.calcAverage());
        System.out.println(c1.findStudent(3));
        System.out.println(s5.getGrades());
    }

}
