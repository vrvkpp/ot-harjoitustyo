
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaksukorttiTest {
    Maksukortti kortti;
    
    public MaksukorttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {}
     
     @Test
     public void konstruktoriAsettaaSaldonOikein() {
         
         String vastaus = kortti.toString();
         
         assertEquals("Kortilla on rahaa 10.0 euroa", vastaus);
     }
     @Test
     public void syoEdullisestiVahentaaSaldoaOikein() {
         
         kortti.syoEdullisesti();
         
         assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
     }
     @Test
     public void syoMaukkaastiVahentaaSaldoaOikein() {
         kortti.syoMaukkaasti();
         
         assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
     }
     @Test
     public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
         kortti.syoMaukkaasti();
         kortti.syoMaukkaasti();
         
         kortti.syoEdullisesti();
         
         assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
     }
     @Test
     public void kortilleVoiLadataRahaa() {
         kortti.lataaRahaa(25);
         assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
     }
     @Test
     public void kortinSaldoEiYlitaMaksimiarvoa() {
         kortti.lataaRahaa(200);
         assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
     }
     @Test
     public void syoMaukkaastiEiVieKortinSaldoaNegatiiviseksi() {
         kortti.syoMaukkaasti();
         kortti.syoMaukkaasti();
         kortti.syoMaukkaasti();
         assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
     }
     @Test
     public void negatiivinenSummaEiMuutaSaldoa() {
         kortti.lataaRahaa(-15);
         
         assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
     }
     @Test
     public void kortillaVoiOstaajuuriEdullisenAterian() {
         Maksukortti testi = new Maksukortti(2.5);
         testi.syoEdullisesti();
         assertEquals("Kortilla on rahaa 0.0 euroa", testi.toString());
     }
     @Test
     public void kortillaVoiOstaaMaukkaanAterian() {
         Maksukortti testi = new Maksukortti(4);
         testi.syoMaukkaasti();
         assertEquals("Kortilla on rahaa 0.0 euroa", testi.toString());
     }
}
