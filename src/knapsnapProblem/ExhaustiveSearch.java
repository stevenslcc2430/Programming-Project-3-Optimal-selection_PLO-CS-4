package knapsnapProblem;

import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

This class performs a brute force algorithm to
compute the top 3 highest-rated valid subsets under 
the specified weight limit.
@author Julian Cloward
*****************************************************/

public class ExhaustiveSearch {
    private List<List<Experiment>> subsets;
    private List<Experiment> experiments;
    private int maxWeight;

    public ExhaustiveSearch(List<Experiment> experiments, int weight) {
        this.experiments = experiments;
        this.maxWeight = weight;
    }

    /**
     * Computes the best subsets based on highest 
     * rating whist under maxWeight.
     * 
     * @return Top 3 Experiment Subsets.
     */
    public List<List<Experiment>> getBestSubsets() {
        // TODO
        return null;
    }

    /**
     * Builds all subsets based off of all provided
     * experiments and stores them into subsets.
     */
    private void generateSubsets() {
        // TODO
    }
}
