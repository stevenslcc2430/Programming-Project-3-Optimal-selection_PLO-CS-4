package knapsnapProblem;

import java.util.ArrayList;
import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

This solves the Knapsack problem using
dynamic programming by building a 2D table where each
cell represents the best rating possible using the
first i items with a weight capacity of w. Then it
traces back through the table to find which experiments
were selected.

DP Subproblem Logic (pseudocode):
  dp[i][w] = the maximum total rating using experiments
              0 through i-1 with weight capacity w

  Base case:
    dp[0][w] = 0 for all w (no items means zero rating)
    dp[i][0] = 0 for all i (zero capacity means nothing fits)

  Recursion:
    if weight[i-1] > w:
      dp[i][w] = dp[i-1][w]       // item i does not fit
    else:
      dp[i][w] = max(
        dp[i-1][w],                // skip item i
        dp[i-1][w - weight[i-1]] + rating[i-1]  // take item i
      )

  The answer is dp[n][maxWeight], n is the number of items.
  Traceback walks back from dp[n][maxWeight] to find which
  items were actually chosen.

Compared to brute force (O(2^n) time), DP runs in O(n * W) time
where n is the number of items and W is the max weight.

Sources:
- Java knapsack DP implementation: Baeldung
  https://www.baeldung.com/java-knapsack
- Knapsack DP table and traceback: Alex Klimenko, Medium
  https://medium.com/@alxkm/solving-the-knapsack-problem-a-dynamic-programming-approach-35e15e40d19b
- 0/1 Knapsack DP approach: InterviewBit
  https://www.interviewbit.com/blog/0-1-knapsack-problem/

@author Steven Benjamin
*****************************************************/

public class DynamicProgramming {
    private List<Experiment> experiments;
    private int maxWeight;
    private int[][] dp; // the DP table

    public DynamicProgramming(List<Experiment> experiments, int maxWeight) {
        this.experiments = experiments;
        this.maxWeight = maxWeight;
    }

    /**
     * Run the DP algorithm and return the best subset.
     * 
     * @return list of experiments in the optimal solution
     */
    public List<Experiment> solve() {
        buildTable();
        return traceback();
    }

    /**
     * Builds the table. Rows represent experiments (0 to n),
     * columns are weight max (0 to maxWeight).
     * Each cell holds the best total rating achievable.
     */
    private void buildTable() {
        int n = experiments.size();
        dp = new int[n + 1][maxWeight + 1];

        // fill the table row by row
        for (int i = 1; i <= n; i++) {
            Experiment exp = experiments.get(i - 1);
            int w = exp.getWeight();
            int r = exp.getRating();

            for (int cap = 0; cap <= maxWeight; cap++) {
                // default: do not take this item
                dp[i][cap] = dp[i - 1][cap];

                // if it fits, check if taking it gives a better rating
                if (w <= cap) {
                    int withItem = dp[i - 1][cap - w] + r;
                    if (withItem > dp[i][cap]) {
                        dp[i][cap] = withItem;
                    }
                }
            }
        }
    }

    /**
     * Walk backwards through the table to figure out
     * which experiments were included in the solution.
     * If the value at dp[i][cap] is different from dp[i-1][cap],
     * it means item i was taken.
     * 
     * @return list of chosen experiments
     */
    private List<Experiment> traceback() {
        List<Experiment> chosen = new ArrayList<>();
        int n = experiments.size();
        int cap = maxWeight;

        for (int i = n; i >= 1; i--) {
            // if the value changed from the row above, this item was taken
            if (dp[i][cap] != dp[i - 1][cap]) {
                Experiment exp = experiments.get(i - 1);
                chosen.add(exp);
                cap -= exp.getWeight();
            }
        }
        return chosen;
    }

    /**
     * Return the best possible total rating found by DP``.
     * Must call solve() first.
     * 
     * @return optimal total rating
     */
    public int getOptimalRating() {
        return dp[experiments.size()][maxWeight];
    }
}
