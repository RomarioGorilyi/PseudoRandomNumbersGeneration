package main.java.kpi.ipt.crypt.lab1.generators.lfsr;

import main.java.kpi.ipt.crypt.lab1.generators.BitGenerator;

import java.util.*;

/**
 * Linear feedback shift register.
 * Created by Roman Horilyi on 26.09.2016.
 */
public class LFSR extends BitGenerator {
    private int length;
    private ArrayList<Integer> engagedElements;
    private LinkedList<Integer> state;
    private ArrayList<Integer> outputGeneratedBits;

    /**
     * Constructs a new LFSR with the specified length and the specified set of taps (states that influence the input).
     * @param length length of the LFSR (number of bits in the LFSR)
     * @param orderNumbers order numbers of taps
     */
    public LFSR(int length, int... orderNumbers) {
        this.length = length;
        engagedElements = new ArrayList<>();
        state = new LinkedList<>();
        outputGeneratedBits = new ArrayList<>();

        setEngagedElements(orderNumbers);
        setInitialStateRandomly();
    }

    /**
     * Set a list of LFSR's taps.
     * @param orderNumbers order numbers of taps
     */
    private void setEngagedElements(int... orderNumbers) {
        for (int orderNumber : orderNumbers) {
            engagedElements.add(orderNumber);
        }
    }

    private void setInitialStateRandomly() {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            state.add(random.nextInt(2));
        }
    }

    @Override
    public long generateRandomBit() {
        return makeShift();
    }

    public long makeShift() {
        generateNewBit();
        int outputBit = state.removeLast();
        outputGeneratedBits.add(outputBit);
        return outputBit;
    }

    private void generateNewBit() {
        int valueOfNewBit = 0;
        for (int elementNumber : engagedElements) {
            valueOfNewBit += state.get(length - 1 - elementNumber);
        }
        state.addFirst(valueOfNewBit % 2);
    }

    public int getLastOutputBit() {
        return outputGeneratedBits.get(outputGeneratedBits.size() - 1);
    }
}
