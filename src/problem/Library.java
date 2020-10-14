package problem;

import java.util.ArrayList;

public class Library {

    private int id;
    private int time_signin;
    private int book_per_day;
    private int score;
    private ArrayList<Integer> listBooks;

    public Library(int id, int time_signin, int book_per_day, ArrayList<Integer> listBooks, int score) {
        this.id = id;
        this.time_signin = time_signin;
        this.book_per_day = book_per_day;
        this.listBooks = listBooks;
    }

    public int getId() {
        return id;
    }

    public int getTime_signin() {
        return time_signin;
    }

    public int getBook_per_day() {
        return book_per_day;
    }

    public ArrayList<Integer> getListBooks() {
        return listBooks;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
