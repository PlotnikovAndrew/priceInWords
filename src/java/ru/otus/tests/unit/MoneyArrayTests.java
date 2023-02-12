package ru.otus.tests.unit;

import ru.otus.project.*;
import static ru.otus.assertions.Assertions.*;

public class MoneyArrayTests {

    public void correctDeclinationMoney(Currency currency, int numberToDeDeclined, String correctDeclinationString){
        String scenario = "Тест на корректное склонение валют";

        DeclinationMoney declinationMoney = new DeclinationMoney(currency);
        String returnedDeclinationString = declinationMoney.getDeclinationMoneyString(numberToDeDeclined);
        System.out.printf("Число для склонения: %d, корректное склонение: %s - ", numberToDeDeclined, correctDeclinationString);
        try {
            assertGetTextNumberMethod(returnedDeclinationString, correctDeclinationString);
            System.out.printf("%s: passed" , scenario);
            System.out.println();
        } catch (AssertionError ex){
            System.err.printf("%s: fails with message %s" , scenario, ex.getMessage());
            System.out.println();
        }
    }
}
