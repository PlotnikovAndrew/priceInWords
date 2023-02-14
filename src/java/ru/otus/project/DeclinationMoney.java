package ru.otus.project;

public class DeclinationMoney {
    private static final String[] RUBLES = {"рубль", "рубля", "рублей"};
    private static final String[] DOLLARS = {"доллар", "доллара", "долларов"};

    private final Currency currency;

    public DeclinationMoney(Currency currency){
        this.currency = currency;
    }

    public String getDeclinationMoneyString(int moneyInt) {
        if (currency == Currency.RUB) {
            moneyInt = Math.abs(moneyInt) % 100;
            int moneyInt1 = moneyInt % 10;
            if (moneyInt > 10 && moneyInt < 20) return RUBLES[2];
            if (moneyInt1 > 1 && moneyInt1 < 5) return RUBLES[1];
            if (moneyInt1 == 1) return RUBLES[0];
            return RUBLES[2];
        } else if (currency == Currency.USD){
            moneyInt = Math.abs(moneyInt) % 100;
            int moneyInt1 = moneyInt % 10;
            if (moneyInt > 10 && moneyInt < 20) return DOLLARS[2];
            if (moneyInt1 > 1 && moneyInt1 < 5) return DOLLARS[1];
            if (moneyInt1 == 1) return DOLLARS[0];
            return DOLLARS[2];
        }
        throw new RuntimeException("Currency not supported at the moment");
    }
}
