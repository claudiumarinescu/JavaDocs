package exercise5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * You should implement from zero a data structure that acts as an ArrayList.
 * We have a default capacity of {@link MyImplementedList#DEFAULT_CAPACITY} elements of type <code>E</code>.
 * We have a {@link MyImplementedList#size} property that stores the number of elements of type <code>E</code> from the data structure.
 * We have an array property, {@link MyImplementedList#elementData}, that keeps the elements from the data structure.
 * We have a {@link MyImplementedList#LOAD_FACTOR} property that specify the maximum accepted load of the data structure.
 * We have a {@link MyImplementedList#INCREASE_SIZE_FACTOR} property to use it when we must increase the capacity of the data structure.
 * We have a {@link MyImplementedList#capacityAfterExtending} property to use it to retain the new capacity after increasing it.
 * <p>
 * Starting with this properties we must implement a data structure that acts ~ as an ArrayList for some objects of type <code>E</code>.
 * <p>
 * if you need to throw some exceptions YOU MUST create them!
 * if you get some warning from the compiler you can use @SuppressWarnings("all") before the method name!
 * if you get this error "usage of api documented as @since 1.6+" you should go to File > Project Structure > Modules and make sure you have the Language level >= 1.6!
 * you should expose as <code>public</code> only the methods that you usually use over a collection!
 * if you need a getter/setter for the properties you must define then, but keep in mind the java concepts!
 * make sure you cover all the possible use-cases for your data structure!
 *
 * @author Cristian.Dumitru
 * @since 7/3/2017.
 */
public class MyImplementedList<E> implements Iterable<E> {

    /**
     * The maximum accepted load property of the data structure.
     */
    private static final double LOAD_FACTOR = 0.75d;

    /**
     * The factor for increasing the size of the data structure.
     */
    private static final int INCREASE_SIZE_FACTOR = 2;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the ArrayList (the number of elements it contains).
     */
    private int size;

    /**
     * The array buffer into which the elements of the {@link MyImplementedList} are stored.
     */
    private Object[] elementData;

    /**
     * Property to keep the extended capacity.
     *  if you choose another way to implement the extending capacity you can define your own properties,
     *  but the rest of them must remain as they are.
     */
    private int capacityAfterExtending;

    // a) implement the empty constructor for the your data structure
    public MyImplementedList() {
        // a) HINT - DEFAULT_CAPACITY, capacityAfterExtending and elementData properties
        elementData = new Object[DEFAULT_CAPACITY];
        capacityAfterExtending = DEFAULT_CAPACITY;
        size = 0;
    }

    // b) create the int size() method that returns the size of the data structure
    public int size() {
        return this.size;
    }

    // c) create the boolean add(E e) method that adds at the end of the data structure an element
    // pay attention to the LOAD_FACTOR of the data structure
    public boolean add(E e) {
        if (this.size > (capacityAfterExtending * LOAD_FACTOR)) {
            extendCapacity();
        }

        elementData[size++] = e;
        return true;
    }

    // d) create the boolean isEmpty() method that checks if the data structure have elements
    public boolean isEmpty() {
        return (size == 0);
    }

    // e) create the boolean contains(Object o_O) method that checks if the data structure contains the object o_O
    public boolean contains(Object o_O) {
        for (Object e : elementData) {
            if (e.equals(o_O)) {
                return true;
            }
        }
        return false;
    }

    // f) create the int indexOf(Object o_O) method that returns the position in the data structure of the object o_O
    // if exists, otherwise return -1
    public int indexOf(Object o_O) {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o_O)) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    // g) create the int lastIndexOf(Object o_O) method that returns the last position in the data structure of the object o_O
    // if exists, otherwise return -1
    public int lastIndexOf(Object o_O) {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o_O)) {
                idx = i;
            }
        }
        return idx;
    }

    // h) create the E get(int index) method that returns the object from the given index
    // pay attention to the size property
    public E get(int index) {
        if ((index < 0) || (index >= size)) {
            throw new MyException("in get(index).");
        }

        return (E) elementData[index];
    }

    // i) create the E set(int index, E element) method that updates the value of the element from the given index
    // pay attention to the size property
    public E set(int index, E element) {
        if ((index < 0) || (index >= size)) {
            throw new MyException("in set(index, element).");
        }

        Object prev = elementData[index];
        elementData[index] = element;
        return (E) prev;
    }


    // j) create the E remove(int index) method that removes the element from the given index
    public E remove(int index) {
        if ((index < 0) || (index >= size)) {
            throw new MyException("in remove(index).");
        }

        Object prev = elementData[index];

        for (int i = index; i < (size + 1); i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        return (E)prev;
    }


    // k) extend the current default capacity, if the number of elements in the data structure is > 75% of it
    // you should name it: void extendCapacity(int capacity) - HINT use capacity, DEFAULT_CAPACITY, LOAD_FACTOR and INCREASE_SIZE_FACTOR
    private void extendCapacity() {
        Object[] temp = elementData.clone();
        capacityAfterExtending *= INCREASE_SIZE_FACTOR;
        elementData = new Object[capacityAfterExtending];
        java.lang.System.arraycopy(temp, 0, elementData, 0, temp.length);
    }


    // l) implement the iterator() method in order to use the foreach statement over your data structure - HINT Iterable interface
    // and implement a custom iterator for your custom data structure - methods boolean hasNext(), Object next() and void remove()
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    private class MyIterator<E> implements Iterator<E> {

        private int idx;
        private int removeIdx;

        public MyIterator() {
            idx = 0;
            removeIdx = -1;
        }

        public boolean hasNext() {
            if ((this.idx) >= size) {
                return false;
            }
            return true;
        }

        public E next() {
            removeIdx = idx;
            return (E) elementData[idx++];
        }

        public void remove() {
            if (removeIdx == -1) {
                return;
            }
            for (int i = removeIdx; i < (size - 1); i++) {
                elementData[i] = elementData[i + 1];
            }
            idx--;
            removeIdx = -1;
            size--;
        }
    }

    // m) implement a method, that uses a Comparator, for your data structure to sort the elements
    // you should name it: void sort(Comparator<? super E> c)
    // create a custom comparator that compares objects by their "what you want" :D - HINT Comparator interface
    public void sort(Comparator<? super E> c) {
        int left = 0;
        int right = size - 1;

        //Arrays.sort((E[])elementData);

        quickSort(left, right, c);
    }

    private void quickSort(int left, int right, Comparator<? super E> c) {
        if (left >= right)
            return;

        E pivot = (E)elementData[left];
        int part = partition(left, right, pivot, c);

        quickSort(left, part, c);
        quickSort(part + 1, right, c);
    }

    private int partition(int left, int right, E pivot, Comparator<? super E> c) {
        int leftCursor = left - 1;
        int rightCursor = right + 1;

        while (true) {
            while (c.compare((E)elementData[++leftCursor], pivot) < 0);
            while (c.compare((E)elementData[--rightCursor], pivot) > 0);
            if (leftCursor >= rightCursor) {
                return rightCursor;
            }
            swap(leftCursor, rightCursor);
        }
    }

    private void swap(int left, int right) {
        Object temp = elementData[left];
        elementData[left] = elementData[right];
        elementData[right] = temp;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("Data stored: ");

        for (int i = 0; i < size; i++) {
            str.append(elementData[i] + " . ");
        }

        return str.toString();
    }
}
