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
    String kaupanTili = "33333-44455";

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        kauppa = new Kauppa(varasto, pankki, viite);
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    }

    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArgumenteilla() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        kauppa.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", kaupanTili, 5);
    }

    @Test
    public void kahdenEriTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArgumenteilla() {
        when(varasto.saldo(2)).thenReturn(5);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "tuote2", 2));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", kaupanTili, 7);
    }

    @Test
    public void kahdenSamanTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArgumenteilla() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", kaupanTili, 10);
    }

    @Test
    public void loppuneenJaVarastossaOlevanTuotteenOstoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArgumenteilla() {
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(1, "tuote2", 4));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", kaupanTili, 5);
    }

    @Test
    public void aloitAsiointiNollaaEdellisenOstoksenTiedot() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", kaupanTili, 5);

        when(viite.uusi()).thenReturn(43);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", viite.uusi(), "12345", kaupanTili, 5);

    }

    @Test
    public void uusiViitenumeroJokaiselleMaksutapahtumalle() {
        when(viite.uusi()).thenReturn(42).thenReturn(43).thenReturn(44);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(anyString(), eq(42), anyString(), anyString(), anyInt());
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(anyString(), eq(43), anyString(), anyString(), anyInt());

        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(anyString(), eq(44), anyString(), anyString(), anyInt());

    }

    @Test
    public void poistaTuotePoistaaTuotteenOstoskorista() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.poistaKorista(1);
        verify(varasto).palautaVarastoon(new Tuote(1, "maito", 5));
    }

}
