package main.java.kpi.ipt.crypt.lab1.generators.blumMicali;

import java.math.BigInteger;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class BMBytesGenerator extends BMGenerator {
    public BMBytesGenerator(BigInteger p, BigInteger a, BigInteger T) {
        super(p, a, T);
    }

    @Override
    public long generateRandomBit() {
        BigInteger result = (getT().multiply(new BigInteger("256")))
                .divide(getP().subtract(new BigInteger("1")));
        setT();

        return result.intValue();
    }
}
