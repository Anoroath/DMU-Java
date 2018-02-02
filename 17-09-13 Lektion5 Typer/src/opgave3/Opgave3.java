package opgave3;

import java.util.Locale;

public class Opgave3 {

    private String firstName;
    private String middleName;
    private String lastName;

    public Opgave3(String inputFName, String inputMName, String inputLName) {
        this.firstName = inputFName;
        this.middleName = inputMName;
        this.lastName = inputLName;

    }

    public void setFName(String inputFName) {
        this.firstName = inputFName;
    }

    public void setMName(String inputMName) {
        this.middleName = inputMName;
    }

    public void setLName(String inputLName) {
        this.lastName = inputLName;
    }

    public String getFName() {
        return this.firstName;
    }

    public String getMName() {
        return this.middleName;
    }

    public String getLName() {
        return this.lastName;
    }

    public String getInitials() {
        if (this.middleName == "") {
            return firstName.substring(0, 1) + lastName.substring(0, 1);
        } else {
            return firstName.substring(0, 1) + middleName.substring(0, 1) + lastName.substring(0, 1);
        }

    }

    public String getUsername() {
        if (this.middleName == "") {
            return firstName.substring(0, 2).toUpperCase(Locale.ROOT) + (firstName.length() - lastName.length())
                    + lastName.substring(0, 2).toLowerCase(Locale.ROOT);
        } else {
            return firstName.substring(0, 2).toUpperCase(Locale.ROOT) + middleName.length()
                    + lastName.substring(lastName.length() - 2, lastName.length());
        }
    }
}
