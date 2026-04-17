# Task Index

Maps source files and sections to GitHub Issues at:
https://github.com/stevenslcc2430/Programming-Project-3-Optimal-selection_PLO-CS-4/issues

---

## Task 1: Project Management and Documentation
- `CONTRIBUTIONS.md`
- `README.md`
- `docs/` folder (project plan, pseudocode, UML, scope)

## Task 2: Infrastructure and Data Setup
- `src/knapsnapProblem/Experiment.java` : data class with name, weight, rating, score
- `src/knapsnapProblem/Experiment.java` : `experimentsFromCSV()` loads the 12 records
- `src/knapsnapProblem/Experiments.csv` : the 12 experiment records
- All `.java` files include the mandatory team header block

## Task 3: Part 1 - Greedy Strategies Implementation
- `src/knapsnapProblem/Strategies.java` : `highestRating()` sorts by rating descending, greedy pick
- `src/knapsnapProblem/Strategies.java` : `lightestWeight()` sorts by weight ascending, greedy pick
- `src/knapsnapProblem/Strategies.java` : `highestScore()` sorts by ratio descending, greedy pick
- Bug fix: all three methods used `break` when an item did not fit, which stopped
  the loop entirely instead of skipping to the next item. Changed to `if` check
  so lighter items further down the list still get picked up.

## Task 4: Part 2 - Brute Force Exhaustive Search
- `src/knapsnapProblem/ExhaustiveSearch.java` : `generateSubsets()` uses bit masking for all 4096 combos
- `src/knapsnapProblem/ExhaustiveSearch.java` : `getBestSubsets()` filters by weight, sorts by rating, returns top 3
- `src/knapsnapProblem/SummaryOutput.java` : `searchOutput()` displays top 3 and marks #1 as OPTIMAL

## Task 5: Part 3 - Comparison Summary and Output
- `src/knapsnapProblem/SummaryOutput.java` : `comparisonSummary()` prints all ratings side by side
- `src/knapsnapProblem/SummaryOutput.java` : marks which greedy strategies matched the optimal

## Task 6: Part 4 - Dynamic Programming (Extra Credit)
- `src/knapsnapProblem/DynamicProgramming.java` : `buildTable()` constructs the DP table
- `src/knapsnapProblem/DynamicProgramming.java` : `traceback()` identifies chosen experiments
- `src/knapsnapProblem/DynamicProgramming.java` : pseudocode in the class header describes the subproblem logic
- `src/knapsnapProblem/SummaryOutput.java` : `dpOutput()` runs and displays the DP result

## Task 7: Quality Assurance and Verification
- `src/knapsnapProblem/knapsnapProblemTest.java` : tests all strategies against hand-calculated values
- `src/knapsnapProblem/knapsnapProblemTest.java` : edge cases (weight=0, weight=99999)
- `src/knapsnapProblem/knapsnapProblemTest.java` : cross-check DP matches brute force
- Bug found: Strategies used `break` instead of skip. Fixed and retested.

## Tasks 8 and 9: Report and Screencast (documentation only, no code)

| Task | Deliverable |
|------|-------------|
| 8. Team Report Development | Separate report file (PDF or DOCX, not in zip) |
| 9. Screencast and Packaging | Separate video file or link |
