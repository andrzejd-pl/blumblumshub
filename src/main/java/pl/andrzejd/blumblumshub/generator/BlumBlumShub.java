package pl.andrzejd.blumblumshub.generator;

import java.math.BigInteger;

public class BlumBlumShub extends Generator {
    protected BigInteger blumNumber;

    public BlumBlumShub(int p, int q) {
        blumNumber = BigInteger.valueOf(p)
                .multiply(
                        BigInteger.valueOf(q)
                );
    }

    public BlumBlumShub(BigInteger p, BigInteger q) {
        blumNumber = p.multiply(q);
    }

    @Override
    public BigInteger generateNext() {
        return null;
    }

    @Override
    public BigInteger generateIBit(int i) {
        return null;
    }
}
