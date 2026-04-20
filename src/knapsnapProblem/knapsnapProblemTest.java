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

@author Theodore Tran & Julian Cloward
*****************************************************/
public class knapsnapProblemTest {

	public static void main(String[] args) {
		// Setup data for strategy program runs.
		String fileLocation = "src" + File.separator
		        + "knapsnapProblem" + File.separator + "Experiments.csv";
		List<Experiment> experiments = Experiment.experimentsFromCSV(new File(fileLocation));
		int maxWeight = 700;
		
		// Runs all strategies and stores their results to be compared.
		ExhaustiveSearch es = new ExhaustiveSearch(experiments, maxWeight);
		// Brute Force
		List<Experiment> searchResult = es.getBestSubsets().getFirst();
		// 3 Greedy Strategies
		List<Experiment> ratingResult = Strategies.highestRating(experiments, maxWeight);
		List<Experiment> scoreResult = Strategies.highestScore(experiments, maxWeight);
		List<Experiment> weightResult = Strategies.lightestWeight(experiments, maxWeight);
		
		// Compares the greedy strategies to the exhaustive search.
		// These tests are not necessary as all strategies will have different results anyway.
		/* 
		System.out.println("-----------------Greedy Strategies vs. Exhaustive Search-----------------");
		if (ratingResult.containsAll(searchResult)) System.out.println(
				"Highest Rating matches Exhaustive Search."); 
			else System.out.println("Highest Rating and Exhaustive Search have different results.");
		if (weightResult.containsAll(searchResult)) System.out.println(
				"Lightest Weight matches Exhaustive Search."); 
			else System.out.println("Lightest Weight and Exhaustive Search have different results.");
		if (scoreResult.containsAll(searchResult)) System.out.println(
				"Highest Score matches Exhaustive Search."); 
			else System.out.println("Highest Score and Exhaustive Search have different results.");
		*/
		
		
		
		// Compares the greedy strategies with hard-coded data (with explanations for hard-coded data).
		System.out.println("\n-----------------Greedy Strategies vs. Hard-Coded Data-----------------");
		/* Rating (Highest to Lowest)
		 * Solar Flares, Micrometeorites, Binary Stars.
		 * 
		 * Hard-Coded Data Explanation: 
		 * Weight: 264 + 170 + 203 = 637. 637 < 700. 
		 * 		Adding 104 (Relativity) would result in 741 and 741 > 700.
		 * Rating: 26 = 9 + 9 + 8.
		 */
		List<Experiment> ratingData = new ArrayList<>();
		ratingData.add(new Experiment("Solar Flares", 9, 264));
		ratingData.add(new Experiment("Micrometeorites", 9, 170));
		ratingData.add(new Experiment("Binary Stars", 8, 203));
		if (ratingResult.containsAll(ratingData)) System.out.println(
				"Highest Rating matches Hard-Coded Data."); 
			else System.out.println("Highest Rating and Hard-Coded Data have different results.");
		/* Weight (Lightest to Heaviest)
		 * Seed Viability, Yeast Fermentation, Cloud Patterns, Mice Tumors, Microgravity Plant Growth,
		 * Cosmic Rays, Sun Spots, Relativity, Micrometeorites.
		 * 
		 * Hard-Coded Data Explanation: 
		 * Weight: 654 = 7 + 27 + 36 + 65 + 75 + 80 + 90 + 104 + 170. 654 < 700. 
		 * 		Adding 188 (Solar Power) would result in 842 and 842 > 700.
		 * Rating: 52 = 4 + 4 + 5 + 8 + 5 + 7 + 2 + 8 + 9.
		 */
		List<Experiment> weightData = new ArrayList<>();
		weightData.add(new Experiment("Seed Viability", 4, 7));
		weightData.add(new Experiment("Yeast Fermentation", 4, 27));
		weightData.add(new Experiment("Cloud Patterns", 5, 36));
		weightData.add(new Experiment("Mice Tumors", 8, 65));
		weightData.add(new Experiment("Microgravity Plant Growth", 5, 75));
		weightData.add(new Experiment("Cosmic Rays", 4, 27));
		weightData.add(new Experiment("Sun Spots", 2, 90));
		weightData.add(new Experiment("Relativity", 8, 104));
		weightData.add(new Experiment("Micrometeorites", 9, 170));
		if (weightResult.containsAll(weightData)) System.out.println(
				"Lightest Weight matches Hard-Coded Data."); 
			else System.out.println("Lightest Weight and Hard-Coded Data have different results.");
		/* Score (Highest to Lowest)
		 * Sun Spots, Solar Power, Solar Flares, Microgravity Plant Growth, Cosmic Rays
		 * 
		 * Hard-Coded Data Explanation: 
		 * Weight: 697 = 90 + 188 + 264 + 75 + 80
		 * 		Adding the next highest-scoring experiment, 203 (Binary Stars), would result in 
		 *		90 + 188 + 264 + 203 = 745 and 745 > 700. So, 90 + 188 + 264 = 542 and 
		 *		700 - 542 = 158. The next highest-scoring experiment with a weight less than
		 *		158 is Microgravity Plant Growth (weight 75, rating 5). Adding that experiment, 
		 *		the weight then becomes 542 + 75 = 617. Then, repeating the process, adding 
		 *		Cosmic Rays (weight 80, rating 7) results in the total weight 697. 
		 *		There are no other experiments with weight less than or equal to 3,
		 *		so the weight and rating are calculated based on those five experiments.
		 * Rating: 29 = 2 + 6 + 9 + 5 + 7.
		 */
		List<Experiment> scoreData = new ArrayList<>();
		scoreData.add(new Experiment("Sun Spots", 2, 90));
		scoreData.add(new Experiment("Solar Power", 6, 188));
		scoreData.add(new Experiment("Solar Flares", 9, 264));
		scoreData.add(new Experiment("Microgravity Plant Growth", 5, 75));
		scoreData.add(new Experiment("Cosmic Rays", 7, 80));
		if (scoreResult.containsAll(scoreData)) System.out.println(
				"Highest Score matches Hard-Coded Data."); 
			else System.out.println("Highest Score and Hard-Coded Data have different results.");
		
		
		
		// Edge Cases: Tests empty list for program integrity.
		System.out.println("\n-----------------Edge Cases: Empty List-----------------");
		List<Experiment> emptyList = new ArrayList<>();
		
		System.out.println("Highest Rating: ");
		System.out.println("1. Empty List & Regular Weight: ");
		try {
			Strategies.highestRating(emptyList, maxWeight);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("2. Regular List & 0 Weight: ");
		try {
			Strategies.highestRating(experiments, 0);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("3. Empty List & 0 Weight: ");
		try {
			Strategies.highestRating(emptyList, 0);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		
		System.out.println("\nLightest Weight: ");
		System.out.println("1. Empty List & Regular Weight: ");
		try {
			Strategies.lightestWeight(emptyList, maxWeight);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("2. Regular List & 0 Weight: ");
		try {
			Strategies.lightestWeight(experiments, 0);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("3. Empty List & 0 Weight: ");
		try {
			Strategies.lightestWeight(emptyList, 0);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		
		System.out.println("\nHighest Score: ");
		System.out.println("1. Empty List & Regular Weight: ");
		try {
			Strategies.highestScore(emptyList, maxWeight);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("2. Regular List & 0 Weight: ");
		try {
			Strategies.highestScore(experiments, 0);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("3. Empty List & 0 Weight: ");
		try {
			Strategies.highestScore(emptyList, 0);
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		
		System.out.println("\nExhaustive Search: ");
		System.out.println("1. Empty List & Regular Weight: ");
		try {
			List<Experiment> exhaustiveSearchTest1 = new ExhaustiveSearch(emptyList, maxWeight);
			exhaustiveSearchTest1.getBestSubsets();
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("2. Regular List & 0 Weight: ");
		try {
			List<Experiment> exhaustiveSearchTest2 = new ExhaustiveSearch(experiments, 0);
			exhaustiveSearchTest2.getBestSubsets();
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("3. Empty List & 0 Weight: ");
		try {
			List<Experiment> exhaustiveSearchTest3 = new ExhaustiveSearch(emptyList, 0);
			exhaustiveSearchTest3.getBestSubsets();
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		
		System.out.println("\nDynamic Programming: ");
		System.out.println("1. Empty List & Regular Weight: ");
		try {
			List<Experiment> dynamicProgrammingTest1 = new DynamicProgramming(emptyList, maxWeight);
			dynamicProgrammingTest1.solve();
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("2. Regular List & 0 Weight: ");
		try {
			List<Experiment> dynamicProgrammingTest2 = new DynamicProgramming(experiments, 0);
			dynamicProgrammingTest2.solve();
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
		System.out.println("3. Empty List & 0 Weight: ");
		try {
			List<Experiment> dynamicProgrammingTest3 = new DynamicProgramming(emptyList, 0);
			dynamicProgrammingTest3.solve();
			System.out.print("Pass");
		} catch (Exception e) {
			System.out.print("Fail");
		}
	}

}
