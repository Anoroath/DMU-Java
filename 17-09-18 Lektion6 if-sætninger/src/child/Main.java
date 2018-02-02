package child;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Child Anders = new Child(20, false);
        Anders.setBoy(true);
        Anders.setAge(21);
        System.out.println(Anders.getAge());
        System.out.println(Anders.institution());
        System.out.println(Anders.gender());
        System.out.println(Anders.team());
    }

}
