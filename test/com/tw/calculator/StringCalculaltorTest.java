package com.tw.calculator;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class StringCalculaltorTest {

    @Test
    public void shouldSumTwoNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultado = stringCalculator.sum(1,2);

        MatcherAssert.assertThat(resultado, is(3));
    }
}
