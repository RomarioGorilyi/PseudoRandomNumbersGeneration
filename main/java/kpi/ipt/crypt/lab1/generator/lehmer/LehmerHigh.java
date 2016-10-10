package main.java.kpi.ipt.crypt.lab1.generator.lehmer;

import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 25.09.2016.
 */
public class LehmerHigh extends LehmerGenerator {
    public LehmerHigh(int xInitial) {
        super((1 << 16) + 1, 119, 1L << 32, xInitial);
    }

    /**
     * Generates random numbers and then gets only 8 MSBs (the most significant bits) of every number and adds them to
     * <code>generatedRandomNumbers</code> list.
     *
     * @param quantity number of random values that have to be generated
     */
    @Override
    public void generateRandomNumbers(int quantity) {
        super.generateRandomNumbers(quantity);
        ArrayList<Long> randoms = getGeneratedRandomNumbers();
        int size = randoms.size();
        for (int i = 0; i < size; i++) {
            randoms.set(i, randoms.get(i) >> 24);
        }
        setGeneratedRandomNumbers(randoms);
    }
}
