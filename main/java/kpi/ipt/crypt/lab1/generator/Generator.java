package main.java.kpi.ipt.crypt.lab1.generator;

import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 29.09.2016.
 */
public abstract class Generator {
    private ArrayList<Long> generatedRandomNumbers = new ArrayList<>();

    public ArrayList<Long> getGeneratedRandomNumbers() {
        return generatedRandomNumbers;
    }

    public void setGeneratedRandomNumbers(ArrayList<Long> generatedRandomNumbers) {
        this.generatedRandomNumbers = generatedRandomNumbers;
    }

    public abstract long generateRandomNumber();

    /**
     * Generates a specified number of random values and adds them to the <code>generatedRandomNumbers</code> arrayList.
     *
     * @param quantity number of random values that have to be generated
     */
    public void generateRandomNumbers(int quantity) {
        generatedRandomNumbers = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            addToGeneratedRandomNumbers(generateRandomNumber());
        }
    }

    /**
     * Adds the specified random number to the <code>generatedRandomNumbers</code> arrayList.
     *
     * @param randomNumber random number that is added to the list
     */
    public void addToGeneratedRandomNumbers(long randomNumber) {
        generatedRandomNumbers.add(randomNumber);
    }

    public void printGeneratedRandomNumbers() {
        for (long random : getGeneratedRandomNumbers()) {
            System.out.print(random + " ");
        }
    }
}
