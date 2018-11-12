package pl.andrzejd.blumblumshub.generator;

import java.math.BigInteger;

public class BlumBlumShub extends Generator {
    protected BigInteger blumNumber;
    protected BigInteger actualNumber;
    protected BigInteger beginNumber;

    public BlumBlumShub(int p, int q) {
        this(BigInteger.valueOf(p), BigInteger.valueOf(q));
    }

    public BlumBlumShub(BigInteger p, BigInteger q) {
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

    @Override
    public BigInteger generateIBit(int i) {
        return null;
    }

    private void randomSeed() {
        beginNumber = seed
                .multiply(seed)
                .mod(blumNumber);
    }
}
