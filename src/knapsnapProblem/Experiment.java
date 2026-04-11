package knapsnapProblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/****************************************************
Group 5
Julian Cloward, Steven Benjamin, Theodore Tran
CS-2430-502 Spring 2026
Programming Project 3

This class is used to represent the details including
the requirements and value of an experiment as well as
including a computed score. 
@author Julian Cloward
*****************************************************/

public class Experiment {
    private String name;        // Name of the experiment
    private int rating, weight; // Value and requirement

    /**
     * Gets all the experiments from a CSV file, 
     * builds and array, and returns it.
     * 
     * @param file  CSV file containing experiments
     * @return All experiments within the CSV file.
     */
    public static List<Experiment> experimentsFromCSV(File file) {
        List<Experiment> experiments = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                line = line.trim();
                String[] contents = line.split(",");
                experiments.add(new Experiment(contents[0], 
                             Integer.parseInt(contents[2]),
                             Integer.parseInt(contents[1])));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return experiments;
    }
  
    public Experiment(String name, int rating, int weight) {
        this.name = name;
        this.rating = rating;
        this.weight = weight;
    }
    
    /**
     * Return the name of the experiment.
     * 
     * @return name as a String.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Return the raiting of the experiment.
     * 
     * @return raiting as an int.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Return the computed score of the experiment.
     * 
     * @return computed score as a double.
     */
    public double getScore() {
        return (double) rating / weight;
    }
    
    /**
     * Returns the weight requirement of the experiment.
     * 
     * @return weight as an int.
     */
    public int getWeight() {
        return weight;
    }
}