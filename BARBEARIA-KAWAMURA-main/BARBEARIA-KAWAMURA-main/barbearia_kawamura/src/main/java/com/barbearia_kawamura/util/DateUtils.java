package com.barbearia_kawamura.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    public static String formatar(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(FORMATTER) : null;
    }
    
    public static boolean isHorarioFuncionamento(LocalDateTime dataHora) {
        LocalTime hora = dataHora.toLocalTime();
        LocalTime inicio = LocalTime.of(8, 0);
        LocalTime fim = LocalTime.of(20, 0);
        return !hora.isBefore(inicio) && !hora.isAfter(fim);
    }
}