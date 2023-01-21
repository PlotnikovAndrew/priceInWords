package ru.otus.project;


import java.util.ArrayList;

public class NumbersToString {

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

    private final ArrayList<Integer> dividedNumberInteger = new ArrayList<>();
    private final ArrayList<String> dividedNumberString = new ArrayList<>();
    private final ArrayList<String> wordsString = new ArrayList<>();
    private MoneyArray moneyArray = new MoneyArray(Currency.USD);

    NumbersToString(int moneyNumber, MoneyArray moneyArray){
        this.dividedNumber(moneyNumber);
        this.moneyArray = moneyArray;
    }

    public void dividedNumber (int moneyNumber){
        while(moneyNumber > 0) {
            dividedNumberInteger.add(moneyNumber % 1000);
            moneyNumber /= 1000;
        }
        System.out.println(dividedNumberInteger);
    }

    public String transfiguration(int number, boolean isThousand){

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

        if (numberTen > 10 && numberTen < 20){
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

    public void makeDividedNumberString(){

        for (int i = 0; i < dividedNumberInteger.size(); i++) {
            int num = dividedNumberInteger.get(i);
            if (i == 1){
                String str = this.transfiguration(num, true);
                dividedNumberString.add(str);
            } else {
                String str = this.transfiguration(num, false);
                dividedNumberString.add(str);
            }
        }
        System.out.println(dividedNumberString);
    }

    public void addWords(){
        int number = this.dividedNumberInteger.get(0);
        String currency = this.moneyArray.getMoneyString(number);
        wordsString.add(currency);
        for (int i = 1; i < dividedNumberInteger.size(); i++){
            int word = dividedNumberInteger.get(i);
            word = Math.abs(word) % 100;
            int word1 = word % 10;
            if (word > 10 && word < 20){
                wordsString.add(MULTIPLES_OF_THOUSAND[i-1][2]);
                continue;
            }
            if (word1 > 1 && word1 < 5){
                wordsString.add(MULTIPLES_OF_THOUSAND[i-1][1]);
                continue;
            }
            if (word1 == 1) {
                wordsString.add(MULTIPLES_OF_THOUSAND[i-1][0]);
                continue;
            }
            wordsString.add(MULTIPLES_OF_THOUSAND[i-1][2]);
        }
        System.out.println(wordsString);
    }

    public void concatArray(){
        String str = "";
        for (int i = dividedNumberString.size()-1; i > -1; i--){
            str += dividedNumberString.get(i)+ wordsString.get(i) + " ";
            System.out.println(str);
        }
        System.out.println(str);
    }


}
