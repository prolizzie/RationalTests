import RationalClass.Rational;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.*;


import static org.junit.Assert.*;
@RunWith(Enclosed.class)
public class RationalTests {

    public static class BasicRationalsTests {
        @Test
        public void testReduceRational() {
            Rational actualRational = new Rational(5, 10);
            Rational expectedRational = new Rational(1, 2);
            assertEquals("Numerator and denominator are not reduced", expectedRational, actualRational);
        }

        @Test(expected = ArithmeticException.class)
        public void testDenominatorIsZero() {
            Rational rational = new Rational(1, 0);
        }

        @Test
        public void testMinusFirstPosition() {
            Rational rational = new Rational(-3, 4);
            String[] rationalArray = rational.toString().split("");
            String minusChar = "-";
            assertEquals("Minus hasn't the first position or there is no minus", rationalArray[0], minusChar);
        }
    }

    @RunWith(JUnitParamsRunner.class)
    public static class ActionsTests {
        @Test
        @Parameters({
                "64, 70, 8, 9, 568, 315", // both positive
                "5, 7, -8, 10, -3, 35", // positive and negative
                "-1, 45, -9, 61, -466, 2745"}) // both negative
        public void testSum(final int firstNumerator, final int firstDenominator, final int secondNumerator,
                            final int secondDenominator, final int expectedNumerator,
                            final int expectedDenominator) {
            Rational firstRational = new Rational(firstNumerator, firstDenominator);
            Rational secondRational = new Rational(secondNumerator, secondDenominator);
            Rational sumResult = firstRational.plus(secondRational);
            Rational expectedRational = new Rational(expectedNumerator, expectedDenominator);
            assertEquals("Sum of rationals doesn't work properly", sumResult, expectedRational);
        }

        @Test
        @Parameters({
                "64, 70, 8, 9, 8, 315", // both positive, negative result
                "16, 80, 1, 15, 2, 15", // both positive, positive result
                "5, 7, -8, 10, 53, 35", // positive and negative, positive result
                "-8, 10, 5, 7, -53, 35", // negative and positive, negative result
                "-9, 61, -1, 45, -344, 2745", // both negative, negative result
                "-2, 3, -19, 20, 17, 60"}) // both negative, positive result
        public void testSubtraction(final int firstNumerator, final int firstDenominator, final int secondNumerator,
                                    final int secondDenominator, final int expectedNumerator,
                                    final int expectedDenominator) {
            Rational firstRational = new Rational(firstNumerator, firstDenominator);
            Rational secondRational = new Rational(secondNumerator, secondDenominator);
            Rational subtractionResult = firstRational.minus(secondRational);
            Rational expectedRational = new Rational(expectedNumerator, expectedDenominator);
            assertEquals("Subtraction of rationals doesn't work properly", subtractionResult, expectedRational);
        }

        @Test
        @Parameters({"64, 70, 8, 9, 256, 315", // both positive
                "5, 7, -8, 10, -4, 7", // positive and negative
                "-1, 45, -9, 61, 1, 305"}) // both negative
        public void testMultiply(final int firstNumerator, final int firstDenominator, final int secondNumerator,
                                 final int secondDenominator, final int expectedNumerator,
                                 final int expectedDenominator) {
            Rational firstRational = new Rational(firstNumerator, firstDenominator);
            Rational secondRational = new Rational(secondNumerator, secondDenominator);
            Rational expectedRational = new Rational(expectedNumerator, expectedDenominator);
            Rational multiplicationResult = firstRational.multiply(secondRational);
            assertEquals("Multiplication of rationals doesn't work properly", multiplicationResult, expectedRational);
        }

        @Test
        @Parameters({"64, 70, 8, 9, 36, 35", // both positive
                "5, 7, -8, 10, -25, 28", // positive and negative
                "-1, 45, -9, 61, 61, 405"}) // both negative
        public void testDivide(final int firstNumerator, final int firstDenominator, final int secondNumerator,
                               final int secondDenominator, final int expectedNumerator,
                               final int expectedDenominator) {
            Rational firstRational = new Rational(firstNumerator, firstDenominator);
            Rational secondRational = new Rational(secondNumerator, secondDenominator);
            Rational expectedRational = new Rational(expectedNumerator, expectedDenominator);
            Rational divisionResult = firstRational.divide(secondRational);
            assertEquals("Multiplication of rationals doesn't work properly", divisionResult, expectedRational);
        }
    }

    @RunWith(JUnitParamsRunner.class)
    public static class CompareTests{
        @Test
        @Parameters({"3, 7, 3, 51, false", // equal nominators
                    "2, 9, 4, 9, true", // equal denominators
                    "-7, 57, 1, 2, false", // negative and positive
                    "465, 7987, 1321, 1348, true", // both positive
                    "-79, 4554, -82, 45, false" // both negative
        })
        public void testLess(final int firstNumerator, final int firstDenominator, final int secondNumerator,
                             final int secondDenominator, final boolean expectedResult) {
            Rational firstRational = new Rational(firstNumerator, firstDenominator);
            Rational secondRational = new Rational(secondNumerator, secondDenominator);
            boolean result = firstRational.less(secondRational);
            assertTrue("Less function is broken", result == expectedResult);
        }

        @Test
        @Parameters({"1, 2, 30, 60, true",
                    "78, 80, 4, 7, false",
                    "-46, 100, -23, 50, true",
                    "-7, 9, -3, -9, false"
        })
        public void testEquals(final int firstNumerator, final int firstDenominator, final int secondNumerator,
                             final int secondDenominator, final boolean expectedResult) {
            Rational firstRational = new Rational(firstNumerator, firstDenominator);
            Rational secondRational = new Rational(secondNumerator, secondDenominator);
            boolean result = firstRational.equals(secondRational);
            assertTrue("Equal function is broken", result == expectedResult);

        }
        @Test
        @Parameters({"1, 2, 30, 60, true",
                "78, 80, 4, 7, true",
                "-46, 100, -23, 50, true",
                "-7, 9, -3, -9, false",
                "3, 7, 3, 51, false",
                "-79, 4554, -82, 45, false"
        })
        public void testLessOrEqual(final int firstNumerator, final int firstDenominator, final int secondNumerator,
                               final int secondDenominator, final boolean expectedResult) {
            Rational firstRational = new Rational(firstNumerator, firstDenominator);
            Rational secondRational = new Rational(secondNumerator, secondDenominator);
            boolean result = firstRational.lessOrEqual(secondRational);
            assertTrue("Equal function is broken", result == expectedResult);

        }
    }
}

