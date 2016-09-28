package main.java.kpi.ipt.crypt.lab1.generators.lehmer;

import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 25.09.2016.
 */
public class LehmerGenerator {
    private long a;
    private long c;
    private long module;
    private int xInitial;
    private ArrayList<Long> generatedRandomNumbers;

    public LehmerGenerator(long a, long c, long module, int xInitial) {
        this.a = a;
        this.c = c;
        this.module = module;
        this.xInitial = xInitial;
        generatedRandomNumbers = new ArrayList<>();
    }

    public ArrayList<Long> getRandomNumbers() {
        return generatedRandomNumbers;
    }

    public void printRandomNumbers() {
        for (long random : getRandomNumbers()) {
            System.out.print(random + " ");
        }
    }

    public long generateRandomNumber() {
        if (generatedRandomNumbers.size() != 0) {
            return  ((a * generatedRandomNumbers.get(generatedRandomNumbers.size() - 1) + c) % module);
        } else {
            return ((a * xInitial + c) % module);
        }
    }

    /**
     * Add a newly generated random non-negative number to the <code>generatedRandomNumbers</code> arrayList.
     */
    public void addRandomToList() {
       generatedRandomNumbers.add(generateRandomNumber());
    }

    /**
     * Generate certain number of random values and add them to the <code>generatedRandomNumbers</code> arrayList.
     * @param quantity number of random values that have to be generated
     */
    public void generateRandomNumbers(int quantity) {
        for (int i = 0; i < quantity; i++) {
            addRandomToList();
        }
    }
}
