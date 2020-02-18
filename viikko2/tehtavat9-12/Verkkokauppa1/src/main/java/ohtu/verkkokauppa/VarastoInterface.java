package ohtu.verkkokauppa;

interface VarastoInterface {
    Tuote haeTuote(int i);

    int saldo(int i);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);
}