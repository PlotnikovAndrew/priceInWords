package ru.otus.project;

import java.util.ArrayList;

public class MergeArray {

    private MergeArray(){
    }

    public static String mergeArray(ArrayList<String> dividedNumberString, ArrayList<String> numberName){

        StringBuilder mergeString = new StringBuilder();
        if(1 == dividedNumberString.size() - numberName.size()) {
            for (int i = 0; i < dividedNumberString.size(); i++) {
                if (i == dividedNumberString.size() - 1) {
                    mergeString.append(dividedNumberString.get(i));
                } else {
                    mergeString.append(dividedNumberString.get(i)).append(" ").append(numberName.get(i)).append(" ");
                }
            }
        } else if(dividedNumberString.size() == numberName.size()){
            for (int i = 0; i < dividedNumberString.size(); i++) {
                if (i == dividedNumberString.size() - 1) {
                    mergeString.append(dividedNumberString.get(i)).append(" ").append(numberName.get(i));
                } else {
                    mergeString.append(dividedNumberString.get(i)).append(" ").append(numberName.get(i)).append(" ");
                }
            }
        } else {
            throw new RuntimeException("ArrayList's do not match documentation");
        }
        return mergeString.toString();
    }
}
