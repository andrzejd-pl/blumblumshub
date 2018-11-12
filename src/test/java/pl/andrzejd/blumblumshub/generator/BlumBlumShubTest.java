package pl.andrzejd.blumblumshub.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlumBlumShubTest {
    private BlumBlumShub blumBlumShub;

    @BeforeEach
    void setUp() {
        blumBlumShub = new BlumBlumShub(7,11);
        blumBlumShub.setSeed(57);
    }

    @Test
    void generateNext() {
        assertEquals(BigInteger.valueOf(15), blumBlumShub.generateNext());
        assertEquals(BigInteger.valueOf(71), blumBlumShub.generateNext());
        assertEquals(BigInteger.valueOf(36), blumBlumShub.generateNext());
        assertEquals(BigInteger.valueOf(64), blumBlumShub.generateNext());
    }

    @Test
    void generateIBit() {
        assertEquals(BigInteger.valueOf(15), blumBlumShub.generateIBit(0));
        assertEquals(BigInteger.valueOf(71), blumBlumShub.generateIBit(1));
        assertEquals(BigInteger.valueOf(36), blumBlumShub.generateIBit(2));
        assertEquals(BigInteger.valueOf(64), blumBlumShub.generateIBit(3));
    }
}