package money;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Currencies {
    /*ideally currencies to be loaded from api, db, file ... etc sources. Hard coded for the simplicity*/
    final private Map<String, Currency> currencies = Collections.unmodifiableMap(new HashMap<String, Currency>(){
        {
            put("INR", new Currency("INR", "Indian Rupees"));
            put("USD", new Currency("USD", "USD"));
        }
    });

    public Currency get(String currencyCode) {
        return currencies.get(currencyCode);
    }

    public Currency defaultCurrency() {
        return currencies.get("INR");
    }
}
