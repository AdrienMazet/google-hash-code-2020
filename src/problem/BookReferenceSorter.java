package problem;

import java.util.ArrayList;
import java.util.Comparator;


public class BookReferenceSorter implements Comparator<Integer>
{
    private ArrayList<Integer> valueBooks;
    public BookReferenceSorter(ArrayList<Integer> v) {
        this.valueBooks = v;
    }

    @Override
    public int compare(Integer i1, Integer i2) {
        return Integer.valueOf(valueBooks.get(i2)).compareTo(Integer.valueOf(valueBooks.get(i1)));
    }
}
