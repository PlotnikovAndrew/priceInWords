package ru.otus.tests;

import ru.otus.project.Currency;
import ru.otus.tests.unit.MoneyArrayTests;
import ru.otus.tests.unit.NumberToTextTest;
import ru.otus.tests.unit.SplitterNumbersTest;

import java.util.ArrayList;

public class AllTests {
    public static void main(String[] args){
        MoneyArrayTests moneyArrayTests = new MoneyArrayTests();
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 100, "рублей");
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 102, "рубля");
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 1_000_000, "рублей");

        NumberToTextTest numberToTextTest = new NumberToTextTest();
        numberToTextTest.correctNumberToText(103, Currency.RUB, "сто три рубля ");

        SplitterNumbersTest splitterNumbersTest = new SplitterNumbersTest();
        ArrayList<Integer> correctArrayList = new ArrayList<>();
        correctArrayList.add(542);
        correctArrayList.add(132);
        correctArrayList.add(55);
//        correctArrayList.add(21);
        splitterNumbersTest.correctSplitNumber(55132542, correctArrayList);

    }
}
