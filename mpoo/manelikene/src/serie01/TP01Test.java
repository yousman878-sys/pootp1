package serie01;

import util.TPTester;

public final class TP01Test {
    void main() {
        TPTester t = new TPTester(serie01.util.StdCurrencyTestCons.class);
        int exitValue = t.runAll();
        if (exitValue == 0) {
            t = new TPTester(serie01.util.StdCurrencyTest.class);
            t.runAll();
        }
        t = new TPTester(serie01.util.StdCurrencyDBTestCons.class);
        exitValue = t.runAll();
        if (exitValue == 0) {
            t = new TPTester(serie01.util.StdCurrencyDBTest.class);
            t.runAll();
        }
        t = new TPTester(serie01.model.StdMultiConverterTest.class);
        exitValue = t.runAll();
        System.exit(exitValue);
    }
}
