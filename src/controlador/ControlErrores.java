/* 
    ESTA CLASE EN CONCRETO HA SIDO REALIZADA CON ASISTENCIA DE LA INTELIGENCIA ARTIFICIAL.
    NO HE SABIDO REALIZARLO SOLO, ADEMÁS DE QUE LA IA ME HA AYUDADO A TERMINAR LA CLASE MÁS RÁPIDO.
*/
package controlador;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.format.ResolverStyle;

public class ControlErrores {
    // AJUSTA EL FORMATO DE LA FECHA AL TÍPICO FORMATO DE 'DD/MM/AAAA'
    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    
    public static String validarNumero(String texto) {
        try {
            Integer.parseInt(texto.trim());
            return null;
            
        // EN CASO DE QUE LOS NÚMEROS NO SEAN DE TIPO INTEGER, LANZAMOS UN ERROR.
        } catch (NumberFormatException e) { return "ERROR. EL NÚMERO DEBE DE SER DE TIPO ENTERO."; }
    }

    public static String validarPuntos(String texto) {
        try {
            float p = Float.parseFloat(texto.trim().replace(',', '.'));
            
            // SI LOS PUNTOS NO ESTÁN ENTRE 0 O 1000, DAMOS ERROR.
            if (!(p >= 0 && p <= 1000)) { return "ERROR. LOS PUNTOS DEBEN DE TENER UN VALOR DE 0 A 1000."; }
            return null;
            
        // SI LOS PUNTOS INTRODUCIDOS NO SON UN NÚMERO, DAMOS ERROR.
        } catch (NumberFormatException e) { return "ERROR. LOS PUNTOS DEBEN DE SER UN NÚMERO."; }
    }

    // COMPROBAMOS QUE LA FECHA ESTÉ BIEN
    public static String validarFecha(String texto) {
        try {
            LocalDate f = LocalDate.parse(texto.trim(), FORMATO_FECHA);
            
            // SI EL AÑO NO ESTÁ ENTRE 1900 O 2015, DAMOS ERROR.
            if (f.getYear() < 1900 || f.getYear() > 2015) { return "ERROR. EL AÑO DEBE DE ESTAR ENTRE 1900 Y 2015."; }
            return null;
        
        // ESTE ERROR ES EN CASO DE QUE EL FORMATO SEA INVÁLIDO.
        } catch (DateTimeParseException e) { return "ERROR. FECHA/FORMATO INCORRECT@ (FORMATO DD/MM/AAAA)."; }
    }
}