/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appCliente.services;

import com.appCliente.persistencia.PersistentBroker;
import java.util.ArrayList;
import java.util.List;
import vo.Proveedor;
import vo.Servicio;

/**
 *
 * @author Gustavo Leites
 */
public class ServicioServices {


    public static List<Servicio> obtenerServiciosProveedor(Proveedor prov) throws BusinessException{

        List<Servicio> listaServicios = new ArrayList<Servicio>();
        try{
            PersistentBroker broker = new PersistentBroker();
            listaServicios = broker.getServiciosByProveedor(prov);

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return listaServicios;

    }
}
