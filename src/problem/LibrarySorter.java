package problem;

import java.util.Comparator;

public class LibrarySorter implements Comparator<Library>
{
    @Override
    public int compare(Library o1, Library o2) {
        return Integer.valueOf(o2.getScore()).compareTo(Integer.valueOf(o1.getScore()));
    }
}
