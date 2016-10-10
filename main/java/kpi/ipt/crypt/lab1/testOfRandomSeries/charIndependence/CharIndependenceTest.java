package main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.charIndependence;

import main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.Test;

import java.util.List;

/**
 * Created by Roman Horilyi on 10.10.2016.
 */
public class CharIndependenceTest extends Test{
    public CharIndependenceTest() {
        super(255 * 255);
    }

    @Override
    public double calculateStatistics(List<Long> list) {
        int numberOfPairs = list.size() / 2;
        return 0;
    }
}
