package ru.otus.project;

import java.util.ArrayList;

public class MergeArray {

    private MergeArray(){
    }

    public static String mergeArray(ArrayList<String> dividedNumberString, ArrayList<String> numberName){

        StringBuilder mergeString = new StringBuilder();

        for (int i = dividedNumberString.size()-1; i > -1; i--){
            mergeString.append(dividedNumberString.get(i)).append(numberName.get(i)).append(" ");
        }

        return mergeString.toString();
    }
}
