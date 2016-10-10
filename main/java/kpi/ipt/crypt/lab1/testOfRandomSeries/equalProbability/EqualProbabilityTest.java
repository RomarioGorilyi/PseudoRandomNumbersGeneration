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
        Map<Long, Integer> bytesFrequency = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            bytesFrequency.put((long) i, 0);
        }

        for (long number : generatedNumbers) {
            bytesFrequency.put(number, bytesFrequency.get(number) + 1);
        }

        double result = 0;
        double expectedNumberOfEveryByte = generatedNumbers.size() / 256;
        for (int i = 0; i < 256; i++) {
            result += (bytesFrequency.get((long) i) - expectedNumberOfEveryByte)
                    * (bytesFrequency.get((long) i) - expectedNumberOfEveryByte)
                    / expectedNumberOfEveryByte;
        }

        return result;
    }
}
