package main.java.kpi.ipt.crypt.lab1.generators.javaEmbedded;

import main.java.kpi.ipt.crypt.lab1.generators.StreamingGenerator;

import java.security.SecureRandom;

/**
 * Created by Roman Horilyi on 13.09.2016.
 */
public class JavaEmbeddedGenerator extends StreamingGenerator {
    @Override
    public void generateRandomNumbers(int quantity) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] generatedRandomNumbers = new byte[quantity];
        secureRandom.nextBytes(generatedRandomNumbers);
        for (byte random : generatedRandomNumbers) {
            addToGeneratedRandomNumbers(random + 128);
        }
    }
}
