package main.java.kpi.ipt.crypt.lab1.generators.lehmer;

import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 25.09.2016.
 */
public class LehmerHigh extends LehmerGenerator {
    public LehmerHigh(int xInitial) {
        super((1 << 16) + 1, 119, 1L << 32, xInitial);
    }

    /**
     * Get arrayList of numbers that contain only 8 MSBs (the most significant bits) of generated random numbers
     * from the <code>generatedRandomNumbers</code> arrayList.
     * @return arrayList of random number's MSBs
     */
    @Override
    public ArrayList<Long> getRandomNumbers() {
        ArrayList<Long> resultList = new ArrayList<>();
        for (int i = 0; i < super.getRandomNumbers().size(); i++) {
            resultList.add(super.getRandomNumbers().get(i) >> 24);
        }
        return resultList;
    }
}
