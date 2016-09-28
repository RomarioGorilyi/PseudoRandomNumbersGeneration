package main.java.kpi.ipt.crypt.lab1.generators.geffe;

import main.java.kpi.ipt.crypt.lab1.util.LinearFeedbackShiftRegister;

import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 26.09.2016.
 */
public class GeffeGenerator {
    private LinearFeedbackShiftRegister l11;
    private LinearFeedbackShiftRegister l9;
    private LinearFeedbackShiftRegister l10;
    private ArrayList<Integer> outputGeneratedBits;

    public GeffeGenerator() {
        l11 = new LinearFeedbackShiftRegister(11, 0, 2);
        l9 = new LinearFeedbackShiftRegister(9, 0, 1, 3, 4);
        l10 = new LinearFeedbackShiftRegister(10, 0, 3);
        outputGeneratedBits = new ArrayList<>();
    }

    public void generateBit() {
        l11.generateRandomBits(1);
        int x = l11.getLastOutputBit();

        l9.generateRandomBits(1);
        int y = l9.getLastOutputBit();

        l10.generateRandomBits(1);
        int s = l10.getLastOutputBit();

        int result = (s * x + (1 + s) * y) % 2;
        outputGeneratedBits.add(result);
    }

    public void generateRandomBits(int quantity) {
        for (int i = 0; i < quantity; i++) {
            generateBit();
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
}
