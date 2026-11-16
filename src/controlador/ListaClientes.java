package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import modelo.*; // SÉ QUE SÓLO HAY UNA CLASE, PERO ERA MÁS RÁPIDO CON EL '*'

public class ListaClientes extends ArrayList<Cliente> {
    // ATRIBUTO
    private int iCliente = 0; // ESTE ES EL ÍNDICE DEL CLIENTE A MOSTRAR
    
    // CONSTRUCTOR
    public ListaClientes() { super(); }
    
    // MÉTODOS
    public boolean esVacia() { return isEmpty(); }
    
    public boolean esPrimero() { 
        // DEVOLVERÁ "TRUE" SI LA LISTA NO ESTÁ VACÍA Y SI LA POSICIÓN DEL ÍNDICE ES 0 (PRIMERA POS)
        return esVacia() == false && iCliente == 0;
    }
    public boolean esUltimo() {
        // HE RESTADO -1 AL VALOR DEL ÍNDICE PARA LLEGAR AL ÚLTIMO ÍNDICE
        return esVacia() == false && iCliente == size() - 1;
    }
    
    public int getiCliente() { return iCliente; }
    public Cliente clienteActual() {
        if (esVacia() == false) { return get(iCliente); }
        return null; // SÓLO DEVOLVERÁ NULL SI LA LISTA ESTÁ VACÍA
    }
    public boolean existeNumero(int n) {
        /* RECORRE LOS CLIENTES, Y SI SU NÚMERO COINCIDE CON EL PARÁMETRO, 
        SE MOSTRARÁ QUE DICHO NÚMERO YA ESTÁ ASIGNADO POR UN CLIENTE. */
        for(Cliente c : this) { if (c.getNumero() == n) { return true; } }
        return false; // FALSE SI NO EXISTE ESE NÚMERO
    }
    
    public void avanzar() {
        /* SE AUMENTARÁ EL ÍNDICE (ES DECIR, PASARÁ AL SIGUIENTE CLIENTE)
        SI LA LISTA NO ESTÁ VACÍA Y SI NO ES EL ÚLTIMO CLIENTE. */
        if (esVacia() == false && esUltimo() == false) { iCliente++; }
    }
    public void retroceder() {
        /* SE DISMINUYERÁ EL ÍNDICE (ES DECIR, PASARÁ AL CLIENTE ANTERIOR)
        SI LA LISTA NO ESTÁ VACÍA Y SI NO ES EL PRIMER CLIENTE. */
        if (esVacia() == false && esPrimero() == false) { iCliente--; }
    }
    
    public void irAlPrimero() { iCliente = 0; }
    public void irAlUltimo() {
        if (esVacia() == true) {
            iCliente = 0; // SI ESTÁ VACÍA, SE IRÁ AL ÍNDICE 0.
        } else {
            iCliente = size() - 1; // SI NO ESTÁ VACÍA, SE IRÁ AL ÚLTIMO
        }
    }
    
    public void añadirCliente(Cliente c) {
        add(c);
        ordenarPorNumero();
        iCliente = indexOf(c); // NOS COLOCAMOS SOBRE EL CLIENTE AÑADIDO
    }

    public void borrarCliente() {
        /* SI LA LISTA ESTÁ VACÍA, NO SE DEVOLVERÁ NADA,
        SI NO LO ESTÁ, SE BORRARÁ DICHO CLIENTE, 
        Y SI EL TAMAÑO DE LA LISTA SOBREPASA EL ÍNDICE, SE NOS REDIGIRIRÁ AL ÚLTIMO CLIENTE. */
        
        if (esVacia() == true) { return; }
        remove(iCliente);
        if (iCliente >= size()) { irAlUltimo(); }
    }
    
    public void ordenarPorNumero() {
        Collections.sort(this, new Comparator<Cliente>() {
           @Override
           public int compare(Cliente a, Cliente b) { 
               return Integer.compare(a.getNumero(), b.getNumero()); 
           }
        });
    }
}