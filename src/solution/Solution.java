package solution;

import java.util.ArrayList;

public class Solution {
    private String problemName;
    private int numberOfLibsToSignUp;
    private ArrayList<LibraryOutput> libraries;

    public Solution(String problemName, int numberOfLibsToSignUp, ArrayList<LibraryOutput> libraries) {
        this.problemName = problemName;
        this.numberOfLibsToSignUp = numberOfLibsToSignUp;
        this.libraries = libraries;
    }

    public String getProblemName() {
        return problemName;
    }

    public int getNumberOfLibsToSignUp() {
        return numberOfLibsToSignUp;
    }

    public ArrayList<LibraryOutput> getLibraries() {
        return libraries;
    }
}
