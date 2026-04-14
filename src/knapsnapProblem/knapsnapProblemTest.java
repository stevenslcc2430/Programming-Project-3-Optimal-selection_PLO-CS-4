package knapsnapProblem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

Tests the 3 Greedy Strategies and Exhaustive Search 
for correctness through sanity checks and comparing
the results with hard-coded data.

@author Theodore Tran
*****************************************************/
public class knapsnapProblemTest {

	public static void main(String[] args) {
		// Setup data for strategy program runs.
		String fileLocation = "src" + File.separator
		        + "knapsnapProblem" + File.separator + "Experiments.csv";
		List<Experiment> experiments = Experiment.experimentsFromCSV(fileLocation);
		int maxWeight = 700;
		
		// Runs all strategies and stores their results to be compared.
		ExhaustiveSearch es = new ExhaustiveSearch(experiments, maxWeight);
		// Brute Force
		List<Experiment> searchResult = es.getBestSubsets();
		// 3 Greedy Strategies
		List<Experiment> ratingResult = Strategies.highestRating(experiments, maxWeight);
		List<Experiment> scoreResult = Strategies.highestScore(experiments, maxWeight);
		List<Experiment> weightResult = Strategies.lightestWeight(experiments, maxWeight);
		
		// Compares the greedy strategies to the exhaustive search.
		if (ratingResult.compareTo(searchResult)) System.out.println("Highest Rating matches Exhaustive Search."); 
			else System.out.println("Highest Rating and Exhaustive Search have different results.");
		if (weightResult.compareTo(searchResult)) System.out.println("Lightest Weight matches Exhaustive Search."); 
			else System.out.println("Lightest Weight and Exhaustive Search have different results.");
		if (scoreResult.compareTo(searchResult)) System.out.println("Highest Score matches Exhaustive Search."); 
			else System.out.println("Highest Score and Exhaustive Search have different results.");
		
		// TODO Compares the greedy strategies with hard-coded data (with explanations for hard-coded data).
		// TODO Rating (Highest to Lowest): Solar Flares, Micrometeorites, Binary Stars.
		/* Explanation: 
		 * Weight: 264 + 170 + 203 = 637. 637 < 700. Adding 104 (Relativity) would result in 741 and 741 > 700.
		 * Rating: 26 = 9 + 9 + 8.
		 */
		// TODO Weight (Lightest to Heaviest): Seed Viability, Yeast Fermentation, Cloud Patterns, Mice Tumors, 
		// Microgravity Plant Growth, Cosmic Rays, Sun Spots, Relativity, Micrometeorites.
		/* Explanation: 
		 * Weight: 654 = 7 + 27 + 36 + 65 + 75 + 80 + 90 + 104 + 170. 654 < 700. Adding 188 (Solar Power) 
		 * would result in 842 and 842 > 700.
		 * Rating: 52 = 4 + 4 + 5 + 8 + 5 + 7 + 2 + 8 + 9.
		 */
		// TODO Score (Highest to Lowest): Sun Spots, Solar Power, Solar Flares, Binary Stars, Micrometeorites,
		// Microgravity Plant Growth, Relativity.
		/* Explanation: 
		 * Weight: ~681.70833 = 90/2 + 188/6 + 264/9 + 203/8 + 170/9 + 75/5 + 104/8
		 * = 90 + 188 + 29.33333 + 25.375 + 170 + 75 + 104. 681.70833 < 700. Adding 80 (Cosmic Rays) would 
		 * result in 761.708 and 761.708 > 700.
		 * Rating: 47 = 2 + 6 + 9 + 8 + 9 + 5 + 8.
		 */
	}

}
