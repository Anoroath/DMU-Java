package opgave5;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Copier maskine = new Copier();
        maskine.insertPaper(450);
        System.out.println(maskine.getPaper());
        maskine.makeCopy(50);
        System.out.println(maskine.getPaper());
        maskine.makeCopy();
        System.out.println(maskine.getPaper());
        maskine.makeCopyJam();
        maskine.makeCopy();
        maskine.makeCopy(50);
        System.out.println(maskine.getPaper());
        maskine.fixJam();
        maskine.makeCopy();
        System.out.println(maskine.getPaper());
        maskine.makeCopy(50);
        System.out.println(maskine.getPaper());

    }

}
