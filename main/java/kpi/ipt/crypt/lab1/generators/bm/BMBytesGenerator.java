package main.java.kpi.ipt.crypt.lab1.generators.bm;

import java.math.BigInteger;

/**
 * Byte realization of Blum-Micali generator.
 * Created by Roman Horilyi on 27.09.2016.
 */
public class BMBytesGenerator extends BMGenerator {
    public BMBytesGenerator(BigInteger p, BigInteger a, BigInteger T) {
        super(p, a, T);
    }

    @Override
    public long generateRandomBit() {   // This method isn't intended to be called,
                                        // because we generate a random byte number at once.
       return 0;
    }

    @Override
    public long generateByte() {
        BigInteger result = (getT().multiply(new BigInteger("256")))
                .divide(getP().subtract(new BigInteger("1")));
        setT();

        return result.intValue();
    }
}
