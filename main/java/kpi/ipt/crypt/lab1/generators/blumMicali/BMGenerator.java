package main.java.kpi.ipt.crypt.lab1.generators.blumMicali;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class BMGenerator {
    private BigInteger p;
    private BigInteger a;
    private BigInteger T;
    private ArrayList<Integer> generatedRandomNumbers;

    public BMGenerator(BigInteger p, BigInteger a, BigInteger T) {
        this.p = p;
        this.a = a;
        this.T = T;
        generatedRandomNumbers = new ArrayList<>();
    }

    public ArrayList<Integer> getRandomNumbers() {
        return generatedRandomNumbers;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getA() {
        return a;
    }

    public BigInteger getT() {
        return T;
    }

    public void generateBit() {
        if ((p.subtract(new BigInteger("1")))
                .divide(new BigInteger("2"))
                .compareTo(T) > 0) {
            addToRandomNumbers(1);
        } else {
            addToRandomNumbers(0);
        }
        setT();
    }

    public void generateBits(int quantity) {
        for (int i = 0; i < quantity; i++) {
            generateBit();
        }
    }

    public void printOutputBits() {
        for (int random : generatedRandomNumbers) {
            System.out.print(random + " ");
        }
    }

    public void setT() {
        T = a.modPow(T, p);
    }

    public void addToRandomNumbers(int value) {
        generatedRandomNumbers.add(value);
    }
}
