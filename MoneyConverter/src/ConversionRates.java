public class ConversionRates {
    private double ARS;
    private double BRL;
    private double COP;
    private double USD;

    public double getARS() {
        return ARS;
    }

    public void setARS(double ARS) {
        this.ARS = ARS;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }

    public double getCOP() {
        return COP;
    }

    public void setCOP(double COP) {
        this.COP = COP;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double get(String currencyCode) {
        switch (currencyCode) {
            case "ARS":
                return getARS();
            case "BRL":
                return getBRL();
            case "COP":
                return getCOP();
            case "USD":
                return getUSD();
            default:
                throw new IllegalArgumentException("Unsupported currency code");
        }
    }
}
