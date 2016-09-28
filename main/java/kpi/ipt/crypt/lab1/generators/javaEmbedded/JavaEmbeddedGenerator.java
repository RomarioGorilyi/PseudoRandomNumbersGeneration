package main.java.kpi.ipt.crypt.lab1.generators.javaEmbedded;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Created by Roman Horilyi on 13.09.2016.
 */
public class JavaEmbeddedGenerator {
    private ArrayList<Integer> generatedRandomNumbers;

    public JavaEmbeddedGenerator() {
        generatedRandomNumbers = new ArrayList<>();
    }

    public void generateRandomNumbers(int quantityOfNumbers) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] generatedRandomNumbers = new byte[quantityOfNumbers];
        secureRandom.nextBytes(generatedRandomNumbers);
        for (byte random : generatedRandomNumbers) {
            this.generatedRandomNumbers.add(random + 128);
        }
    }

    public void printRandomNumbers() {
        for (int random : generatedRandomNumbers) {
            System.out.print(random + " ");
        }
    }
}
