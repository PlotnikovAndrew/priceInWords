package ru.otus.project;

import java.util.ArrayList;
import java.util.Collections;

public class SplitterNumbers {

    private SplitterNumbers(){
    }

    public static ArrayList<Integer> splitNumber(int number){
        ArrayList<Integer> splitNumberArray = new ArrayList<>();
        while(number > 0) {
            splitNumberArray.add(number % 1000);
            number /= 1000;
        }
        Collections.reverse(splitNumberArray);
        return splitNumberArray;
    }
}
