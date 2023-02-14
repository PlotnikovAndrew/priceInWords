package ru.otus.project;

public class Main {
    public static void main(String[] args) {
        NumberToText numberToTextRubles = new NumberToText(45_187_421, Currency.RUB);
        NumberToText numberToTextDollars = new NumberToText(673_101_913, Currency.USD);
        System.out.println(numberToTextRubles.getTextNumber());
        System.out.println(numberToTextDollars.getTextNumber());
    }
}