package utils;

import RationalClass.Rational;

public class FunctionsClass {

    public String calculateExpectedSum(Rational firstRational, Rational secondRational){
        int commonNumerator = firstRational.getNumerator() * secondRational.getDenominator() + secondRational.getNumerator() * firstRational.getDenominator();
        int commonDenominator = firstRational.getDenominator() * secondRational.getDenominator();
        String result = String.format("%s/%d", commonNumerator, commonDenominator);
        return result;
    }

    public String calculateExpectedSubtraction(Rational firstRational, Rational secondRational){
        int commonNumerator = firstRational.getNumerator() * secondRational.getDenominator() - secondRational.getNumerator() * firstRational.getDenominator();
        int commonDenominator = firstRational.getDenominator() * secondRational.getDenominator();
        String result = String.format("%s/%d", commonNumerator, commonDenominator);
        return result;
    }
}
