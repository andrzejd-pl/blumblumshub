package pl.andrzejd.blumblumshub.generator;

import java.math.BigInteger;

public abstract class Generator {
    protected int seed;


    public abstract BigInteger generateNext();
    public abstract BigInteger generateIBit(int i);

    public void setSeed(int seed) {
        this.seed = seed;
    }
}
