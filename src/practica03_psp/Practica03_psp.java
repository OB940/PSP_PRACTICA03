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
            // AÑADO TRES CLIENTES MEDIANTE EL MÉTODO DE LA CLASE LISTACLIENTES DEL MISMO NOMBRE
            lista.añadirCliente(new Cliente(1, "JAIME JIMÉNEZ GÓMEZ", 250, LocalDate.of(1998, 3, 14)));
            lista.añadirCliente(new Cliente(2, "ALBA GARCÍA PRIETO", 500, LocalDate.of(2000, 6, 20)));
            lista.añadirCliente(new Cliente(3, "RAÚL PÉREZ CASTEJÓN", 375, LocalDate.of(1987, 4, 13)));
            
            lista.irAlUltimo(); // HE IDO AL ÚLTIMO CLIENTE, NO SÉ SI ERA MEDIANTE LOS BOTONES DE LA INTERFAZ O MEDIANTE EL MÉTODO.
            
            // CREO UNA VENTANAPRINCIPAL CON LA LISTA
            new VentanaPrincipal(lista).setVisible(true);
        });
    }
}