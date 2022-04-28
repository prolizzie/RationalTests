# RationalTests

Тестовый класс RationalTests для тестирования функционала класса Rational, который работает с рациональными числами.

Класс RationalTests содержит следующие проверки:

- `void testReduceRational()` проверяет сокращение дробей;
- `void testDenominatorIsZero()` проверяет генерацию исключения при попытке деления на ноль;
- `void testMinusFirstPosition()` проверяет первую позицию минуса (перед числителем);

Тесты, использующие параметризацию:
- `void testSum(final int firstNumerator, final int firstDenominator, final int secondNumerator, final int secondDenominator, final int expectedNumerator, final int expectedDenominator)` проверяет сложение дробей;
- `void testSubtraction(final int firstNumerator, final int firstDenominator, final int secondNumerator, final int secondDenominator, final int expectedNumerator, final int expectedDenominator)` проверяет вычитание дробей;
- `void testMultiply(final int firstNumerator, final int firstDenominator, final int secondNumerator, final int secondDenominator, final int expectedNumerator,final int expectedDenominator)` проверяет умножение дробей;
- `void testDivide(final int firstNumerator, final int firstDenominator, final int secondNumerator, final int secondDenominator, final int expectedNumerator, final int expectedDenominator)` проверяет деление дробей;
- `void testLess(final int firstNumerator, final int firstDenominator, final int secondNumerator, final int secondDenominator, final boolean expectedResult)` проверяет сравнение на меньше
- `void testEquals(final int firstNumerator, final int firstDenominator, final int secondNumerator, final int secondDenominator, final boolean expectedResult)` проверяет сравнение на равно
- `void testLessOrEqual(final int firstNumerator, final int firstDenominator, final int secondNumerator, final int secondDenominator, final boolean expectedResult)` проверяет сравнение на меньше или равно



# Running Tests
Запуск в терминале с помощью команды: `mvn -Dtest=RationalTests test` (перед этим потребуется установить Maven)
