package main.java.kpi.ipt.crypt.lab1;

import main.java.kpi.ipt.crypt.lab1.generators.bbs.BBSBytesGenerator;
import main.java.kpi.ipt.crypt.lab1.generators.bbs.BBSGenerator;
import main.java.kpi.ipt.crypt.lab1.generators.blumMicali.BMBytesGenerator;
import main.java.kpi.ipt.crypt.lab1.generators.blumMicali.BMGenerator;
import main.java.kpi.ipt.crypt.lab1.generators.geffe.GeffeGenerator;
import main.java.kpi.ipt.crypt.lab1.generators.javaEmbedded.JavaEmbeddedGenerator;
import main.java.kpi.ipt.crypt.lab1.generators.l20.L20;
import main.java.kpi.ipt.crypt.lab1.generators.l89.L89;
import main.java.kpi.ipt.crypt.lab1.generators.lehmer.LehmerHigh;
import main.java.kpi.ipt.crypt.lab1.generators.lehmer.LehmerLow;
import main.java.kpi.ipt.crypt.lab1.generators.librarian.LibrarianGenerator;
import main.java.kpi.ipt.crypt.lab1.generators.wolfram.WolframGenerator;

import java.math.BigInteger;

/**
 * Created by Roman Horilyi on 13.09.2016.
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Java embedded generator:");
        JavaEmbeddedGenerator javaGenerator = new JavaEmbeddedGenerator();
        javaGenerator.generateRandomNumbers(50);
        javaGenerator.printRandomNumbers();

        System.out.println("\n\nLehmer Low generator:");
        LehmerLow lehmerLow = new LehmerLow(85454354);
        lehmerLow.generateRandomNumbers(50);
        lehmerLow.printRandomNumbers();

        System.out.println("\n\nLehmer High generator:");
        LehmerHigh lehmerHigh = new LehmerHigh(57454848);
        lehmerHigh.generateRandomNumbers(50);
        lehmerHigh.printRandomNumbers();

        System.out.println("\n\nL20 generator:");
        L20 l20 = new L20();
        l20.generateRandomBits(50);
        l20.printOutputBits();

        System.out.println("\n\nL89 generator:");
        L89 l89 = new L89();
        l89.generateRandomBits(50);
        l89.printOutputBits();

        System.out.println("\n\nGeffe generator:");
        GeffeGenerator geffeGenerator = new GeffeGenerator();
        geffeGenerator.generateRandomBits(50);
        geffeGenerator.printOutputBits();

        System.out.println("\n\nWolfram generator:");
        WolframGenerator wolframGenerator = new WolframGenerator();
        wolframGenerator.generateRandomBits(50);
        wolframGenerator.printRandomBits();

        System.out.println("\n\nLibrarian generator:");
        LibrarianGenerator librarianGenerator = new LibrarianGenerator("src/main/sourceFiles/TheGreenMile.txt");
        librarianGenerator.generateRandomNumbers();
        librarianGenerator.printRandomNumbers();

        System.out.println("\n\nBM generator:");
        BigInteger p = new BigInteger("0CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
        BigInteger a = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
        BigInteger T = new BigInteger("1221556452385");
        BMGenerator bmGenerator = new BMGenerator(p, a, T);
        bmGenerator.generateBits(50);
        bmGenerator.printOutputBits();

        System.out.println("\n\nBM Bytes generator:");
        BMBytesGenerator bmBytesGenerator = new BMBytesGenerator(p, a, T);
        bmBytesGenerator.generateBits(50);
        bmBytesGenerator.printOutputBits();

        System.out.println("\n\nBBS generator:");
        BigInteger p1 = new BigInteger("0D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
        BigInteger q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
        BBSGenerator bbsGenerator = new BBSGenerator(p1, q);
        bbsGenerator.generateBits(50);
        bbsGenerator.printOutputBits();

        System.out.println("\n\nBBS Bytes generator:");
        BBSBytesGenerator bbsBytesGenerator = new BBSBytesGenerator(p1, q);
        bbsBytesGenerator.generateBits(50);
        bbsBytesGenerator.printOutputBits();
    }
}
