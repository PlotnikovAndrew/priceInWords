package ru.otus.project;


import java.util.ArrayList;

import static ru.otus.project.SplitterNumbers.*;

public class NumberToText {

    private static final String[][] NUMBERS_FROM_ONE_TO_NINE = {
            {"","один","два","три","четыре","пять","шесть","семь","восемь","девять"},
            {"","одна","две","три","четыре","пять","шесть","семь","восемь","девять"}
    };

    private static final String[] NUMBERS_FROM_TEN_TO_TWENTY= {
            "","одиннадцать","двенадцать","тринадцать","четырнадцать", "пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать"
    };

    private static final String[] MULTIPLES_OF_TEN = {
            "", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
    };

    private static final String[] MULTIPLES_OF_HUNDRED = {
            "","сто","двести","триста","четыреста","пятьсот","шестьсот","семьсот", "восемьсот","девятьсот"
    };

    private static final String[][] MULTIPLES_OF_THOUSAND= {
            {"тысяча", "тысячи", "тысяч", "1"},
            {"миллион", "миллиона", "миллионов", "0"},
            {"миллиард","миллиарда","миллиардов","0"},
            {"триллион","триллиона","триллионов","0"}
    };


    private String textNumber;
    private final ArrayList<Integer> dividedNumberInteger;
    private final ArrayList<String> dividedNumberString = new ArrayList<>();
    private final ArrayList<String> numberName = new ArrayList<>();
    private final DeclinationMoney declinationMoney;

    public NumberToText(int moneyNumber, Currency currency){
        this.declinationMoney = new DeclinationMoney(currency);
        this.dividedNumberInteger = splitNumber(moneyNumber);
        this.makeDividedNumberString();
        this.addWords();
        this.mergeArray();
    }

    public String getTextNumber() {
        return textNumber;
    }

    private String transfiguration(int number, boolean isThousand){

        ArrayList<String> arrayListString = new ArrayList<>();
        StringBuilder string = new StringBuilder();
        int numberHundred = number / 100;
        int numberTen = number % 100;
        int numberOne = number % 10;

        if (number == 0){
            arrayListString.add("");
        }

        if (numberHundred != 0){
            arrayListString.add(MULTIPLES_OF_HUNDRED[numberHundred]);
        }

        if (10 < numberTen && numberTen < 20){
            int numIndex = numberTen % 10;
            arrayListString.add(NUMBERS_FROM_TEN_TO_TWENTY[numIndex]);
        } else if (numberTen < 10) {
            if (numberOne != 0 && isThousand){
                arrayListString.add(NUMBERS_FROM_ONE_TO_NINE[1][numberOne]);
            }
            if (numberOne != 0 && !isThousand){
                arrayListString.add(NUMBERS_FROM_ONE_TO_NINE[0][numberOne]);
            }
        } else {
            numberTen = numberTen/10;
            arrayListString.add(MULTIPLES_OF_TEN[numberTen]);
            if (numberOne != 0 && isThousand){
                arrayListString.add(NUMBERS_FROM_ONE_TO_NINE[1][numberOne]);
            }
            if (numberOne != 0 && !isThousand){
                arrayListString.add(NUMBERS_FROM_ONE_TO_NINE[0][numberOne]);
            }
        }

        for (String str: arrayListString){
            string.append(str).append(" ");
        }

        return string.toString();
    }

    private void makeDividedNumberString(){

        for (int i = 0; i < dividedNumberInteger.size(); i++) {
            int num = dividedNumberInteger.get(i);
            String convertedToString;
            if (i == 1){
                convertedToString = this.transfiguration(num, true);
            } else {
                convertedToString = this.transfiguration(num, false);
            }
            dividedNumberString.add(convertedToString);
        }
    }

    private void addWords(){
        int number = this.dividedNumberInteger.get(0);
        String currency = this.declinationMoney.getDeclinationMoneyString(number);
        numberName.add(currency);
        for (int i = 1; i < dividedNumberInteger.size(); i++){
            int word = dividedNumberInteger.get(i);
            word = Math.abs(word) % 100;
            int word1 = word % 10;
            if (word > 10 && word < 20){
                numberName.add(MULTIPLES_OF_THOUSAND[i-1][2]);
                continue;
            }
            if (word1 > 1 && word1 < 5){
                numberName.add(MULTIPLES_OF_THOUSAND[i-1][1]);
                continue;
            }
            if (word1 == 1) {
                numberName.add(MULTIPLES_OF_THOUSAND[i-1][0]);
                continue;
            }
            numberName.add(MULTIPLES_OF_THOUSAND[i-1][2]);
        }
    }

    private void mergeArray(){
        StringBuilder mergeString = new StringBuilder();
        for (int i = dividedNumberString.size()-1; i > -1; i--){
            mergeString.append(dividedNumberString.get(i)).append(numberName.get(i)).append(" ");
        }
        this.textNumber = mergeString.toString();
    }

}
