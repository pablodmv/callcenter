/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appCliente.services;

import com.appCliente.persistencia.PersistentBroker;
import java.util.ArrayList;
import java.util.List;
import objVirtual.Proveedor;

/**
 *
 * @author Gustavo Leites
 */
public class ProveedorServices {


    public static List<Proveedor> obtenerTodosProveedores() throws BusinessException{

        List<Proveedor> listProveedores = new ArrayList<Proveedor>();
        try{
            PersistentBroker broker = new PersistentBroker();
            listProveedores = broker.getAllProveedores();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }


        return listProveedores;
        
    }

    public static Proveedor obtenerProveedoPorId(Long id) throws BusinessException{

        Proveedor prov = null;
        try{
            PersistentBroker broker = new PersistentBroker();
            prov = broker.getProveedorById(id);


        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return prov;
    }

}
