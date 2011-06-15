/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import RemoteObjects.PedidoRemoto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.Pedido;
import persistence.PersistentBroker;

/**
 *
 * @author pablo
 */
public class PedidoServices extends UnicastRemoteObject implements PedidoRemoto {

  public PedidoServices() throws RemoteException {

  }

    public void salvarPedido(Pedido ped) throws RemoteException {

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
            Logger.getLogger(PedidoServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       }

    }

  
//  public Pedido salvarPedido(Pedido pedido) {
//        try {
//            if (pedido == null || pedido.getIdCliente() == 0) {
//                throw new BusinessException("Falta el cliente");
//            }
//            if (pedido.getIdProveedor() == 0) {
//                throw new BusinessException("Falta el Proveedor");
//            }
//
//            PersistentBroker broker = new PersistentBroker();
//            broker.saveObject(pedido);
//
//        } catch (Exception ex) {
//            Logger.getLogger(PedidoServices.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         return pedido;
//       }
       
    

