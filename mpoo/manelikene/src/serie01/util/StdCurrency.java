package serie01.util;

import util.Contract;

public class StdCurrency implements Currency {
	private CurrencyId id;
    private double exchangeRate;
	public StdCurrency (CurrencyId id, double r) {
		Contract.checkCondition(id != null && r > 0, "");
		this.id = id;
		this.exchangeRate = r;
	}

	@Override
	public CurrencyId getId() {
		return id ;
	}

	@Override
	public double getExchangeRate() {
		return exchangeRate;
	}

	@Override
	public String getIsoCode() {

		return id.isoCode();
	}

	@Override
	public String getCountry() {
		return id.location();
	}

	@Override
	public String getName() {
		return id.denomination();
	}

	@Override
	public void setExchangeRate(double r) {
		 Contract.checkCondition(r > 0 && getId() != CurrencyId.EUR, "");

	        this.exchangeRate = r;
	}

}
