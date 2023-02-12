package ru.otus.tests;

import ru.otus.project.Currency;
import ru.otus.tests.unit.MergeArrayTests;
import ru.otus.tests.unit.MoneyArrayTests;
import ru.otus.tests.unit.NumberToTextTests;
import ru.otus.tests.unit.SplitterNumbersTests;

import java.util.ArrayList;

public class AllTests {
    public static void main(String[] args){
        MoneyArrayTests moneyArrayTests = new MoneyArrayTests();
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 100, "рублей");
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 102, "рубля");
        moneyArrayTests.correctDeclinationMoney(Currency.RUB, 1_000_000, "рублей");

        NumberToTextTests numberToTextTest = new NumberToTextTests();
        numberToTextTest.correctNumberToText(103, Currency.RUB, "сто три рубля ");

        SplitterNumbersTests splitterNumbersTest = new SplitterNumbersTests();
        ArrayList<Integer> correctArrayList = new ArrayList<>();
        correctArrayList.add(542);
        correctArrayList.add(132);
        correctArrayList.add(55);
//        correctArrayList.add(21);
        splitterNumbersTest.correctSplitNumber(55132542, correctArrayList);

        MergeArrayTests mergeArrayTests = new MergeArrayTests();
        ArrayList<String> listFirst = new ArrayList<>();
        listFirst.add("1 ");
        listFirst.add("2 ");
        listFirst.add("3 ");
        ArrayList<String> listSecond = new ArrayList<>();
        listSecond.add("1");
        listSecond.add("2");
        listSecond.add("3");
        mergeArrayTests.correctMergeArray(listFirst, listSecond, "3 3 2 2 1 1 ");

    }
}
