package main.java.kpi.ipt.crypt.lab1.generators;

/**
 * Created by Roman Horilyi on 02.10.2016.
 */
public abstract class BitGenerator extends Generator {
    @Override
    public long generateRandomNumber() {
        return generateByteFromRandomBits();
    }

    public abstract long generateRandomBit();

    public long generateByteFromRandomBits() {
        long result = 0;
        for (int i = 0; i < 8; i++) {
            result ^= (generateRandomBit() << i);
        }

        return result;
    }
}
