package main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.equalProbability;

import main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Roman Horilyi on 10.10.2016.
 */
public class EqualProbabilityTest extends Test {
    public EqualProbabilityTest() {
        super(255);
    }

    @Override
    public double calculateStatistics(List<Long> generatedNumbers) {
        Map<Integer, Integer> frequenciesOfBytes = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            frequenciesOfBytes.put(i, 0);
        }
        for (long number : generatedNumbers) {
            frequenciesOfBytes.put((int) number, frequenciesOfBytes.get((int) number) + 1);
        }

        double result = 0;
        double expectedNumberOfEveryByte = generatedNumbers.size() / 256;
        for (int i = 0; i < 256; i++) {
            result += (frequenciesOfBytes.get(i) - expectedNumberOfEveryByte)
                    * (frequenciesOfBytes.get(i) - expectedNumberOfEveryByte)
                    / expectedNumberOfEveryByte;
        }

        return result;
    }
}
