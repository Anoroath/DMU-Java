package absence;

public class AbsenceSystem {
    /**
     * Print the absence table on the screen
     */
    public void printAbsence(int[][] absence) {
        for (int student = 0; student < absence.length; student++) {
            System.out.println();
            for (int month = 0; month < absence[student].length; month++) {
                System.out.print(absence[student][month] + " ");
            }
        }
        System.out.println();

    }

    /**
     * Returns the total number of absent days for the given student during the last
     * 12 months.
     */
    public int totalAbsence(int[][] absence, int studentNumber) {
        int ph = 0;
        for (int d = 0; d < absence[studentNumber].length; d++) {
            ph += absence[studentNumber][d];
        }
        return ph;
    }

    /**
     * Returns the average monthly number of absent days for the given student.
     */
    public double averageMonth(int[][] absence, int studentNumber) {
        return totalAbsence(absence, studentNumber) / 12.0;
    }

    /**
     * Returns the number of students without any absence during the last 12 months.
     *
     */
    public int studentWithoutAbsenceCount(int[][] absence) {
        int count = 0;
        for (int i = 0; i < absence.length; i++) {
            if (totalAbsence(absence, i) == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the student with the most absence during the last 12 months. If more
     * than one student has the most absence, return any one of them.
     */
    public int mostAbsentStudent(int[][] absence) {
        int phsn = 0;
        int phv = 0;
        for (int i = 0; i < absence.length; i++) {
            if (totalAbsence(absence, i) > phv) {
                phv = totalAbsence(absence, i);
                phsn = i;
            }
        }
        return phsn;
    }

    /**
     * Resets the absence to 0 for the given student during the last 12 months.
     */
    public void reset(int[][] absence, int studentNumber) {
        for (int i = 0; i < absence[studentNumber].length; i++) {
            absence[studentNumber][i] = 0;
        }
    }
}
