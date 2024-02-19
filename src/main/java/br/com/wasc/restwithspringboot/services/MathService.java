package br.com.wasc.restwithspringboot.services;

import br.com.wasc.restwithspringboot.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        if (isNotNumeric(numberOne) || isNotNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid: please type a number.");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double convertToDouble(String value) {
        if(value == null) return 0D;
        String number = value.replace(",", ".");
        return Double.parseDouble(number);
    }

    public boolean isNotNumeric(String value) {
        if(value == null) return true;
        String number = value.replace(",", ".");
        return !number.matches("[+-]?[0-9]+\\.?[0-9]*");
    }
}
