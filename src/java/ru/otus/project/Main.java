package ru.otus.project;

public class Main {
    public static void main(String[] args) {
        MoneyArray moneyArrayRubles = new MoneyArray(Currency.RUB);
        MoneyArray moneyArrayDollars = new MoneyArray(Currency.USD);
        NumberToText numberToTextRubles = new NumberToText(1_345_124_131, moneyArrayRubles);
        NumberToText numberToTextDollars = new NumberToText(673_101_913, moneyArrayDollars);
        System.out.println(numberToTextRubles.getTextNumber());
        System.out.println(numberToTextDollars.getTextNumber());
    }
}