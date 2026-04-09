package knapsnapProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

This class performs a brute force algorithm to
compute the top 3 highest-rated valid subsets under 
the specified weight limit.

Sources:
- Bit masking for subset generation: Codeforces
  https://codeforces.com/blog/entry/17973
- Brute force knapsack in Java using bit masking:
  Alex Klimenko, Medium
  https://medium.com/@alxkm/solving-the-knapsack-problem-a-dynamic-programming-approach-35e15e40d19b
- Knapsack brute force with bit manipulation: FinalRoundAI
  https://www.finalroundai.com/articles/knapsack-problem

@author Julian Cloward
@author Steven Benjamin
*****************************************************/

public class ExhaustiveSearch {
    private List<List<Experiment>> subsets;
    private List<Experiment> experiments;
    private int maxWeight;

    public ExhaustiveSearch(List<Experiment> experiments, int weight) {
        this.experiments = experiments;
        this.maxWeight = weight;
        this.subsets = new ArrayList<>();
    }

    /**
     * Computes the best subsets based on highest 
     * rating while under maxWeight.
     * 
     * Generates all 2^n subsets, filters out any that
     * exceed the weight limit, sorts by total rating
     * and returns top 3.
     * 
     * @return Top 3 Subsets.
     */
    public List<List<Experiment>> getBestSubsets() {
        // generate every possible combination
        generateSubsets();

        // filter out subsets that are too heavy
        List<List<Experiment>> valid = new ArrayList<>();
        for (List<Experiment> subset : subsets) {
            int totalWeight = 0;
            for (Experiment exp : subset) {
                totalWeight += exp.getWeight();
            }
            if (totalWeight <= maxWeight) {
                valid.add(subset);
            }
        }

        // Sort valid subsets by total rating
        valid.sort((a, b) -> {
            int ratingA = 0;
            for (Experiment exp : a) ratingA += exp.getRating();
            int ratingB = 0;
            for (Experiment exp : b) ratingB += exp.getRating();
            return Integer.compare(ratingB, ratingA);
        });

        // return the top 3
        int count = Math.min(3, valid.size());
        return valid.subList(0, count);
    }

    /**
     * Builds all subsets using bit masking.
     * n experiments means 2^n possible subsets.
     * Each int from 0 to 2^n - 1 is one subset
     * where each bit tells us if that experiment is included or not.
     */
    private void generateSubsets() {
        int n = experiments.size();
        // total number of subsets is 2 to the power of n
        int totalSubsets = 1 << n;

        for (int mask = 1; mask < totalSubsets; mask++) {
            List<Experiment> subset = new ArrayList<>();
            // check each bit position
            for (int bit = 0; bit < n; bit++) {
                // if the bit is set include that experiment
                if ((mask & (1 << bit)) != 0) {
                    subset.add(experiments.get(bit));
                }
            }
            subsets.add(subset);
        }
    }
}
