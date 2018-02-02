package opgave5;

public class TestFilUtil {

    public static void main(String[] args) {
        System.out.println(FilUtil.max("src/opgave5/tal1.txt"));
        System.out.println(FilUtil.max("src/opgave5/tal2.txt"));
        System.out.println(FilUtil.min("src/opgave5/tal1.txt"));
        System.out.println(FilUtil.min("src/opgave5/tal2.txt"));
        System.out.println(FilUtil.gennemsnit("src/opgave5/tal1.txt"));
        System.out.println(FilUtil.gennemsnit("src/opgave5/tal2.txt"));
    }

}
