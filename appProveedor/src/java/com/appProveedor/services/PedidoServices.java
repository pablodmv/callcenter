/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appProveedor.services;

import com.appProveedor.persistencia.PersistentBroker;
import java.util.ArrayList;
import java.util.List;
import vo.Pedido;
import vo.Proveedor;

/**
 *
 * @author Gustavo Leites
 */
public class PedidoServices {


    public static void salvarPedido(Pedido ped){

          try {
            if (ped == null || ped.getIdCliente() == 0) {
                throw new BusinessException("Falta el cliente");
            }
            if (ped.getIdProveedor() == 0) {
                throw new BusinessException("Falta el Proveedor");
            }

            PersistentBroker broker = new PersistentBroker();
            broker.saveObject(ped);

        } catch (Exception ex) {
            System.out.println("PedidosServices " + ex.getMessage());
        }

       }


    public static List<Pedido> obtenerPedidosPorProveedor(Proveedor prov) throws BusinessException{

        List<Pedido> listPedido = null;
        try{
            if(prov == null || prov.getId()==0){
                throw new BusinessException("El proveedor es vacío.");
            }
            PersistentBroker broker = new PersistentBroker();
            listPedido = broker.getPedidosByProveedor(prov);
        }catch(Exception ex){
            System.out.println("PedidoServices " + ex.getMessage());
        }
        return listPedido;


    }

    public static Pedido obtenerPedidoPorId(Long id)throws BusinessException{

        Pedido pedido = null;
        try{
            if(id == 0L){
                throw new BusinessException("El id del pedido es vacío.");
            }
            PersistentBroker broker = new PersistentBroker();
            pedido = broker.getPedidoById(id);

        }catch(Exception ex){
            System.out.println("PedidosServices " + ex.getMessage());
        }

        return pedido;
    }

}
