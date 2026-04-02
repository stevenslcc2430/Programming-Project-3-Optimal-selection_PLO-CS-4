package knapsnapProblem;

import java.io.File;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

TODO - Class description
*****************************************************/

public class KnapsnackDemo {
    private static final String fileLocation = "src\\knapsnapProblem\\Experiments.csv";
    private static final int maxWeight = 700;
    public static void main(String[] args) {
        SummaryOutput output = new SummaryOutput(new File(fileLocation), maxWeight);
    }
}
