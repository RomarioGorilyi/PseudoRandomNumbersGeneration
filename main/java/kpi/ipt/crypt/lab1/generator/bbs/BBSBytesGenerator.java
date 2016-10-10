package main.java.kpi.ipt.crypt.lab1.generator.bbs;

import java.math.BigInteger;

/**
 * Byte realization of Blum-Blum-Shub generator.
 *
 * Created by Roman Horilyi on 27.09.2016.
 */
public class BBSBytesGenerator extends BBSGenerator {
    public BBSBytesGenerator(BigInteger p, BigInteger q) {
        super(p, q);
    }

    @Override
    public long generateRandomBit() {   // This method isn't intended to be called,
                                        // because we generate a random byte number at once.
        return 0;
    }

    @Override
    public long generateByte() {
        setR(getR().modPow(new BigInteger("2"), getP().multiply(getQ())));
        return getR().mod(new BigInteger("256")).intValue();
    }
}
