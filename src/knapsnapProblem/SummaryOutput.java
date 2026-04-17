package knapsnapProblem;

import java.io.File;
import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

This class ties together all four parts of the project.
It loads the experiment data, runs each greedy strategy,
runs the brute force exhaustive search, runs the dynamic
programming solution, and prints a comparison summary
showing which strategies matched the optimal result.
@author Julian Cloward
*****************************************************/

public class SummaryOutput {
    private List<Experiment> experiments;       // List of every available experiment.
    private int maxWeight;                      // Maximum weight which every valid subset must be equal or less than.

    // store total ratings from each strategy for the comparison
    private int ratingHighest, ratingLightest, ratingScore;
    private int ratingBruteForce, ratingDP;

    /**
     * Displays all subset results from exhaustive 
     * search and greedy strategies, then prints
     * a comparison summary.
     * 
     * @param experimentFile    File location for experiment data
     * @param maxWeight         Max weight which all valid subsets must be under
     */
    public SummaryOutput(File experimentFile, int maxWeight) {
        this.experiments = Experiment.experimentsFromCSV(experimentFile);
        this.maxWeight = maxWeight;

        strategiesOutput();
        searchOutput();
        dpOutput();
        comparisonSummary();
    }

    /**
     * Outputs all greedy knapsack strategies from Strategies.java
     */
    private void strategiesOutput() {
        System.out.println("============ Greedy Strategies ============");

        System.out.println("\n--- Highest Rating First ---");
        List<Experiment> hr = Strategies.highestRating(experiments, maxWeight);
        ratingHighest = formatAndDisplay(hr);

        System.out.println("\n--- Lightest Weight First ---");
        List<Experiment> lw = Strategies.lightestWeight(experiments, maxWeight);
        ratingLightest = formatAndDisplay(lw);

        System.out.println("\n--- Best Rating-to-Weight Ratio ---");
        List<Experiment> hs = Strategies.highestScore(experiments, maxWeight);
        ratingScore = formatAndDisplay(hs);
    }

    /**
     * Outputs top 3 subsets found from an exhaustive search.
     * Marks the first one as the optimal solution.
     */
    private void searchOutput() {
        ExhaustiveSearch es = new ExhaustiveSearch(experiments, maxWeight);
        List<List<Experiment>> best = es.getBestSubsets();

        System.out.println("\n============ Exhaustive Search ============");
        for (int i = 0; i < best.size(); i++) {
            if (i == 0) {
                System.out.println("\n--- #1 (OPTIMAL) ---");
            } else {
                System.out.println("\n--- #" + (i + 1) + " ---");
            }
            int rating = formatAndDisplay(best.get(i));
            if (i == 0) {
                ratingBruteForce = rating;
            }
        }
    }

    /**
     * Runs the dynamic programming solution and displays its result.
     */
    private void dpOutput() {
        DynamicProgramming dpSolver = new DynamicProgramming(experiments, maxWeight);
        List<Experiment> chosen = dpSolver.solve();

        System.out.println("\n============ Dynamic Programming ============");
        System.out.println("\n--- DP Optimal Solution ---");
        ratingDP = formatAndDisplay(chosen);
    }

    /**
     * Prints a comparison summary showing which strategies
     * matched the brute force optimal result and which did not.
     */
    private void comparisonSummary() {
        System.out.println("\n================ SUMMARY ================");
        System.out.println("Brute Force Optimal Rating: " + ratingBruteForce);
        System.out.println("DP Optimal Rating:          " + ratingDP);
        System.out.println();

        System.out.println("Highest Rating First:       " + ratingHighest
            + (ratingHighest == ratingBruteForce ? "  << MATCHES OPTIMAL" : "  (does not match)"));

        System.out.println("Lightest Weight First:      " + ratingLightest
            + (ratingLightest == ratingBruteForce ? "  << MATCHES OPTIMAL" : "  (does not match)"));

        System.out.println("Best Ratio First:           " + ratingScore
            + (ratingScore == ratingBruteForce ? "  << MATCHES OPTIMAL" : "  (does not match)"));

        System.out.println("==========================================");
    }

    /**
     * Displays all elements within the given list in a readable format.
     * Returns the total rating so the caller can store it for comparison.
     * 
     * @param experiments   The experiments to display
     * @return total rating of the displayed experiments
     */
    public int formatAndDisplay(List<Experiment> experiments) {
        int totalWeight = 0, totalRating = 0;
        for (int i = 0; i < experiments.size(); i++) {
            if (i != 0) System.out.print(", ");
            System.out.print(experiments.get(i).getName());
            totalWeight += experiments.get(i).getWeight();
            totalRating += experiments.get(i).getRating();
        }
        System.out.println();
        System.out.println("Total Weight: " + totalWeight + " kg | Total Rating: " + totalRating);
        return totalRating;
    } 
}
