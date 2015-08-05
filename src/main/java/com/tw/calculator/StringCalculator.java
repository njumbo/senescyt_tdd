package com.tw.calculator;

import com.tw.calculator.exceptions.InvalidInputException;

public class StringCalculator {
    public int sum(int i, int i1) {
        return i + i1;
    }
    public Integer sumar(String valoresASumar) throws InvalidInputException {
        if(valoresASumar.equals("")) {
            return 0;
        }

        String[] valoresSeparados = valoresASumar.split(",|\n|;");

        Integer resultado = 0;
        String negativeNumbersForExceptionMessage = "";

        for (String valor : valoresSeparados) {
            if (Integer.valueOf(valor) < 0) {
                negativeNumbersForExceptionMessage += valor + ",";
            }

            resultado += Integer.valueOf(valor);
        }

        if (negativeNumbersForExceptionMessage.length() > 0){
            throw new InvalidInputException("Negatives Numbers not allowed:" + negativeNumbersForExceptionMessage);
        }

        return resultado;
    }
}
