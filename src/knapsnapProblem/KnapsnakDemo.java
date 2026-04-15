package knapsnapProblem;

import java.io.File;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

This is the main runner for the Knapsack problem.
It loads experiments from the CSV  and creates
a SummaryOutput which runs all strategies, the brute
force search, the DP solution, and prints a comparison.
@Julian Cloward
@Steven Benjamin
*****************************************************/

public class KnapsnakDemo {
    // path to the CSV with experiment data
    private static final String fileLocation = "src" + File.separator
        + "knapsnapProblem" + File.separator + "Experiments.csv";
    // shuttle weight limit in kg
    private static final int maxWeight = 700;

    public static void main(String[] args) {
        SummaryOutput output = new SummaryOutput(new File(fileLocation), maxWeight);
    }
}
