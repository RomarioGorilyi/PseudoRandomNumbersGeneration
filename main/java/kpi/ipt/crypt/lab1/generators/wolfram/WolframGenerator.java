package main.java.kpi.ipt.crypt.lab1.generators.wolfram;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class WolframGenerator {
    private long r;
    private ArrayList<Integer> generatedRandomBits;

    public WolframGenerator() {
        generatedRandomBits = new ArrayList<>();
        setRandomR();
    }

    private void setRandomR() {
        SecureRandom random = new SecureRandom();
        do {
            r = random.nextInt();
        } while (r <= 0);
    }

    public void generateRandomBit() {
        generatedRandomBits.add((int) (r & 1));
        r = (makeCycleLeftShift(r) ^ (r | (r >>> 1)));
        // TODO rotateLeft() $ rotateRight()
    }

    public void generateRandomBits(int quantity) {
        for (int i = 0; i < quantity; i++) {
            generateRandomBit();
        }
    }

    private long makeCycleLeftShift(long number) {
        long rightmostBit = (number >> 31) & 1;
        long result = (number << 1) | rightmostBit;

        return result;
    }

    public ArrayList<Integer> getRandomBits() {
        return generatedRandomBits;
    }

    public void printRandomBits() {
        for (int random : getRandomBits()) {
            System.out.print(random + " ");
        }
    }
}
