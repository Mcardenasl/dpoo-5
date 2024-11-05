package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Combo;

class ComboTest {

    @Test
    void testGetNombre() {
        ArrayList<ProductoMenu> items = new ArrayList<>();
        Combo combo = new Combo("Combo Especial", 0.07, items);
        assertEquals("Combo Especial", combo.getNombre(), "El nombre del combo debería coincidir");
    }

    @Test
    void testCalcularPrecioConDescuento() {
        ProductoMenu hamburguesa = new ProductoMenu("Hamburguesa", 15000);
        ProductoMenu papas = new ProductoMenu("Papas Fritas", 5000);
        ArrayList<ProductoMenu> items = new ArrayList<>();
        items.add(hamburguesa);
        items.add(papas);

        Combo combo = new Combo("Combo Especial", 0.93, items);

        int precioEsperado = (int) ((15000 + 5000) * 0.93);
        assertEquals(precioEsperado, combo.getPrecio(), "El precio debe reflejar el descuento del combo");
    }

    @Test
    void testGenerarTextoFactura() {
        ArrayList<ProductoMenu> items = new ArrayList<>();
        Combo combo = new Combo("Combo Especial", 0.93, items);

        String factura = combo.generarTextoFactura();
        assertTrue(factura.contains("Combo Especial"), "La factura debe contener el nombre del combo");
    }
}
