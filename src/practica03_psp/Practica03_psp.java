package practica03_psp;

import controlador.ListaClientes;
import java.time.LocalDate;
import modelo.Cliente;
import vista.VentanaPrincipal;

public class Practica03_psp {
    public static void main(String[] args) {
        javax.swing.JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        java.awt.EventQueue.invokeLater(() -> {
            // CREO UNA LISTA DE CLIENTES
            ListaClientes lista = new ListaClientes();
            // AÑADO EL PRIMER CLIENTE MEDIANTE EL MÉTODO DE LA CLASE LISTACLIENTES DEL MISMO NOMBRE
            lista.añadirCliente(new Cliente(1, "JAIME", 250, LocalDate.of(1998, 3, 14)));
            
            // CREO UNA VENTANAPRINCIPAL CON LA LISTA
            new VentanaPrincipal(lista).setVisible(true);
        });
    }
}