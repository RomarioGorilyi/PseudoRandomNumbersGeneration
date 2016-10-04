package main.java.kpi.ipt.crypt.lab1.generators;

/**
 * Created by Roman Horilyi on 02.10.2016.
 */
public abstract class ByteGenerator extends Generator {
    @Override
    public long generateRandomNumber() {
        return generateRandomByte();
    }

    public abstract long generateRandomByte();
}
