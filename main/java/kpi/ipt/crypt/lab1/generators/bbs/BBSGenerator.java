package main.java.kpi.ipt.crypt.lab1.generators.bbs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class BBSGenerator {
    private BigInteger p;
    private BigInteger q;
    private BigInteger r;
    private ArrayList<Integer> generatedRandomNumbers;

    public BBSGenerator(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        generatedRandomNumbers = new ArrayList<>();
        r = new BigInteger(Integer.toString(new Random().nextInt() + 2));
    }

    public ArrayList<Integer> getRandomNumbers() {
        return generatedRandomNumbers;
    }

    public void generateBit() {
        setR(r.modPow(new BigInteger("2"), p.multiply(q)));
        addToRandomNumbers(r.mod(new BigInteger("2")).intValue());
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getR() {
        return r;
    }

    public void setR(BigInteger r) {
        this.r = r;
    }

    public void addToRandomNumbers(int value) {
        generatedRandomNumbers.add(value);
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
}
