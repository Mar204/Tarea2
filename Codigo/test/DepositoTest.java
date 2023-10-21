//---------------------------------Imports---------------------------------------------------
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DepositoTest {
    @Test
    void añadir3intsYQuitar1(){
        Deposito<Integer> depo = new Deposito<>();
        depo.addElemento(7);
        depo.addElemento(1);
        depo.addElemento(4);
        assertEquals(3,depo.getElemento());
    }
    @Test
    void quedarseSinElementos(){
        Deposito<String> depo = new Deposito<>();
        depo.addElemento("baba");
        depo.getElemento();
        assertNull(depo.getElemento());
    }
    @Test
    void depositoVacio(){
        Deposito<String> depo = new Deposito<>();
        assertNull(depo.getElemento());
    }
}