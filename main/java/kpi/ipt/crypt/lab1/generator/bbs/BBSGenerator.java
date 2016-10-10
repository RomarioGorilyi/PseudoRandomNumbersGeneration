package main.java.kpi.ipt.crypt.lab1.generator.bbs;

import main.java.kpi.ipt.crypt.lab1.generator.BitGenerator;

import java.math.BigInteger;
import java.util.Random;

/**
 * Blum-Blum-Shub generator.
 *
 * Created by Roman Horilyi on 27.09.2016.
 */
public class BBSGenerator extends BitGenerator {
    private BigInteger p;
    private BigInteger q;
    private BigInteger r;

    public BBSGenerator(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        r = new BigInteger(Integer.toString(new Random().nextInt() + 2));
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getR() {
        return r;
    }

    public void setR(BigInteger r) {
        this.r = r;
    }

    @Override
    public long generateRandomBit() {
        setR(r.modPow(new BigInteger("2"), p.multiply(q)));
        return r.mod(new BigInteger("2")).intValue();
    }
}
