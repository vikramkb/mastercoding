package money;

final public class MoneySingletonFactory {
    final private static Currencies currencies = new Currencies();
    final private static MoneyExchange exchange = new MoneyExchange();

    public static Currencies getCurrencies() {
        return currencies;
    }

    public static MoneyExchange getExchange() {
        return exchange;
    }
}
