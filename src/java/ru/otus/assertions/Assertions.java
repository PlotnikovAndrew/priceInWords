package ru.otus.assertions;


public class Assertions {

    public static void assertGetMoneyStringMethod(String returnedDeclinationString, String correctDeclinationString){
        if(!(correctDeclinationString.equals(returnedDeclinationString))){
            throw new  AssertionError(String.format("Expected %s, return %s", correctDeclinationString, returnedDeclinationString));
        }
    }
    public static void assertGetTextNumberMethod(String returnedTextNumber, String correctTextNumber){
        if(!(correctTextNumber.equals(returnedTextNumber))){
            throw new  AssertionError(String.format("Expected %s, return %s", correctTextNumber, returnedTextNumber));
        }
    }
}
