package knapsnapProblem;

import java.io.File;
import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

This class is used to display the best valid subsets
from different greedy strategies and an exhaustive
search. This class displays a summary reflecting on
which greedy strategies worked and what didn't.
@author Julian Cloward
*****************************************************/

public class SummaryOutput {
    private List<Experiment> experiments;       // List of every available experiment.
    private int maxWeight;                      // Maximum weight which every valid subset must be equal or less than.
    private String summary = "[INPUT SUMMARY]"; // TODO One short paragraph reflecting on what worked, what didn’t, what was most interesting.

    /**
     * Displays all subset results from exaustive 
     * search and greedy strategies.
     * 
     * @param experimentFile    File location for experiment data
     * @param maxWeight         Max weight which all valid subsets must be under
     */
    public SummaryOutput(File experimentFile, int maxWeight) {
        this.experiments = Experiment.experimentsFromCSV(experimentFile);
        this.maxWeight = maxWeight;

        strategiesOutput();
        searchOutput();

        System.out.println("-----------------SUMMARY-----------------");
        System.out.println(summary);
    }

    /**
     * Outputs all greedy knapsnack strategies from Strategies.java
     */
    private void strategiesOutput() {
        System.out.println("------------Greedy Strategies------------");
        System.out.println( "Highest Rating:");
        formatAndDisplay(Strategies.highestRating(experiments,  maxWeight));
        System.out.println("Lightest Weight:");
        formatAndDisplay(Strategies.lightestWeight(experiments, maxWeight));
        System.out.println(  "Highest Score:");
        formatAndDisplay(Strategies.highestScore(experiments,   maxWeight));
    }

    /**
     * Outputs top 3 subsets found from an exhaustive search.
     */
    private void searchOutput() {
        ExhaustiveSearch es = new ExhaustiveSearch(experiments, maxWeight);
        System.out.println("------------Exhaustive Search------------");
        es.getBestSubsets().forEach(subset -> formatAndDisplay(subset));
    }

    /**
     * Displays all elements within the given list in a readable format.
     * 
     * @param experiments   The experiments to display
     */
    public void formatAndDisplay(List<Experiment> experiments) {
        int totalWeight = 0, totalRating = 0;
        for (int i = 0; i < experiments.size(); i++) {
            if (i != 0) System.out.println(", ");
            totalWeight += experiments.get(i).getWeight();
            totalRating += experiments.get(i).getRating();
            System.out.print(experiments.get(i).getName());
        }
        System.out.println("\nTotal Weight: " + totalWeight + " Total Rating: " + totalRating + "\n");
    } 
}
