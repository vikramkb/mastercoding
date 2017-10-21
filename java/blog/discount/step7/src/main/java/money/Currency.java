package money;

public class Currency {

    final private String code;
    final private String currencyName;

    public Currency(String code, String currencyName) {
        this.code = code;
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code=" + code +
                ", currencyName=" + currencyName +
                '}';
    }
}
