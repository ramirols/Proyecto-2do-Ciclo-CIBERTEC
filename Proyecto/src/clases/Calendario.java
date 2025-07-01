package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Calendario {

    public static String fechaActual() {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatoFecha);
    }

    public static String horaActual() {
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatoHora);
    }
}