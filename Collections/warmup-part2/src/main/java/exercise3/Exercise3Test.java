package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Claudiu.Marinescu on 7/7/2017.
 */
public class Exercise3Test {

    public static void main(String[] args) {

        Map<AStudent, BigDecimal> firstMap = new HashMap<AStudent, BigDecimal>();
        Map<BStudent, BigDecimal> secondMap = new HashMap<BStudent, BigDecimal>();
        Map<CStudent, BigDecimal> thirdMap = new HashMap<CStudent, BigDecimal>();
        Map<DStudent, BigDecimal> fourthMap = new HashMap<DStudent, BigDecimal>();

        /* -----> test the first map <----- */
        System.out.println("Test - equal by firstName, hashCode by firstName");
        firstMap.put(new AStudent("Albu", "George"), BigDecimal.valueOf(1));
        firstMap.put(new AStudent("Albu", "Mihai"), BigDecimal.valueOf(2));
        firstMap.put(new AStudent("Stoica", "George"), BigDecimal.valueOf(3));

        // check the key-value pair in the map
        System.out.println(firstMap);

        // try to get a value by a key that does not exist
        // it thinks it exists because equals method checks only first name equality
        BigDecimal caseA = firstMap.get(new AStudent("Stoica", "Alina"));
        System.out.println(caseA);


        /* -----> test the second map <----- */
        System.out.println("\nTest - equal by firstName & lastName, hashCode by firstName");
        secondMap.put(new BStudent("Albu", "George"), BigDecimal.valueOf(1));
        secondMap.put(new BStudent("Albu", "Mihai"), BigDecimal.valueOf(2));
        secondMap.put(new BStudent("Stoica", "George"), BigDecimal.valueOf(3));

        System.out.println(secondMap);

        /* -----> test the third map <----- */
        System.out.println("\nTest - equal by firstName, hashCode by firstName & lastName");
        thirdMap.put(new CStudent("Albu", "George"), BigDecimal.valueOf(1));
        thirdMap.put(new CStudent("Albu", "Mihai"), BigDecimal.valueOf(2));
        thirdMap.put(new CStudent("Stoica", "George"), BigDecimal.valueOf(3));

        System.out.println(thirdMap);

        BigDecimal caseC = thirdMap.get(new CStudent("Albu", "Mihai"));
        System.out.println(caseC);

        /* -----> test the fourth map <----- */
        System.out.println("\nTest - equal by firstName & lastName, hashCode by firstName & lastName");
        fourthMap.put(new DStudent("Albu", "George"), BigDecimal.valueOf(1));
        fourthMap.put(new DStudent("Albu", "Mihai"), BigDecimal.valueOf(2));
        fourthMap.put(new DStudent("Stoica", "George"), BigDecimal.valueOf(3));

        System.out.println(thirdMap);

        BigDecimal caseD = fourthMap.get(new DStudent("Albu", "Mihai"));
        System.out.println(caseD);

    }

}
