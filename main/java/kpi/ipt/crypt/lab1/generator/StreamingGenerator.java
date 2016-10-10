package main.java.kpi.ipt.crypt.lab1.generator;

/**
 * Type of random number generator which generates block of random numbers at once.
 *
 * Created by Roman Horilyi on 03.10.2016.
 */
public abstract class StreamingGenerator extends Generator {
    @Override
    public long generateRandomNumber() {    // This method isn't intended to be called,
                                            // because we generate a block of random numbers at once.
        return 0;
    }
}
