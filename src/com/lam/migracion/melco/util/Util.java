/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author JoséAntonio
 */
public class Util {

    public static String convertirIntToString(int value) {
        String valor = Integer.toString(value);
        for (int i = valor.length(); i < 10; i++) {
            valor = " " + valor;
        }
        return valor;
    }

    public static int getIdTerminalMapeo(int idTerminal) {
        switch (idTerminal) {
            case 62826:
                return 8;
            case 62834:
                return 7;
            case 60755:
                return 9;
        }
        return 0;
    }

    public static Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, -1);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public static long getTime(Date fecha) {
        Calendar cal = Calendar.getInstance();
        Calendar calAux = getCalendar();
        cal.setTime(fecha);
        return (cal.getTime().getTime() - calAux.getTime().getTime()) / 1000;

    }
}
