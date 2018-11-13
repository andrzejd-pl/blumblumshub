package pl.andrzejd.blumblumshub.generator;

import java.math.BigInteger;

public abstract class Generator {
    protected BigInteger seed = null;

    public abstract BigInteger generateNext();

    public void setSeed(BigInteger seed) {
        this.seed = seed;
    }

    public void setSeed(int seed) {
        this.seed = BigInteger.valueOf(seed);
    }
}
