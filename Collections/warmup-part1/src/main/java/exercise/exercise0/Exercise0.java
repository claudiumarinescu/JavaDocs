package exercise.exercise0;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)
        List<String> names = new ArrayList<String>();
        names.add("Andrei");
        names.add("George");
        names.add("Alex");
        names.add("Iulia");
        names.add("Diana");

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        System.out.print("List printed using ListIterator: ");
        ListIterator<String> it = names.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " . ");
        }

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        System.out.print("\nList printed using classic for loop: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(names.get(i) + " . ");
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.print("\nList printed using foreach loop: ");
        for (String s : names) {
            System.out.print(s + " . ");
        }

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method

        Exercise0 ex0 = new Exercise0();
        ex0.iterateThroughList();

    }
}
