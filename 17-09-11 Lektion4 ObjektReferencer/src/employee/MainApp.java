package employee;

public class MainApp {

    public static void main(String[] args) {
        Employee e = new Employee("Kristian", "Dorland", 32);
        System.out.print(e.getName());
        System.out.println(e.getLName());
        System.out.println(e.getAge());
        e.setAge(32);
        e.increaseAgeByOne();
        System.out.println(e.getAge());
        e.printEmployee();
    }

}
