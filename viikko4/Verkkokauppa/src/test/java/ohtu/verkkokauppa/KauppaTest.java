package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa kauppa;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);

        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(5);
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "suklaa", 6));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "omena", 4));

        kauppa = new Kauppa(varasto, pankki, viite);
        kauppa.aloitaAsiointi();
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki, times(1)).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreillaKunEriTuotteita() {
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki, times(1)).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(11));
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreillaKunUseaSamaaTuotetta() {
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki, times(1)).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(10));
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreillaKunOsaTuotteistaLoppu() {
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki, times(1)).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));
    }

    @Test
    public void aloitaAsiointiNollaaEdellisenOstoksenTiedot() {
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("joku", "123456789");

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki, times(1)).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(6));
    }

    @Test
    public void kauppaPyytaaUudenViitenumeronJokaiselleMaksutapahtumalle() {
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(viite, times(1)).uusi();

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(viite, times(2)).uusi();

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(viite, times(3)).uusi();
    }

    @Test
    public void koristaPoistaminenOnnistuu() {
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki, times(1)).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(10));
    }

}
