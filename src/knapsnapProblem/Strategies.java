package knapsnapProblem;

import java.util.ArrayList;
import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

@author Julian Cloward
*****************************************************/

public class Strategies {

    /**
     * Chooses the highest rated experiments from the given list under the specified weight.
     * 
     * @param experiments   The avalible experiments
     * @param weight        Maximum weight value
     * @return  highestRated containing highest rated experiments whist under specified weight.
     */
    public static List<Experiment> highestRating(List<Experiment> experiments, int weight) {

        // Create list of highest rated experiments
        List<Experiment> sortedRatings = new ArrayList<>();
        experiments.forEach(e -> sortedRatings.add(e));
        sortedRatings.sort((itemA, itemB) -> {
            return Integer.compare(itemB.getRating(), itemA.getRating());
        });

        // Choose the top items until weight would exceed capacity
        List<Experiment> highestRated = new ArrayList<>();
        int currentWeight = 0;
        for (Experiment experiment : sortedRatings) {
            if (currentWeight + experiment.getWeight() > weight) break;
            currentWeight += experiment.getWeight();
            highestRated.add(experiment);
        }

        return highestRated;
    }

    /**
     * Chooses the highest scored experiments from the given list under the specified weight.
     * 
     * @param experiments   The avalible experiments
     * @param weight        Maximum weight value
     * @return  highestScored containing highest scored experiments whilst under specified weight.
     */
    public static List<Experiment> highestScore(List<Experiment> experiments, int weight) {
        
        // Create list of highest scored experiments
        List<Experiment> sortedScores = new ArrayList<>();
        experiments.forEach(e -> sortedScores.add(e));
        sortedScores.sort((itemA, itemB) -> {
            return Double.compare(itemB.getScore(), itemA.getScore());
        });

        // Choose the top items until weight would exceed capacity
        List<Experiment> highestScored = new ArrayList<>();
        int currentWeight = 0;
        for (Experiment experiment : sortedScores) {
            if (currentWeight + experiment.getWeight() > weight) break;
            currentWeight += experiment.getWeight();
            highestScored.add(experiment);
        }

        return highestScored;
    }

    /**
     * Chooses the lowest weighted experiments from the given list under the specified weight.
     * 
     * @param experiments   The avalible experiments
     * @param weight        Maximum weight value
     * @return  lowestWeight containing lowest weighted experiments whilst under the specified weight.
     */
    public static List<Experiment> lightestWeight(List<Experiment> experiments, int weight) {
        // Create list of highest scored experiments
        List<Experiment> sortedWeight = new ArrayList<>();
        experiments.forEach(e -> sortedWeight.add(e));
        sortedWeight.sort((itemA, itemB) -> {
            return Double.compare(itemA.getWeight(), itemB.getWeight());
        });

        // Choose the top items until weight would exceed capacity
        List<Experiment> lowestWeight = new ArrayList<>();
        int currentWeight = 0;
        for (Experiment experiment : sortedWeight) {
            if (currentWeight + experiment.getWeight() > weight) break;
            currentWeight += experiment.getWeight();
            lowestWeight.add(experiment);
        }

        return lowestWeight;

    }
}
