//----------------------------------------------Imports----------------------------------
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    Comprador comprador;
    Expendedor exp;
    @BeforeEach
    void setUp() {
        exp = new Expendedor(1);
    }
    //---------------------------------Test Compra Productos---------------------------------------------------
    @Test
    @DisplayName("Test 1")
    void comprarSnicker() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda500(),Enumeracion.SNICKER,exp);
        assertEquals("Snicker: \n Sabor: 'chocolate ; almendras y caramelo'",comprador.queBebiste());
    }
    @Test
    @DisplayName("Test 2")
    void comprarSuper8() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda500(),Enumeracion.SUPER8,exp);
        assertEquals("Super 8r: \n Sabor: 'galleta y chocolate'",comprador.queBebiste());
    }

    @Test
    @DisplayName("Test 3")
    void comprarSprite() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda500(),Enumeracion.SPRITE,exp);
        assertEquals("Sprite: \n Sabor: 'Limón'",comprador.queBebiste());
    }

    //---------------------------------Test Pagos y Vuelto---------------------------------------------------
    @Test
    @DisplayName("Test 4")
    void vueltoDe200() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda500(),Enumeracion.FANTA,exp);
        assertEquals(200,comprador.cuantoVuelto());
    }

    @Test
    @DisplayName("Test 5")
    void pagoExacto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        comprador = new Comprador(new Moneda100(),Enumeracion.COCA_COLA,exp);
        assertEquals(0,comprador.cuantoVuelto());
    }

    //---------------------------------Test Ecepcion 1: No hay Stock---------------------------------------------------
    @Test
    @DisplayName("Test 6")
    void sinStock() throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        exp.comprarProducto(new Moneda500(),Enumeracion.COCA_COLA);
        Moneda m = new Moneda500();
        try{
            comprador = new Comprador(m,Enumeracion.COCA_COLA,exp);
            fail("deberia aparecer NoHayProductoException");
        }catch (NoHayProductoException ignored){}
    }
    //---------------------------------Test Ecepcion 32: Moneda nula :(---------------------------------------------------
    @Test
    @DisplayName("Test 7")
    void pagoIncorrecto() throws PagoInsuficienteException, NoHayProductoException{
        try{
            comprador = new Comprador(null,Enumeracion.SNICKER,exp);
            fail("deberia aparecerPagoIncorrectoException");
        }catch (PagoIncorrectoException ignored){}
    }

    //---------------------------------Test Ecepcion 3: No alcanza---------------------------------------------------
    @Test
    @DisplayName("Test 8")
    void pagoInsuficiente() throws PagoIncorrectoException, NoHayProductoException {
        Moneda m = new Moneda100();
        try{
            comprador = new Comprador(m,Enumeracion.SNICKER,exp);
            fail("deberia aparecer PagoInsuficienteException");
        }catch (PagoInsuficienteException ignored){}

    }
}
