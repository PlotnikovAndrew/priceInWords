package ru.otus.tests.unit;

import ru.otus.project.Currency;
import ru.otus.project.NumberToText;

import static ru.otus.assertions.Assertions.assertGetMoneyStringMethod;

public class NumberToTextTest {

    public void correctNumberToText(int moneyNumber, Currency currency, String correctDeclinationString) {
        String scenario = "Тест на корректный перевод цифры в пропись";

        NumberToText numberToText = new NumberToText(moneyNumber, currency);
        String returnedDeclinationString = numberToText.getTextNumber();

        try {
            assertGetMoneyStringMethod(returnedDeclinationString, correctDeclinationString);
            System.out.printf("%s: passed" , scenario);
            System.out.println(" ");
        } catch (AssertionError ex){
            System.err.printf("%s: fails with message: %s" , scenario, ex.getMessage());
            System.out.println(" ");
        }
    }
}
