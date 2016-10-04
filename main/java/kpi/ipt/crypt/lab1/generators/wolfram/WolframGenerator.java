package main.java.kpi.ipt.crypt.lab1.generators.wolfram;

import main.java.kpi.ipt.crypt.lab1.generators.BitGenerator;

import java.security.SecureRandom;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class WolframGenerator extends BitGenerator {
    private long r;

    public WolframGenerator() {
        setRandomR();
    }

    private void setRandomR() {
        SecureRandom random = new SecureRandom();
        do {
            r = random.nextInt();
        } while (r <= 0);
    }

    @Override
    public long generateRandomBit() {
        long randomBit = r & 1;
        r = (rotateIntBitsLeftwards(r) ^ (r | rotateIntBitsRightwards(r)));
        return randomBit;
    }

    private long rotateIntBitsLeftwards(long number) {
        long rightmostBit = (number >> 31) & 1;
        long result = (number << 1) | rightmostBit;

        return result;
    }

    private long rotateIntBitsRightwards(long number) {
        long leftmostBit = (number & 1) << 31;
        long result = leftmostBit | (number >> 1);

        return result;
    }
}
