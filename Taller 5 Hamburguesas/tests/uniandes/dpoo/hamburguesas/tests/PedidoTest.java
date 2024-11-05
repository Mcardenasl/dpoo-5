package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Pedido;

class PedidoTest {

    @Test
    void testAgregarProducto() {
        Pedido pedido = new Pedido("Juan", "Calle 123");
        ProductoMenu hamburguesa = new ProductoMenu("Hamburguesa", 15000);
        pedido.agregarProducto(hamburguesa);

        assertEquals(15000, pedido.getPrecioTotalPedido(), "El precio total debería ser igual al precio del producto agregado");
    }

    @Test
    void testGenerarTextoFactura() {
        Pedido pedido = new Pedido("Juan", "Calle 123");
        ProductoMenu hamburguesa = new ProductoMenu("Hamburguesa", 15000);
        pedido.agregarProducto(hamburguesa);

        String factura = pedido.generarTextoFactura();
        assertTrue(factura.contains("Juan"), "La factura debería incluir el nombre del cliente");
        assertTrue(factura.contains("Hamburguesa"), "La factura debería incluir el nombre del producto agregado");
        assertTrue(factura.contains("Precio Total:"), "La factura debería incluir el total del pedido");
    }

    @Test
    void testGuardarFactura() throws FileNotFoundException {
        Pedido pedido = new Pedido("Juan", "Calle 123");
        ProductoMenu papas = new ProductoMenu("Papas Fritas", 5000);
        pedido.agregarProducto(papas);

        File archivo = new File("factura_test.txt");
        pedido.guardarFactura(archivo);
        assertTrue(archivo.exists(), "El archivo de factura debería haberse creado");
    }
}
