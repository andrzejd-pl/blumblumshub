package pl.andrzejd.blumblumshub.generator;

import java.math.BigInteger;

public class BlumBlumShub extends Generator {
    protected BigInteger blumNumber;
    protected BigInteger actualNumber;
    protected BigInteger beginNumber;
    protected BigInteger p;
    protected BigInteger q;

    public BlumBlumShub(int p, int q) {
        this(BigInteger.valueOf(p), BigInteger.valueOf(q));
    }

    public BlumBlumShub(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;

        blumNumber = p.multiply(q);
    }

    @Override
    public BigInteger generateNext() {
        if (seed == null || beginNumber == null) {
            randomSeed();
        }

        if (actualNumber == null) {
            actualNumber = beginNumber;

            return  actualNumber;
        }

        actualNumber = actualNumber
                .multiply(actualNumber)
                .mod(blumNumber);

        return actualNumber;
    }

    private void randomSeed() {
        beginNumber = seed
                .multiply(seed)
                .mod(blumNumber);
    }
}
