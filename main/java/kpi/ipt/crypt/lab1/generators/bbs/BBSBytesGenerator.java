package main.java.kpi.ipt.crypt.lab1.generators.bbs;

import java.math.BigInteger;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class BBSBytesGenerator extends BBSGenerator {
    public BBSBytesGenerator(BigInteger p, BigInteger q) {
        super(p, q);
    }

    @Override
    public long generateRandomBit() {
        setR(getR().modPow(new BigInteger("2"), getP().multiply(getQ())));
        return getR().mod(new BigInteger("256")).intValue();
    }
}
