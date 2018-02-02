package konto;

public class Konto {
    private int nr;
    private int saldo;
    private String kontoType;

    public Konto(int inputNr, int inputSaldo, String inputKontoType) {
        setNr(inputNr);
        setSaldo(inputSaldo);
        setKontoType(inputKontoType);
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int inputNr) {
        this.nr = inputNr;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int inputSaldo) {
        this.saldo = inputSaldo;
    }

    public String getKontoType() {
        return kontoType;
    }

    public void setKontoType(String inputKontoType) {
        this.kontoType = inputKontoType;
    }

    public void indsætBeløb(int inputSaldo) {
        this.saldo = this.saldo + inputSaldo;
    }

}
