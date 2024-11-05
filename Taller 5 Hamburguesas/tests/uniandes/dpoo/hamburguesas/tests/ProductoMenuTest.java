package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ProductoMenuTest {

    @Test
    void testConstructorAndGetters() {
        ProductoMenu producto = new ProductoMenu("Hamburguesa", 15000);
        assertEquals("Hamburguesa", producto.getNombre(), "El nombre debería coincidir con el asignado en el constructor");
        assertEquals(15000, producto.getPrecio(), "El precio debería coincidir con el valor asignado en el constructor");
    }

    @Test
    void testGetPrecio() {
        ProductoMenu producto = new ProductoMenu("Papas Fritas", 5000);
        assertEquals(5000, producto.getPrecio(), "El precio debería ser el mismo que el valor base del producto");
    }

    @Test
    void testGenerarTextoFactura() {
        ProductoMenu producto = new ProductoMenu("Refresco", 3000);
        String factura = producto.generarTextoFactura();

        assertTrue(factura.contains("Refresco"), "La factura debe contener el nombre del producto");
        assertTrue(factura.contains("3000"), "La factura debe contener el precio del producto en el formato adecuado");
    }
}
