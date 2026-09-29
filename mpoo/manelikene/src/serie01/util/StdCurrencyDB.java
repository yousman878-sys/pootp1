package serie01.util;

public class StdCurrencyDB implements CurrencyDB {

    private Currency[] currencies;

    public StdCurrencyDB() {
        currencies = new Currency[CurrencyId.values().length];

        for (CurrencyId id : CurrencyId.values()) {
            currencies[id.ordinal()] = new StdCurrency(
                id,
                id.rateForYear2001()
            );
        }
    }

    @Override
    public Currency getCurrency(CurrencyId id) {
        return currencies[id.ordinal()];
    }

    @Override
    public void sync() throws DBAccessException {
        for (CurrencyId id : CurrencyId.values()) {
            currencies[id.ordinal()].setExchangeRate(id.rateForYear2001());
        }
    }
}
