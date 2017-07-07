package exercise3;

/**
 * Created by Claudiu.Marinescu on 7/7/2017.
 */
public class Student {
    private final String firstName;
    private final String lastName;

    public Student() {
        this.firstName = "";
        this.lastName = "";
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        String s = "" + firstName + " " + lastName;
        return s;
    }

}
