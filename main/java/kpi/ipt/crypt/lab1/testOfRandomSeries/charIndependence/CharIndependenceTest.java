package main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.charIndependence;

import main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Roman Horilyi on 10.10.2016.
 */
public class CharIndependenceTest extends Test{
    public CharIndependenceTest() {
        super(255 * 255);
    }

    @Override
    public double calculateStatistics(List<Long> generatedNumbers) {
        int numberOfPairs = generatedNumbers.size() / 2;

        Map<Integer, Integer> frequencyOfPairs = calculateFrequencyOfPairs(generatedNumbers);
        Map<Integer, Integer> frequencyOfFirstBytes = calculateFrequencyOfFirstBytes(frequencyOfPairs);
        Map<Integer, Integer> frequencyOfSecondBytes = calculateFrequencyOfSecondBytes(frequencyOfPairs);

        double sum = 0;
        for (int i = 0; i < 256; i++) {
            double sumByFirstByte = 0;
            for (int j = 0; j < 256; j++) {
                if ((frequencyOfPairs.get(i + j * 256) != 0) && (frequencyOfSecondBytes.get(j) != 0)) {
                    sumByFirstByte += (double) (frequencyOfPairs.get(i + j * 256) * frequencyOfPairs.get(i + j * 256))
                            / frequencyOfSecondBytes.get(j);
                }
            }
            if (frequencyOfFirstBytes.get(i) != 0) {
                sum += sumByFirstByte / frequencyOfFirstBytes.get(i);
            }
        }

        return numberOfPairs * (sum - 1);
    }

    /**
     * Calculates frequency of pair occurrences in the specified list.
     * Pairs of numbers are gradual and non-intersectable.
     *
     * @param list list of numbers
     * @return map that contains integer representation of a pair of numbers as a <code>K</code>
     * and its frequency of occurrences as a <code>V</code>
     */
    private Map<Integer, Integer> calculateFrequencyOfPairs(List<Long> list) {
        Map<Integer, Integer> frequencyOfPairs = new HashMap<>();

        for (int i = 0; i < 256 * 256; i++) {
            frequencyOfPairs.put(i, 0);
        }

        for (int i = 0; i < list.size() - 1; i += 2) {
            int pairRepresentation = (int) (list.get(i) + list.get(i + 1) * 256);
            frequencyOfPairs.put(pairRepresentation, (frequencyOfPairs.get(pairRepresentation) + 1));
        }

        return frequencyOfPairs;
    }

    /**
     * Calculates frequency of every byte occurrences at the 1st place in pairs of bytes.
     *
     * @param map map that contains integer representation of a pair of numbers as a <code>K</code>
     *            and its frequency of occurrences as a <code>V</code>
     * @return map that contains a byte as a <code>K</code>
     * and its frequency of occurrences at the 1st place in pairs of bytes as a <code>V</code>
     */
    private Map<Integer, Integer> calculateFrequencyOfFirstBytes(Map<Integer, Integer> map) {
        Map<Integer, Integer> frequencyOfFirstBytes = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            int counter = 0;
            for (int j = i; j < 256 * 256; j += 256) {
                counter += map.get(j);
            }
            frequencyOfFirstBytes.put(i, counter);
        }

        return frequencyOfFirstBytes;
    }

    /**
     * Calculates frequency of every byte occurrences at the 2nd place in pairs of bytes.
     *
     * @param map map that contains integer representation of a pair of numbers as a <code>K</code>
     *            and its frequency of occurrences as a <code>V</code>
     * @return map that contains a byte as a <code>K</code>
     * and its frequency of occurrences at the 2nd place in pairs of bytes as a <code>V</code>
     */
    private Map<Integer, Integer> calculateFrequencyOfSecondBytes(Map<Integer, Integer> map) {
        Map<Integer, Integer> frequencyOfSecondBytes = new HashMap<>();
        for (int j = 0; j < 256; j++) {
            int counter = 0;
            for (int i = 0; i < 256; i++) {
                counter += map.get(i + j * 256);
            }
            frequencyOfSecondBytes.put(j, counter);
        }

        return frequencyOfSecondBytes;
    }
}
