public enum Moeda {
    DOLAR(6.10), EURO(6.25), REAL(1.0);

    private final double taxa;

    Moeda(double taxa) {
        this.taxa = taxa;
    }

    public double converterPara(double valorEmReais) {
        return valorEmReais / taxa;
    }
}