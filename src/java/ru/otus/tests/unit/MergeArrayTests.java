package ru.otus.tests.unit;

import java.util.ArrayList;

import static ru.otus.assertions.Assertions.*;
import static ru.otus.project.MergeArray.*;

public class MergeArrayTests {

    public void correctMergeArray(ArrayList<String> dividedNumberString, ArrayList<String> numberName, String correctMergeedString) {
        String scenario = "Тест на корректное слияние двух ArrayLists";

        String expectedMergeedString = mergeArray(dividedNumberString, numberName);

        try {
            assertMergeArrayMethod(expectedMergeedString, correctMergeedString);
            System.out.printf("%s: passed" , scenario);
            System.out.println();
        } catch (AssertionError ex){
            System.err.printf("%s: fails with message: %s" , scenario, ex.getMessage());
            System.out.println();
        }
    }
}
