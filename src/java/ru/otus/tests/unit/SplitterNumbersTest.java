package ru.otus.tests.unit;

import java.util.ArrayList;
import static ru.otus.assertions.Assertions.*;
import static ru.otus.project.SplitterNumbers.*;

public class SplitterNumbersTest {

    public void correctSplitNumber(int number, ArrayList<Integer> correctArrayList) {
        String scenario = "Тест на корректное разбиение числа на тысяные доли";

        ArrayList<Integer> expectedArrayList = splitNumber(number);

        try {
            assertSplitNumberMethod(expectedArrayList, correctArrayList);
            System.out.printf("%s: passed" , scenario);
            System.out.println();
        } catch (AssertionError ex){
            System.err.printf("%s: fails with message: %s" , scenario, ex.getMessage());
            System.out.println();
        }
    }
}
