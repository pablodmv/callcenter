/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package applicationa.emulatorMessages;

import RemoteObjects.PedidoRemoto;
import java.rmi.Naming;
import objVirtual.Pedido;

/**
 *
 * @author gustavo
 */
public class ConsumerMessages extends Thread {

     private MessageMonitor monitor;

     public ConsumerMessages(MessageMonitor t){
        this.monitor = t;
    }

    @Override
    public void run() {

        String msg;

        try{
            sleep(200);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(ConsumerMessages.class +" -- "+ e.getMessage());
           
        }

        while(this.monitor.hayStock() || this.monitor.hayProd()){

            msg = this.monitor.sacar();
            System.out.println("                                    " + msg);

            //Proceso el mensaje obtenido

            String[] campos = msg.split("-");
            int j= 0;
            int codCli = 0;
            int codProv = 0;
            String msgPedido = "";
            while(j < campos.length){
                System.out.println(campos[j]);
                //El primer elemento corresponde al código cliente
                if(j == 0){
                    codCli = Integer.parseInt(campos[j]);
                }else if(j == 1){ //El segundo elemento corresponde al código proveedor
                    codProv = Integer.parseInt(campos[j]);
                }else{//Mensaje del pedido

                    msgPedido+= campos[j];
                }

                j++;
            }

            //Los datos procesados son enviados a la aplicacion D para que sean guardados.

            try {
                PedidoRemoto obj = (PedidoRemoto) Naming.lookup("rmi://localhost:1234/serverD");
                Pedido ped = new Pedido();
                ped.setEstado(true);
                ped.setIdCliente(codCli);
                ped.setIdProveedor(codProv);
                ped.setMensaje(msgPedido);
                obj.salvarPedido(ped);

            } catch (Exception ex) {
                System.out.println(ex.getCause().getMessage());
            }

            try{
                sleep((int)(Math.random()*200));
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(ConsumerMessages.class +" -- "+ e.getMessage());
                break;
            }

        }
        
    }



}
