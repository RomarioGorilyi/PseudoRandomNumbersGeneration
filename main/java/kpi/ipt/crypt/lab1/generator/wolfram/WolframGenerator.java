package main.java.kpi.ipt.crypt.lab1.generator.wolfram;

import main.java.kpi.ipt.crypt.lab1.generator.BitGenerator;

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
        r = (rotateBitsOfIntegerLeftwards(r) ^ (r | rotateBitsOfIntegerRightwards(r)));
        return randomBit;
    }

    private long rotateBitsOfIntegerLeftwards(long number) {
        long rightmostBit = (number >> 31) & 1;
        return (number << 1) | rightmostBit;
    }

    private long rotateBitsOfIntegerRightwards(long number) {
        long leftmostBit = (number & 1) << 31;
        return leftmostBit | (number >> 1);
    }
}
