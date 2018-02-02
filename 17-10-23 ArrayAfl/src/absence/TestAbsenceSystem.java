package absence;

public class TestAbsenceSystem {

    public static void main(String[] args) {
        int[][] absence17t = { { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 3, 1, 0, 2, 0, 0, 0, 0 }, { 1, 2, 1, 2, 1, 2, 0, 2, 0, 0, 4, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0 } };

        AbsenceSystem absenceSystem = new AbsenceSystem();
        absenceSystem.printAbsence(absence17t);

        System.out.println("This student has " + absenceSystem.totalAbsence(absence17t, 0) + " absence days.");
        System.out.println(
                "This student has an average " + absenceSystem.averageMonth(absence17t, 0) + " absence days a month.");
        System.out.println("There is a total of " + absenceSystem.studentWithoutAbsenceCount(absence17t)
                + " student(s) with no absence.");
        System.out.println("The student with the most absence has the student number "
                + absenceSystem.mostAbsentStudent(absence17t) + ".");
        absenceSystem.reset(absence17t, 0);
        absenceSystem.printAbsence(absence17t);
    }
}
