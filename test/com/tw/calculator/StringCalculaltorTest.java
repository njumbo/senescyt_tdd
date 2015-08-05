package com.tw.calculator;

import com.tw.calculator.exceptions.InvalidInputException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringCalculaltorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    @Test
    public void shouldSumTwoNumbers() {
        StringCalculator stringCalculator = new StringCalculator();
        int resultado = stringCalculator.sum(1,2);

        assertThat(resultado, is(3));
    }

    @Test
    public void shouldReturnZeroForAnEmptyString() throws InvalidInputException {
        StringCalculator stringCalculator = new StringCalculator();
        int resultado = stringCalculator.sumar("");
        assertThat(resultado, is(0));

    }

    @Test
    public void shouldReturnTheFirstNumberIfTheInputIsJustOneNumber() throws InvalidInputException {
        StringCalculator stringCalculaltor = new StringCalculator();
        int resultado = stringCalculaltor.sumar("1");
        assertThat(resultado, is(1));
    }
    
    @Test
    public void shouldAddFirstTwoNumbers() throws InvalidInputException {
        StringCalculator stringCalculaltor = new StringCalculator();
        int resultado = stringCalculaltor.sumar("1,2");
        assertThat(resultado, is(3));
    }

    @Test
    public void shouldAdd3Numbers() throws InvalidInputException {
        StringCalculator stringCalculaltor = new StringCalculator();
        int resultado = stringCalculaltor.sumar("1,2,3");
        assertThat(resultado, is(6));
    }

    @Test
    public void shouldAddNumbersSeparatedByCommaOrNewLineSymbol() throws InvalidInputException {
        StringCalculator stringCalculaltor = new StringCalculator();
        int resultado = stringCalculaltor.sumar("1\n2,3");
        assertThat(resultado, is(6));
    }

    @Test
    public void shouldSupportColonAsDelimiter() throws InvalidInputException {
        StringCalculator stringCalculaltor = new StringCalculator();
        int resultado = stringCalculaltor.sumar("1;2\n3");
        assertThat(resultado, is(6));
    }

    @Test(expected = InvalidInputException.class)
    public void shouldNotAcceptNegativeNumbers() throws InvalidInputException {
        StringCalculator stringCalculaltor = new StringCalculator();
        stringCalculaltor.sumar("-1,2");
    }

    @Test
    public void shouldShowTheNegativeNumbersInTheExceptionMessage() throws InvalidInputException {
        expectedException.expect(InvalidInputException.class);
        expectedException.expectMessage("Negatives Numbers not allowed:-1,-2");
        StringCalculator stringCalculaltor = new StringCalculator();
        stringCalculaltor.sumar("-1,2,-2");
    }
}
