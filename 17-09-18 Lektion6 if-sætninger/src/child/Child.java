package child;

public class Child {
    private int age;
    private boolean boy;

    public Child(int age, boolean boy) {
        this.age = age;
        this.boy = boy;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBoy() {
        return this.boy;
    }

    public void setBoy(boolean boy) {
        this.boy = boy;
    }

    public String institution() {
        if (age == 0) {
            return "Home";
        } else if (age <= 2) {
            return "Nursery";
        } else if (age <= 5) {
            return "Kindergarten";
        } else if (age <= 16) {
            return "School";
        } else {
            return "Out of School";
        }
    }

    public String gender() {
        if (boy == true) {
            return "Boy";
        } else {
            return "Girl";
        }
    }

    public String team() {
        if (boy == true && age < 8) {
            return "Young Cubs";
        } else if (boy == true && age >= 8) {
            return "Cool Boys";
        } else if (boy == false && age < 8) {
            return "Tumbling Girls";
        } else {
            return "Springy Girls";
        }
    }

}
