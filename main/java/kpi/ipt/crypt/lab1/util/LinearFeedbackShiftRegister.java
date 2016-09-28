package main.java.kpi.ipt.crypt.lab1.util;

import java.util.*;

/**
 * Created by Roman Horilyi on 26.09.2016.
 */
public class LinearFeedbackShiftRegister {
    private int length;
    private ArrayList<Integer> engagedElements;
    private LinkedList<Integer> state;
    private ArrayList<Integer> outputGeneratedBits;

    public LinearFeedbackShiftRegister(int length, int... orderNumbers) {
        this.length = length;
        engagedElements = new ArrayList<>();
        state = new LinkedList<>();
        outputGeneratedBits = new ArrayList<>();

        setEngagedElements(orderNumbers);
        setInitialStateRandomly();
    }

    public void setEngagedElements(int... orderNumbers) {
        for (int orderNumber : orderNumbers) {
            engagedElements.add(orderNumber);
        }
    }

    public void setInitialStateRandomly() {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            state.add(random.nextInt(2));
        }
    }

    public void makeShift() {
        generateNewBit();
        getOutputBit();
    }

    private void generateNewBit() {
        int valueOfNewBit = 0;
        for (int elementNumber : engagedElements) {
            valueOfNewBit += state.get(length - 1 - elementNumber);
        }
        state.addFirst(valueOfNewBit % 2);
    }

    private void getOutputBit() {
        outputGeneratedBits.add(state.removeLast());
    }

    public void generateRandomBits(int quantity) {
        for (int i = 0; i < quantity; i++) {
            makeShift();
        }
    }

    public ArrayList<Integer> getOutputBits() {
        return outputGeneratedBits;
    }

    public void printOutputBits() {
        for (int random : getOutputBits()) {
            System.out.print(random + " ");
        }
    }

    public int getLastOutputBit() {
        return outputGeneratedBits.get(outputGeneratedBits.size() - 1);
    }
}
