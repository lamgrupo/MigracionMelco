/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.migracion.melco.proceso;

import com.lam.migracion.melco.controladores.MarcajeImpl;
import com.lam.migracion.melco.dao.ControladorDAO;
import com.lam.migracion.melco.entidades.Marcaje;

/**
 *
 * @author JoséAntonio
 */
public class MigracionMelco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorDAO control = new MarcajeImpl();
        Marcaje m = (Marcaje) control.find();
        System.out.println("Ultimo marcaje: " + m.getMarcajePK().getMarcajeDefinitivo().toString());
        HiloMarcaje hilo = new HiloMarcaje(m.getMarcajePK().getMarcajeDefinitivo(), args[0]);
        hilo.run();
//        
    }
}
