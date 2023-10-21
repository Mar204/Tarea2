import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    Expendedor exp;

    @BeforeEach
    void setUp() {
        exp = new Expendedor(3);
    }
    @Test
    @DisplayName("Test 12")
    void comprarSnickers() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto snick = exp.comprarProducto(new Moneda1500(),Enumeracion.SNICKER);
        assertTrue(snick instanceof Snicker);
    }
    @Test
    @DisplayName("Test 13")
    void comprarCoca() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto coc =exp.comprarProducto(new Moneda1500(),Enumeracion.COCA_COLA);
        assertTrue(coc instanceof CocaCola);
    }
    @Test
    @DisplayName("Test 14")
    void comprarSinVuelto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto prod = exp.comprarProducto(new Moneda100(),Enumeracion.COCA_COLA);
        assertNull(exp.getVuelto());
    }
    @Test
    @DisplayName("Test 15")
    void vueltoDe200() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto prod = exp.comprarProducto(new Moneda500(),Enumeracion.FANTA);
        Moneda v = exp.getVuelto();
        int vuelto = 0;
        while(v != null){
            vuelto += v.getValor();
            v = exp.getVuelto();
        }
        assertEquals(200,vuelto);
    }
    @Test
    @DisplayName("Test 16")
    void vueltoDe1300() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Producto prod = exp.comprarProducto(new Moneda1500(),Enumeracion.SPRITE);
        Moneda v = exp.getVuelto();
        int vuelto = 0;
        while(v != null){
            vuelto += v.getValor();
            v = exp.getVuelto();
        }
        assertEquals(1300,vuelto);
    }
    @Test
    @DisplayName("Test 17")
    void dineroInsuficiente() throws NoHayProductoException, PagoIncorrectoException {
        Moneda m = new Moneda100();
        try{
            Producto prod = exp.comprarProducto(m,Enumeracion.SUPER8);
            fail("deberia aparecer PagoInsuficienteException");
        }catch (PagoInsuficienteException e){
            assertEquals(m,exp.getVuelto());
        }
    }
    @Test
    @DisplayName("Test 18")
    void sinProductos() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        exp.comprarProducto(new Moneda1500(),Enumeracion.COCA_COLA);
        exp.comprarProducto(new Moneda1500(),Enumeracion.COCA_COLA);
        exp.comprarProducto(new Moneda1500(),Enumeracion.COCA_COLA);
        while(exp.getVuelto() != null)exp.getVuelto();
        Moneda m = new Moneda1500();
        try{
            exp.comprarProducto(m,Enumeracion.COCA_COLA);
            fail("deberia aparecer NoHayProductoException");
        }catch(NoHayProductoException e){
            assertEquals(m,exp.getVuelto());
        }
    }
    @Test
    @DisplayName("Test 19")
    void sinMoneda()throws NoHayProductoException, PagoInsuficienteException{
        try{
            exp.comprarProducto(null,Enumeracion.COCA_COLA);
            fail("deberia aparecer PagoIncorrectoException");
        }catch(PagoIncorrectoException e){
            assertNull(exp.getVuelto());
        }
    }

}