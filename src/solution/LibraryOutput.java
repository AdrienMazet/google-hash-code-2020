package solution;

import java.util.ArrayList;

public class LibraryOutput {
    private int id;
    private int numberOfBooksToScan;
    private ArrayList<Integer> booksId;

    public LibraryOutput(int id, int numberOfBooksToScan, ArrayList<Integer> booksId) {
        this.id = id;
        this.numberOfBooksToScan = numberOfBooksToScan;
        this.booksId = booksId;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfBooksToScan() {
        return numberOfBooksToScan;
    }

    public ArrayList<Integer> getBooksId() {
        return booksId;
    }
}
