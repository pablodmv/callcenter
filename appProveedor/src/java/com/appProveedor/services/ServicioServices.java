/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appProveedor.services;

import com.appProveedor.persistencia.PersistentBroker;
import java.util.ArrayList;
import java.util.List;
import objVirtual.Proveedor;
import objVirtual.Servicio;

/**
 *
 * @author Gustavo Leites
 */
public class ServicioServices {


    public static Servicio salvarServicio(Servicio servicio) throws BusinessException{

        try{
            if(servicio == null || servicio.getDescripcion() == null || servicio.getDescripcion().equals("")){
                throw new BusinessException("La descripción es requerida");
            }

            if(servicio.getCosto() == 0){
                throw new BusinessException("El costo del servicio es requerido");
            }

            PersistentBroker broker = new PersistentBroker();
            broker.saveObject(servicio);

        }catch(Exception ex){
            System.out.println("ServicioServices " + ex.getMessage());
        }


        return servicio;
    }

    public static List<Servicio> obtenerServiciosPorProveedor(Proveedor prov) throws BusinessException{

        List<Servicio> listServicio = new ArrayList<Servicio>();
        try{
            if(prov == null || prov.getId()==0){
                throw new BusinessException("El proveedor es vacío.");
            }
            PersistentBroker broker = new PersistentBroker();
            listServicio = broker.getServiciosByProveedor(prov);
        }catch(Exception ex){
            System.out.println("ServicioServices " + ex.getMessage());
        }
        return listServicio;
    }

}
