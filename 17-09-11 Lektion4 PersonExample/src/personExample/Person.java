package personExample;

public class Person {
    private String name;
    private String address;
    private double monthlySalary;
    private int enterprise;
    private int birthyear;
    private int birthmonth;
    private int birthday;

    public Person(String inputName, String inputAddress, double inputMSalary, int inputEnterprise, int inputBYear,
            int inputBMonth, int inputBDay) {
        this.name = inputName;
        this.address = inputAddress;
        this.monthlySalary = inputMSalary;
        this.enterprise = inputEnterprise;
        this.birthyear = inputBYear;
        this.birthmonth = inputBMonth;
        this.birthday = inputBDay;
    }

    public void setName(String inputName) {
        this.name = inputName;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(String inputAddress) {
        this.address = inputAddress;
    }

    public String getAddress() {
        return this.address;
    }

    public void setMonthlySalary(int inputMSalary) {
        this.monthlySalary = inputMSalary;
    }

    public double getMonthlySalary() {
        return this.monthlySalary;
    }

    public void AfterOneYear() {
        this.monthlySalary = (this.monthlySalary * 12) * 1.025;
    }

    public void setEnterprise(int inputEnterprise) {
        this.enterprise = inputEnterprise;
    }

    public int getEnterprise() {
        return this.enterprise;
    }

    public void AddEnterprise() {
        this.enterprise = this.enterprise + 1;
    }

    public void printPerson() {
        System.out.println("**************************************");
        System.out.println("Name            " + this.name);
        System.out.println("Address         " + this.address);
        System.out.println("Monthly Salary  " + this.monthlySalary);
        System.out.println("Yearly Salary   " + this.monthlySalary);
        System.out.println("**************************************");
    }

    public int getAge(int currentyear, int currentmonth, int currentday) {

        if (currentmonth < this.birthmonth) {
            return (currentyear - 1) - this.birthyear;
        } else if (currentmonth == this.birthmonth && currentday < this.birthday) {
            return (currentyear - 1) - this.birthyear;
        } else {
            return currentyear - this.birthyear;
        }

    }

    public void leapYear(int currentyear) {
        if (currentyear % 4 == 0 && (currentyear % 100 != 0 || currentyear % 400 == 0)) {
            System.out.println("Skudår");
        } else {
            System.out.println("Ikke skudår");
        }
    }

}
