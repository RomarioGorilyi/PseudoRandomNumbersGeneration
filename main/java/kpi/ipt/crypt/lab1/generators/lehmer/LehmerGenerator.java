package main.java.kpi.ipt.crypt.lab1.generators.lehmer;

import main.java.kpi.ipt.crypt.lab1.generators.ByteGenerator;

/**
 * Created by Roman Horilyi on 25.09.2016.
 */
public class LehmerGenerator extends ByteGenerator {
    private long a;
    private long c;
    private long module;
    private int xInitial;

    public LehmerGenerator(long a, long c, long module, int xInitial) {
        this.a = a;
        this.c = c;
        this.module = module;
        this.xInitial = xInitial;
    }

    @Override
    public long generateRandomByte() {
        int size = getGeneratedRandomNumbers().size();
        if (size != 0) {
            return  ((a * getGeneratedRandomNumbers().get(size - 1) + c) % module);
        } else {
            return ((a * xInitial + c) % module);
        }
    }
}
