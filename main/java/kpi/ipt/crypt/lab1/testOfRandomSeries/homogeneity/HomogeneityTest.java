package main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.homogeneity;

import main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.Test;

import java.util.List;

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
        return 0;
    }
}
