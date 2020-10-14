import IO.InputReader;
import IO.OutputWriter;
import problem.BookReferenceSorter;
import problem.Library;
import problem.LibrarySorter;
import problem.Problem;
import solution.LibraryOutput;
import solution.Solution;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    static final String[] inputs = {"a_example", "b_read_on", "c_incunabula", "d_tough_choices", "e_so_many_books", "f_libraries_of_the_world"};
    static boolean[] booksChecked;

    public static void main(String[] args) {
        Arrays.stream(inputs).forEach(input -> {
            Problem problem = InputReader.getProblem(input);
            booksChecked = new boolean[problem.getValueBooks().size()];
            ArrayList<LibraryOutput> solution = solveProblem(problem);
            OutputWriter.writeSolution(new Solution(input, solution.size(), solution));
        });
    }

    // complexity is not optimized, take too long for huge datasets
    // too many imbricated loops
    public static ArrayList<LibraryOutput> solveProblem(Problem problem) {
        ArrayList<LibraryOutput> solution = new ArrayList<>();
        int remainingTime = problem.getTime();

        int i = 0;
        ArrayList<Integer> scannedLibs = new ArrayList<>();
        while (i <= problem.getListLibrary().size()) {
            ArrayList<Library> prioritizedLibs = orderLibs(problem.getListLibrary(), problem);

            Library libToScan = null;
            for (Library lib : prioritizedLibs) {
                if (!scannedLibs.contains(lib.getId())) {
                    libToScan = lib;
                    break;
                }
            }

            if (libToScan == null) break;

            remainingTime -= libToScan.getTime_signin();
            LibraryOutput libSol = solveProblemLib(libToScan, remainingTime, problem);
            if (libSol.getBooksId().size() > 0) solution.add(libSol);
            scannedLibs.add(libToScan.getId());
            i++;
        }
        return solution;
    }

    public static LibraryOutput solveProblemLib(Library library, int remainingTime, Problem problem) {
        ArrayList<Integer> booksScanned = new ArrayList<>();

        // order Books
        ArrayList<Integer> sortedBooksReference = library.getListBooks();
        sortedBooksReference.sort(new BookReferenceSorter(problem.getValueBooks()));

        for (int bookReference : sortedBooksReference) {
            if (!booksChecked[bookReference]) {
                remainingTime--;
                booksScanned.add(bookReference);
                booksChecked[bookReference] = true;
            }

            if (remainingTime == 0) {
                break;
            }
        }

        return new LibraryOutput(library.getId(), booksScanned.size(), booksScanned);
    }

    private static ArrayList<Library> orderLibs(ArrayList<Library> libs, Problem p) {
        for(Library l : libs) {
            l.setScore(computeScore(l,p));
        }
        libs.sort(new LibrarySorter());
        return libs;
    }

    public static int computeScore (Library l, Problem p) {
        int totalScoreBookLib = 0;
        int nbBookChecked = 0;
        for (Integer book : l.getListBooks()) {
            if (!booksChecked[book]) {
                totalScoreBookLib += p.getValueBooks().get(book);
            } else {
                nbBookChecked++;
            }
        }
        int nbBooksToScan = l.getListBooks().size()-nbBookChecked;
        if (nbBooksToScan == 0) nbBooksToScan =1;
        return ( totalScoreBookLib / (l.getTime_signin() + (l.getBook_per_day() / nbBooksToScan)));
    }
}
