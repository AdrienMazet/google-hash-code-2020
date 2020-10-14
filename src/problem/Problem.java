package problem;

import java.util.ArrayList;

public class Problem {

    private ArrayList<Library> listLibrary = new ArrayList<>();
    private ArrayList<Integer> valueBooks = new ArrayList<>();
    private int time;

    public Problem(ArrayList<Library> l, ArrayList<Integer> v, int t) {
        this.listLibrary = l;
        this.valueBooks = v;
        this.time = t;
    }

    public ArrayList<Library> getListLibrary() {
        return listLibrary;
    }

    public ArrayList<Integer> getValueBooks() {
        return valueBooks;
    }

    public int getTime() {
        return time;
    }
}
