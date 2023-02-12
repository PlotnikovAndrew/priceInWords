package ru.otus.assertions;


import java.util.ArrayList;

public class Assertions {

    public static void assertGetMoneyStringMethod(String expectedDeclinationString, String correctDeclinationString){
        if(!(correctDeclinationString.equals(expectedDeclinationString))){
            throw new  AssertionError(String.format("Expected %s, return %s", correctDeclinationString, expectedDeclinationString));
        }
    }

    public static void assertGetTextNumberMethod(String expectedTextNumber, String correctTextNumber){
        if(!(correctTextNumber.equals(expectedTextNumber))){
            throw new  AssertionError(String.format("Expected %s, return %s", correctTextNumber, expectedTextNumber));
        }
    }

    public static void assertSplitNumberMethod(ArrayList<Integer> expectedArrayList, ArrayList<Integer> correctArrayList){
        if(!expectedArrayList.equals(correctArrayList)){
            throw new  AssertionError("Arrays are not equal");
        }
    }

    public static void assertMergeArrayMethod(String expectedMergeArray, String correctMergeArray){
        if(!(correctMergeArray.equals(expectedMergeArray))){
            throw new  AssertionError(String.format("Expected %s, return %s", correctMergeArray, expectedMergeArray));
        }
    }
}
