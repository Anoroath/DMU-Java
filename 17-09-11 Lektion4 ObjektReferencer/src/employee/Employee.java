package employee;

public class Employee { // Class
    private String name; // Felt / attribut
    private boolean trainee; // Felt / attribut
    private int age; // Felt / attribut
    private String lname;

    // Constructor
    public Employee(String inputName, String inputLName, int inputAge) {
        this.name = inputName;
        this.trainee = true;
        this.age = inputAge;
        this.lname = inputLName;
    }

    // Accessor-metode
    public String getName() {
        return this.name;
    }

    // Mutator-metode
    public void setName(String inputName) {
        this.name = inputName;
    }

    // Mutator-metode
    public void setTrainee(boolean trainee) {
        this.trainee = trainee;
    }

    // Accessor-metode
    public boolean isTrainee() {
        return this.trainee;
    }

    // Accessor.metode
    public int getAge() {
        return this.age;
    }

    // Mutator-metode
    public void setAge(int inputAge) {
        this.age = inputAge;
    }

    // Mutator-metode
    public void increaseAgeByOne() {
        this.age = this.age + 1;
    }

    public void setLName(String inputLName) {
        this.lname = inputLName;
    }

    public String getLName() {
        return this.lname;
    }

    @Override
    public String toString() {
        return this.name + " is trainee: " + this.trainee;
    }

    public void printEmployee() {
        System.out.println("**************************************");
        System.out.println("Fornavn     " + this.name);
        System.out.println("Efternavn   " + this.lname);
        System.out.println("Trainee     " + this.trainee);
        System.out.println("Alder       " + this.age);
        System.out.println("**************************************");
    }
}
