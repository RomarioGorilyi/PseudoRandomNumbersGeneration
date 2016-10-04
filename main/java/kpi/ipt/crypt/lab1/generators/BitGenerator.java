package main.java.kpi.ipt.crypt.lab1.generators;

/**
 * Created by Roman Horilyi on 02.10.2016.
 */
public abstract class BitGenerator extends Generator {
    @Override
    public long generateRandomNumber() {
        return generateByte();
    }

    /**
     * Generates 8 random bits consistently and afterwards converts them into a byte
     * disposing each i-th bit at i-th position starting from the LSB (lest significant bit) of the result byte.
     * @return a byte representation of 8 bits
     */
    public long generateByte() {
        long result = 0;
        for (int i = 0; i < 8; i++) {
            result ^= (generateRandomBit() << i);
        }

        return result;
    }

    public abstract long generateRandomBit();
}
