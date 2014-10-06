/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.proceso;

import com.lam.migracion.melco.controladores.EventoImpl;
import com.lam.migracion.melco.controladores.MarcajeImpl;
import com.lam.migracion.melco.dao.ControladorDAO;
import com.lam.migracion.melco.entidades.EventLog;
import com.lam.migracion.melco.entidades.Marcaje;
import com.lam.migracion.melco.entidades.MarcajePK;
import com.lam.migracion.melco.util.Util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JoséAntonio
 */
public class HiloMarcaje implements Runnable {

    private long ultimoMarcaje;
//    
    private final Date fechaUltimoMarcaje;
    //
    private final int tiempoEspera;
    //
    private final SimpleDateFormat sdfReferencia;
//    
    private final Date fechaActual;

    public HiloMarcaje(Date fechaUltimoMarcaje, String tiempoEspera) {
//        
        this.fechaUltimoMarcaje = fechaUltimoMarcaje;
//
        this.tiempoEspera = Integer.parseInt(tiempoEspera);
        System.out.println("Tiempo en espera: " + this.tiempoEspera + " (seg)");
//        
        this.sdfReferencia = new SimpleDateFormat("yyyyMMdd");
        this.fechaActual = new Date();
//        
    }

    @Override
    public void run() {
        this.ultimoMarcaje = Util.getTime(this.fechaUltimoMarcaje);
        while (true) {
            System.out.println("Ejecuta hilo marcaje..." + fechaActual);
            if (!this.ejecutaProceso()) {
                break;
            }
            System.out.println("Duerme hilo marcaje..." + new Date());
            this.sleep();

        }

    }

    private boolean ejecutaProceso() {

        List<EventLog> eventos = getEventos(this.ultimoMarcaje);
        System.out.println("Total eventos: " + eventos.size());
        for (EventLog e : eventos) {
            this.ultimoMarcaje = e.getEventLogPK().getNDateTime();
            String valorUserID = Util.convertirIntToString(e.getEventLogPK().getNUserID());
            int idTerminal = Util.getIdTerminalMapeo(e.getEventLogPK().getNReaderIdn());
////            
            Calendar cal = Util.getCalendar();
            cal.add(Calendar.SECOND, (int) this.ultimoMarcaje);
            System.out.println(this.ultimoMarcaje + " | " + cal.getTime() + " | " + Util.getTime(cal.getTime()));
//////            
            Marcaje m = new Marcaje();
            MarcajePK mpk = new MarcajePK();
            mpk.setCompania("A");
            mpk.setTrabajador(valorUserID);
            mpk.setMarcajeDefinitivo(cal.getTime());
//            
            m.setMarcajePK(mpk);
            m.setMarcajeOriginal(cal.getTime());//
            m.setFechaAplicarNomina(cal.getTime());//
            m.setFechaRegistro(fechaActual);//
            m.setFechaModificacion(fechaActual);//
            m.setTipoMarcaje(1);//
            m.setReferencia(sdfReferencia.format(cal.getTime()));//
            m.setUsuario("INTERFACE");//
            m.setIdTerminal(idTerminal);//
            m.setTurno(Short.valueOf("1"));//
            m.setNumeroCredencial("");
            this.setMarcaje(m);
        }
        return true;
    }

    private void sleep() {
        try {

            Thread.sleep(this.tiempoEspera * 1000);
        } catch (Exception e) {
        }
    }

    private static List<EventLog> getEventos(long tiempo) {
        ControladorDAO control = new EventoImpl();
        return control.findEntities(tiempo);
    }

    private boolean setMarcaje(Marcaje marcaje) {
        ControladorDAO control = new MarcajeImpl();
        return control.create(marcaje);
    }
}
