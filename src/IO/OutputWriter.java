package IO;

import solution.LibraryOutput;
import solution.Solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class OutputWriter {
    public static void writeSolution(Solution solution) {
        String data = "" + solution.getNumberOfLibsToSignUp(); // write A
        data += "\n"; // unix end of line

        for (LibraryOutput library : solution.getLibraries()) {
            data += "" + library.getId() + " " + library.getNumberOfBooksToScan();
            data += "\n";
            data += Arrays.toString(library.getBooksId().toArray())
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "");
            data += "\n";
        }


        try {
            Files.write(Paths.get("./output/" + solution.getProblemName() + ".out"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
