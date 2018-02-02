package opgave1;

public class Data {
    public static double max(Measurable[] objects) {
        double max = 0;
        for (Measurable obj : objects) {
            if (obj.getMeasure() > max) {
                max = obj.getMeasure();
            }
        }
        return max;
    }

    public static double avg(Measurable[] objects) {
        double sum = 0;
        for (Measurable obj : objects) {
            sum = sum + obj.getMeasure();
        }
        return sum / objects.length;
    }
}
