
public class Teacher extends Person {

    protected String id;
    protected double salary;

    public Teacher(String name, String address, String qualification, String id, double salary) {
        super(name, address, qualification);
        this.salary = salary;
        this.id = id;
    }

    public void yearSalary() {
        this.salary = this.salary * 12 * 1.125;
    }

    public void udskrivPersonT() {
        System.out.println("Navn: " + name);
        System.out.println("Adresse: " + address);
        System.out.println("Kvalifikation: " + qualification);
        System.out.println("Identifikation: " + id);
        System.out.println("Årlig indkomst: " + salary);
    }

}
