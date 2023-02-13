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
        numberToTextTest.correctNumberToText( 130103, Currency.RUB, "сто тридцать тысяч сто три рубля");

        SplitterNumbersTests splitterNumbersTest = new SplitterNumbersTests();
        ArrayList<Integer> correctArrayList = new ArrayList<>();
        correctArrayList.add(55);
        correctArrayList.add(132);
        correctArrayList.add(542);
//        correctArrayList.add(21);
        splitterNumbersTest.correctSplitNumber(55132542, correctArrayList);

        MergeArrayTests mergeArrayTests = new MergeArrayTests();
        ArrayList<String> listFirst = new ArrayList<>();
        listFirst.add("1");
        listFirst.add("3");
        listFirst.add("5");
        ArrayList<String> listSecond = new ArrayList<>();
        listSecond.add("2");
        listSecond.add("4");
        listSecond.add("6");
        mergeArrayTests.correctMergeArray(listFirst, listSecond, "1 2 3 4 5 6");

    }
}
