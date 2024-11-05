package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;

class ProductoAjustadoTest {

    @Test
    void testGetNombre() {
        ProductoMenu base = new ProductoMenu("Hamburguesa", 15000);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);
        assertEquals("Hamburguesa", productoAjustado.getNombre(), "El nombre debería ser el mismo que el producto base");
    }

    @Test
    void testGetPrecio() {
        ProductoMenu base = new ProductoMenu("Hamburguesa", 15000);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);

        assertEquals(0, productoAjustado.getPrecio(), "El precio debería ser el mismo que el producto base sin ingredientes adicionales");
    }

    @Test
    void testGenerarTextoFactura() {
        ProductoMenu base = new ProductoMenu("Hamburguesa", 15000);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);

        String factura = productoAjustado.generarTextoFactura();
        assertTrue(factura.contains("Hamburguesa"), "La factura debería incluir el nombre del producto base");
    }
}
