package personExample;

public class MainApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Person b = new Person("Anders Broch Ulsted", "Hirtshalsvej 23", 1000, 2, 1996, 1, 15);
        System.out.println(b.getName());
        System.out.println(b.getAddress());
        System.out.println(b.getMonthlySalary());
        b.AfterOneYear();
        System.out.println(b.getMonthlySalary());
        System.out.println(b.getEnterprise());
        b.AddEnterprise();
        System.out.println(b.getEnterprise());
        System.out.println(b.getAge(2018, 1, 15));
        b.leapYear(2004);
    }

}
