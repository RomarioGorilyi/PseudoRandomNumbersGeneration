package main.java.kpi.ipt.crypt.lab1.testOfRandomSeries;

import main.java.kpi.ipt.crypt.lab1.generator.Generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Roman Horilyi on 10.10.2016.
 */
public abstract class Test {
    private static final double QUANTILE_0_99 = 2.326348;
    private static final double QUANTILE_0_95 = 1.644854;
    private static final double QUANTILE_0_9 = 1.281552;
    private static final int NUMBER_OF_GENERATED_RANDOM_NUMBERS = 1_000_000;

    private int L;
    private double statistics;

    public Test(int L) {
        this.L = L;
    }

    public double getStatistics() {
        return statistics;
    }

    public void setStatistics(double statistics) {
        this.statistics = statistics;
    }

    /**
     * Tests whether the specified sequence of numbers corresponds to a specific requirement of random numbers.
     *
     * @param statistics statistics of number sequence
     * @param quantile value of a quantile that can be found in materials devoted to mathematical statistics and theory
     *                 of probability
     * @return <code>true</code> whether the specified numbers are random
     */
    public boolean test(double statistics, double quantile) {
        return statistics <= calculateLimit(quantile);
    }

    /**
     * Tests with different alpha-parameters whether the specified generator generates random numbers.
     *
     * @param generator generator of pseudo random numbers
     */
    public void testGenerator(Generator generator) {
        generator.generateRandomNumbers(NUMBER_OF_GENERATED_RANDOM_NUMBERS);
        ArrayList<Long> randomNumbers = generator.getGeneratedRandomNumbers();
        // TODO refactor generatedRandomNumbers from Long to Integer
        // TODO refactor LehmerGenerator

        System.out.println("Tests for " + generator.getClass().getSimpleName() + ":");
        double statistics = calculateStatistics(randomNumbers);
        System.out.println("Statistics: " + statistics);
        System.out.println("alpha = 0.01: " + test(statistics, QUANTILE_0_99));
        System.out.println("alpha = 0.05: " + test(statistics, QUANTILE_0_95));
        System.out.println("alpha = 0.1: " + test(statistics, QUANTILE_0_9) + "\n");
    }

    /**
     * Calculates statistics of the specified list of numbers.
     *
     * @param list list of numbers
     * @return statistics of the specified list
     */
    public abstract double calculateStatistics(List<Long> list);

    /**
     * Calculates a limit value of the specific (X(1-a))^2 distribution with the specified value of quantile.
     *
     * @param quantile value of a quantile that can be found in materials devoted to mathematical statistics and theory
     *                 of probability
     * @return limit
     */
    public double calculateLimit(double quantile) {
        return Math.sqrt(2 * L) * quantile + L;
    }
}
