package IO;

import problem.Library;
import problem.Problem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputReader {
    public static Problem getProblem(String inputName) {

        ArrayList<Library> listLibrary = new ArrayList<>();
        ArrayList<Integer> valueBooks = new ArrayList<>();
        int time = 0;
        int id_library = 0;

        String input = "";
        try {
            input = new String(Files.readAllBytes(Paths.get("./input/" + inputName + ".txt"))); // get the input as a string
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] rows = input.split("\\r?\\n");
        String[] first_line = rows[0].split(" ");
        time = Integer.parseInt(first_line[2]);

        String[] second_line = rows[1].split(" ");
        for (int i = 0; i < second_line.length; i++) {
            valueBooks.add(Integer.parseInt(second_line[i]));
        }

        for (int j = 2; j < rows.length; j = j + 2) {
            first_line = rows[j].split(" ");
            second_line = rows[j + 1].split(" ");

            int signup = Integer.parseInt(first_line[1]);
            int ship = Integer.parseInt(first_line[2]);

            ArrayList<Integer> listBooks = new ArrayList<>();
            for (String s : second_line) {
                listBooks.add(Integer.parseInt(s));
            }
            Library l = new Library(id_library, signup, ship, listBooks,0);
            listLibrary.add(l);
            id_library++;
        }

        return new Problem(listLibrary, valueBooks, time);
    }
}
