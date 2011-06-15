/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import business.PedidoServices;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.Pedido;

/**
 *
 * @author pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
            int idcliente=1;
            int idProveedor=1;
          
            int count=0;
          
             String mensaje;
                // System.out.println("Ingrese id Cliente");
//            idcliente = stdin.
//            System.out.println("Ingrese Proveedor");
//            idProveedor=System.in.read();
//            System.out.println("Ingrese mensaje");
//            mensaje=String.valueOf(System.in.read());
            ingresar(idcliente,idProveedor,"Hola");
           
            
      
       
    }


    public static void ingresar (long idcliente, long idProveedor, String mensaje ){
        try {
            // TODO code application logic here

            Pedido ped = new Pedido(idcliente,idProveedor,mensaje,true);
  

            PedidoServices service = new PedidoServices();
            service.salvarPedido(ped);
           
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
