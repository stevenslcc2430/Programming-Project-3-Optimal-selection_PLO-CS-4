```java
main()
    // Entry point: loads data and initializes SummaryOutput
    int maxWeight

class KnapsackDemo:
    int maxWeight
  
    main(args)
        // Setup experiment data
        // Create SummaryOutput instance

class SummaryOutput:
    list experiments   // Array of 0-12 Experiment objects
    int maxWeight
          
    SummaryOutput(experiments, maxWeight)
          
    strategiesOutput()
        // Calls Strategies methods (Rating, Weight, Score)
          
    searchOutput()
        // Calls ExhaustiveSearch and DynamicProgramming
          
    comparisonSummary()
        // Compares results from all methods

class Strategies:
    #  Logic for selection criteria
    highestRating(experiments, limit)
        return list of experiments
    lightestWeight(experiments, limit)
        return list of experiments
    highestScore(experiments, limit)
        return list of experiments

class ExhaustiveSearch:
    list experiments
    list validSubsets  // 2D list of valid combinations
    int maxWeight

    ExhaustiveSearch(experiments, maxWeight)

    getBestSubsets()
        return best validSubsets

    generateSubsets()
        // Recursively find all possible combinations

    filterByWeight()
        // Remove subsets exceeding maxWeight

class DynamicProgramming:
    list experiments
    int maxWeight

    DynamicProgramming(experiments, maxWeight)

    solve()
        buildTable()
        return traceback()

    buildTable()
        // Create the DP for the knapsack problem

    traceback()
        // Determine which items were selected from the table

class Experiment:
    string name
    int rating
    int weight

    getName()
    getRating()
    getScore()
    getWeight()
```
