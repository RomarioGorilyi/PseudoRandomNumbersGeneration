package main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.charIndependence;

import main.java.kpi.ipt.crypt.lab1.generator.bbs.BBSBytesGenerator;
import main.java.kpi.ipt.crypt.lab1.generator.bbs.BBSGenerator;
import main.java.kpi.ipt.crypt.lab1.generator.bm.BMBytesGenerator;
import main.java.kpi.ipt.crypt.lab1.generator.bm.BMGenerator;
import main.java.kpi.ipt.crypt.lab1.generator.geffe.GeffeGenerator;
import main.java.kpi.ipt.crypt.lab1.generator.javaEmbedded.JavaEmbeddedGenerator;
import main.java.kpi.ipt.crypt.lab1.generator.lehmer.LehmerHigh;
import main.java.kpi.ipt.crypt.lab1.generator.lehmer.LehmerLow;
import main.java.kpi.ipt.crypt.lab1.generator.lfsr.L20;
import main.java.kpi.ipt.crypt.lab1.generator.lfsr.L89;
import main.java.kpi.ipt.crypt.lab1.generator.librarian.LibrarianGenerator;
import main.java.kpi.ipt.crypt.lab1.generator.wolfram.WolframGenerator;
import main.java.kpi.ipt.crypt.lab1.testOfRandomSeries.equalProbability.EqualProbabilityTest;

import java.math.BigInteger;

/**
 * Created by Roman Horilyi on 11.10.2016.
 */
public class CharIndependenceTestApp {
    public static void main(String[] args) {
        CharIndependenceTest test = new CharIndependenceTest();

        test.testGenerator(new JavaEmbeddedGenerator());

        test.testGenerator(new LehmerLow(85454354));
        test.testGenerator(new LehmerHigh(57454848));

        test.testGenerator(new L20());
        test.testGenerator(new L89());

        test.testGenerator(new GeffeGenerator());

        test.testGenerator(new WolframGenerator());

        test.testGenerator(new LibrarianGenerator("src/main/sourceFiles/TheGreenMile.txt"));

        BigInteger p = new BigInteger("0CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
        BigInteger a = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
        BigInteger T = new BigInteger("1221556452385");
        test.testGenerator(new BMGenerator(p, a, T));
        test.testGenerator(new BMBytesGenerator(p, a, T));

        BigInteger p1 = new BigInteger("0D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
        BigInteger q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
        test.testGenerator(new BBSGenerator(p1, q));
        test.testGenerator(new BBSBytesGenerator(p1, q));
    }
}
