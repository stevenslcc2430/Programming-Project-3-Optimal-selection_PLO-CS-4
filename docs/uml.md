```mermaid
classDiagram
    class Experiment {
        -name: String
        -raiting: int
        -weight: int
        +Experiment(String, int, int)
        +getName() : String
        +getRaiting() : int
        +getScore() : double
        +getWeight() : int
    }

    class SummaryOutput {
        -Experiments : Experiment[]
        +SummaryOutput(File, int)
        -StrategiesOutput(Experiment[], int)
        -SearchOutput(Experiment[], int)
    }

    class Strategies {
        <<Interface>>
        +highestRating(Experiment[], int) : String
        +highestScore(Experiment[], int) : String
        +lightestWeight(Experiment[], int) : String
    }

    class ExhaustiveSearch {
        -experiments : Experiment[]
        -subsets : Experiment[]
        -maxWeight : int
        +ExhaustiveSearch(Experiment[], int)
        +getBestSubsets() : Experiment[]
        -generateSubsets()
    }

    class KnapsackDemo {
        -fileLocation : String
        -maxWeight : int
        +main(String[])
    }

    %% Relationships
    Experiment "0..n" --* "1" SummaryOutput : Relation
    KnapsackDemo --|> SummaryOutput : Inheritance
    SummaryOutput ..> Strategies : Dependency
    SummaryOutput ..> ExhaustiveSearch : Dependency
