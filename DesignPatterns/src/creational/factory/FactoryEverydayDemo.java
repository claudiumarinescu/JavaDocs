package creational.factory;

import java.util.Calendar;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public class FactoryEverydayDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        //Calendar calendar = Calendar.get

        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }

}
