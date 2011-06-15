/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appProveedor.services;

import com.appProveedor.persistencia.PersistentBroker;
import vo.Cliente;
import vo.Pedido;

/**
 *
 * @author Gustavo Leites
 */
public class ClienteServices {


    public static Cliente obtenerClienteByPedido(Pedido ped)throws BusinessException{


        Cliente cliente = null;
        try{
            if(ped == null || ped.getIdCliente()==0){
                throw new BusinessException("El pedido es vacío.");
            }
            PersistentBroker broker = new PersistentBroker();
            cliente = broker.getClienteByPedido(ped);
        }catch(Exception ex){
            System.out.println("ClienteServices " + ex.getMessage());
        }
        return cliente;

    }

}
