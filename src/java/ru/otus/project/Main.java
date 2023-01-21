package ru.otus.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MoneyArray moneyArray = new MoneyArray(Currency.RUB);
//        System.out.println(moneyArray.getMoneyString(10000, Currency.RUB));
//        ArrayList<Integer> arrayList = new ArrayList<>();

        NumbersToString numbersToString = new NumbersToString(1_234_905_165,moneyArray);
        numbersToString.makeDividedNumberString();
        numbersToString.addWords();
        numbersToString.concatArray();
//        for (int i = 0; i < 100; i++){
//            NumbersToString numbersToString = new NumbersToString(i);
//            numbersToString.makeDividedNumberString();
//            numbersToString.addWords();
//        }

//        int num = 4;
//        int num2 = 4%10;
//        System.out.println(num2);
    }
}