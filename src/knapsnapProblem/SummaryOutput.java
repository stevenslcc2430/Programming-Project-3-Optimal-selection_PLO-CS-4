package knapsnapProblem;
import java.io.File;
import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

TODO - Class description
@author Julian Cloward
*****************************************************/

public class SummaryOutput {
    private List<Experiment> experiments;
    private int maxWeight;
    private String summary = "[INPUT SUMMARY]";

    public SummaryOutput(File experimentFile, int maxWeight) {
        this.experiments = Experiment.experimentsFromCSV(experimentFile);
        this.maxWeight = maxWeight;

        strategiesOutput();
        searchOutput();

        System.out.println("-----------------SUMMARY-----------------");
        System.out.println(summary);
    }

    private void strategiesOutput() {
        System.out.println("------------Greedy Strategies------------");
        formatAndDisplay(Strategies.highestRating(experiments,  maxWeight));
        formatAndDisplay(Strategies.lightestWeight(experiments, maxWeight));
        formatAndDisplay(Strategies.highestScore(experiments,   maxWeight));
    }

    private void searchOutput() {
        ExhaustiveSearch es = new ExhaustiveSearch(experiments, maxWeight);
        System.out.println("------------Exhaustive Search------------");
        es.getBestSubsets().forEach(subset -> formatAndDisplay(subset));
    }

    public void formatAndDisplay(List<Experiment> experiments) {
        int totalWeight = 0, totalRating = 0;
        for (int i = 0; i < experiments.size(); i++) {
            if (i != 0) System.out.println(", ");
            totalWeight += experiments.get(i).getWeight();
            totalRating += experiments.get(i).getRating();
            System.out.print(experiments.get(i).getName());
        }
        System.out.println("\nTotal Weight: " + totalWeight + " Total Rating: " + totalRating);
    } 
}
