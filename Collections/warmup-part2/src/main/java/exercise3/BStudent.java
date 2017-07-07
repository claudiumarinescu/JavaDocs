package exercise3;

/**
 * Created by Claudiu.Marinescu on 7/7/2017.
 */
public class BStudent extends Student {

    public BStudent (String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)    return true;
        if (o == null)    return false;
        if (this.getClass() != o.getClass())  return false;

        BStudent s = (BStudent) o;
        if (!this.getFirstName().equals(s.getFirstName()))    return false;
        if (!this.getLastName().equals(s.getLastName()))    return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 17 * this.getFirstName().hashCode();
        return result;
    }
}
