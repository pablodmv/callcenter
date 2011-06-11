/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appProveedor.services;

import com.appProveedor.persistencia.PersistentBroker;
import objVirtual.Credenciales;
import objVirtual.Proveedor;

/**
 *
 * @author Gustavo Leites
 */
public class ProveedorServices {

    /**
     * Dado el usuario logueado obtiene el proveedor
     *
     * @param usr
     * @return
     * @throws BusinessException
     */
    public static Proveedor obtenerProveedor(String usr) throws BusinessException{


        Proveedor prov = null;
        if(!usr.equals("")){
            PersistentBroker broker = new PersistentBroker();
            Credenciales cred = broker.getCredencialByUsr(usr);

            prov = broker.getProveedorByCredId(cred.getId());

        }else{
            throw new BusinessException("Usuario desconocido");
        }
        return prov;
    }

}
