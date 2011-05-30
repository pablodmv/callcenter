/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serverd;

import RemoteObjects.PedidoRemoto;
import business.PedidoServices;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author pablo
 */
public class RMIServer {


        public static void main(String[] args){
            try {
            LocateRegistry.createRegistry(1234);
            System.setProperty("java.security.policy", "java.policy");
            System.setSecurityManager(new RMISecurityManager());
            PedidoRemoto pedidoRemoto=new PedidoServices();
            java.rmi.Naming.rebind("//localhost:1234/serverD", pedidoRemoto);
            System.out.println("Servidor Iniciado");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        }
}
