package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

class RestauranteTest {

    @Test
    void testIniciarPedido() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.iniciarPedido("Pedro", "Calle Falsa 123");

        assertNotNull(restaurante.getPedidoEnCurso(), "Debería haber un pedido en curso después de iniciar uno nuevo");
        assertEquals("Pedro", restaurante.getPedidoEnCurso().getNombreCliente(), "El nombre del cliente debe coincidir");
    }

    @Test
    void testCerrarYGuardarPedido() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.iniciarPedido("Cliente Test", "Calle Falsa 123");
        restaurante.cerrarYGuardarPedido();

        assertNull(restaurante.getPedidoEnCurso(), "No debería haber un pedido en curso después de cerrarlo");
    }

    @Test
    void testCargarInformacionRestaurante() throws IOException, NumberFormatException, HamburguesaException {
        Restaurante restaurante = new Restaurante();
        File archivoIngredientes = new File("data/ingredientes.txt");
        File archivoMenu = new File("data/menu.txt");
        File archivoCombos = new File("data/combos.txt");

        restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);

        assertFalse(restaurante.getIngredientes().isEmpty(), "La lista de ingredientes no debería estar vacía después de cargar");
        assertFalse(restaurante.getMenuBase().isEmpty(), "El menú base no debería estar vacío después de cargar");
        assertFalse(restaurante.getMenuCombos().isEmpty(), "El menú de combos no debería estar vacío después de cargar");
    }
}
