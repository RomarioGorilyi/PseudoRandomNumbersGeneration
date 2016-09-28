package main.java.kpi.ipt.crypt.lab1.generators.l20;

import main.java.kpi.ipt.crypt.lab1.util.LinearFeedbackShiftRegister;

/**
 * Created by Roman Horilyi on 26.09.2016.
 */
public class L20 extends LinearFeedbackShiftRegister{
    public L20() {
        super(20, 17, 15, 11, 0);
    }
}
