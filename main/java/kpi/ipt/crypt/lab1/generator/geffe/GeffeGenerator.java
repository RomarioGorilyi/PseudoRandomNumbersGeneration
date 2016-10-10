package main.java.kpi.ipt.crypt.lab1.generator.geffe;

import main.java.kpi.ipt.crypt.lab1.generator.BitGenerator;
import main.java.kpi.ipt.crypt.lab1.generator.lfsr.LFSR;

/**
 * Created by Roman Horilyi on 26.09.2016.
 */
public class GeffeGenerator extends BitGenerator{
    private LFSR l11;
    private LFSR l9;
    private LFSR l10;

    public GeffeGenerator() {
        l11 = new LFSR(11, 0, 2);
        l9 = new LFSR(9, 0, 1, 3, 4);
        l10 = new LFSR(10, 0, 3);
    }

    @Override
    public long generateRandomBit() {
        l11.generateRandomBit();
        int x = l11.getLastOutputBit();

        l9.generateRandomBit();
        int y = l9.getLastOutputBit();

        l10.generateRandomBit();
        int s = l10.getLastOutputBit();

        return (s * x + (1 + s) * y) % 2;
    }
}
