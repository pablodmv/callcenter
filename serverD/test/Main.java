/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import business.BusinessException;
import business.PedidoServices;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objVirtual.Pedido;

/**
 *
 * @author pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Pedido ped = new Pedido();
            ped.setEstado(true);
            ped.setIdCliente(1);
            ped.setIdProveedor(1);
            ped.setMensaje("Este es el mensaje");
            PedidoServices service = new PedidoServices();
            service.salvarPedido(ped);
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
