package main.java.kpi.ipt.crypt.lab1.generators.blumMicali;

import main.java.kpi.ipt.crypt.lab1.generators.BitGenerator;

import java.math.BigInteger;

/**
 * Created by Roman Horilyi on 27.09.2016.
 */
public class BMGenerator extends BitGenerator {
    private BigInteger p;
    private BigInteger a;
    private BigInteger T;

    public BMGenerator(BigInteger p, BigInteger a, BigInteger T) {
        this.p = p;
        this.a = a;
        this.T = T;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getA() {
        return a;
    }

    public BigInteger getT() {
        return T;
    }

    public void setT() {
        T = a.modPow(T, p);
    }

    @Override
    public long generateRandomBit() {
        if ((p.subtract(new BigInteger("1"))).divide(new BigInteger("2"))
                .compareTo(T) > 0) {
            setT();
            return 1;
        } else {
            setT();
            return 0;
        }
    }
}
