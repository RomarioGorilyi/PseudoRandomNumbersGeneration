package main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.homogeneity;

import main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Roman Horilyi on 11.10.2016.
 */
public class HomogeneityTest extends Test {
    private int r;

    public HomogeneityTest(int r) {
        super(255 * (r - 1));
        this.r = r;
    }

    @Override
    public double calculateStatistics(List<Long> list) {
        int m = list.size() / r;
        Map<Integer, Map<Integer, Integer>> frequenciesWithSegments = calculateFrequenciesWithSegments(list);
        Map<Integer, Integer> frequencies = calculateFrequencies(list);

        double sum = 0;
        for (int i = 0; i < 256; i++) {
            double sumByI = 0;
            if (frequencies.get(i) != 0) {
                for (int j = 0; j < r; j++) {
                    int frequency = frequenciesWithSegments.get(j).get(i);
                    sumByI += frequency * frequency;
                }
                sum += sumByI / frequencies.get(i);
            }
        }

        return m * r * (sum / m - 1);
    }

    /**
     * Calculates frequency of byte occurrences in the given segment of the specified list.
     *
     * @param sequence list of bytes
     * @param orderNumberOfSegment order number of the segment in the specified list
     * @return map that contains byte as a <code>K</code>
     * and its frequency of occurrences in the specified segment as a <code>V</code>
     */
    private Map<Integer, Integer> calculateFrequencyInSegment(List<Long> sequence, int orderNumberOfSegment) {
        int m = sequence.size() / r;

        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            frequency.put(i, 0);
        }
        for (int i = orderNumberOfSegment * m; i < (orderNumberOfSegment + 1) * m; i++) {
            int element = Integer.parseInt(sequence.get(i).toString());
            frequency.put(element, frequency.get(element) + 1);
        }

        return frequency;
    }

    /**
     * Calculates frequencies of all bytes occurrences with their correspondent order number of segments
     * in the specified list.
     *
     * @param sequence list of bytes
     * @return map that contains order number of segment as a <code>K</code>
     * and a map of byte-frequency as a <code>V</code>
     */
    private Map<Integer, Map<Integer, Integer>> calculateFrequenciesWithSegments(List<Long> sequence) {
        Map<Integer, Map<Integer, Integer>> frequencyInSegments = new HashMap<>();
        for (int i = 0; i < r; i++) {
            frequencyInSegments.put(i, calculateFrequencyInSegment(sequence, i));
        }

        return frequencyInSegments;

        /*
        for (int i = 0; i < 256; i++) {
            frequencyInSegments.put(i, 0);
        }
        for (int j = 0; j < r; j++) {
            for (int i = 0; i < 256; i++) {
                frequencyInSegments.put(i, frequencyInSegments.get(i) + tmpFrequencyInSegments.get(j).get(i));
            }
        }

        return frequencyInSegments;*/
    }

    /**
     * Calculates frequencies of bytes occurrence in the specified list.
     *
     * @param sequence list of bytes
     * @return map that contains a byte as a <code>K</code>
     * and a relevant frequency of it as a <code>V</code>
     */
    private Map<Integer, Integer> calculateFrequencies(List<Long> sequence) {
        Map<Integer, Integer> frequency = new HashMap<>();

        Map<Integer, Map<Integer, Integer>> frequenciesWithSegments = calculateFrequenciesWithSegments(sequence);
        for (int i = 0; i < 256; i++) {
            frequency.put(i, 0);
        }
        for (int j = 0; j < r; j++) {
            for (int i = 0; i < 256; i++) {
                frequency.put(i, frequency.get(i) + frequenciesWithSegments.get(j).get(i));
            }
        }

        return frequency;
    }
}
