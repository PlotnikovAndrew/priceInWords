package ru.otus.project;

public enum Currency {

    RUB("RUBLES"),
    USD("DOLLARS");

    private String name;

   Currency (String name){
        this.name = name;
   }

   public String getName(){
       return name;
   }
}
