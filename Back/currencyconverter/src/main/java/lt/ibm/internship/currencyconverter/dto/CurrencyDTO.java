package lt.ibm.internship.currencyconverter.dto;

public class CurrencyDTO {

    private final String currency;
    private final double rate;

    private CurrencyDTO(Builder builder) {
        this.currency = builder.currency;
        this.rate = builder.rate;
    }

    public static class Builder {
        private String currency;
        private Double rate;

        public Builder currency(final String currency) {
            this.currency = currency;
            return this;
        }

        public Builder rate(final double rate) {
            this.rate = rate;
            return this;
        }

        public CurrencyDTO build() {
            return new CurrencyDTO(this);
        }
    }

    public String getCurrency() {
        return currency;
    }

    public double getRate() {
        return rate;
    }
}
