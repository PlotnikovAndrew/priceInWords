package ru.otus.tests;

import ru.otus.project.Currency;
import ru.otus.tests.unit.MoneyArrayTests;
import ru.otus.tests.unit.NumberToTextTest;

public class AllTests {
    public static void main(String[] args){
        MoneyArrayTests moneyArrayTests = new MoneyArrayTests();
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 100, "рублей");
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 102, "рубля");
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 1_000_000, "рублей");

        NumberToTextTest numberToTextTest = new NumberToTextTest();
        numberToTextTest.correctDeclinationMoney(103, Currency.RUB, "сто три");


    }
}
