package org.csystem.util.numeric.data;

import java.math.BigInteger;

public class BigIntegerDataInfo {
    public BigInteger input;
    public BigInteger expected;

    public BigIntegerDataInfo(BigInteger input, BigInteger expected) {
        this.input = input;
        this.expected = expected;
    }
}
