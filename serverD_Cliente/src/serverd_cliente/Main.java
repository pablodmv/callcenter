/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serverd_cliente;


import RemoteObjects.PedidoRemoto;
import business.PedidoServices;
import java.rmi.Naming;
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
            PedidoRemoto obj = (PedidoRemoto) Naming.lookup("rmi://localhost:1234/serverD");
            Pedido ped = new Pedido();
            ped.setEstado(true);
            ped.setIdCliente(1);
            ped.setIdProveedor(1);
            ped.setMensaje("Este es el mensaje remoto ");
            obj.salvarPedido(ped);

        } catch (Exception ex) {
            System.out.println(ex.getCause().getMessage());
        }

    }
    }

