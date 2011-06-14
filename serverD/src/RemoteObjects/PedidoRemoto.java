/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RemoteObjects;

import java.rmi.Remote;
import java.rmi.RemoteException;
import objVirtual.Pedido;


/**
 *
 * @author pablo
 */
public interface PedidoRemoto extends Remote {

    public void salvarPedido(Pedido pedido) throws RemoteException ;
    
}
