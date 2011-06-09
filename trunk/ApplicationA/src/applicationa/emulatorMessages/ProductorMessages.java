/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package applicationa.emulatorMessages;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ProductorMessages extends Thread {


    private MessageMonitor monitor;
    private List<String> messageList = new ArrayList<String>();
    private boolean lanzar = false;


    public ProductorMessages(MessageMonitor m){

        this.monitor = m;
        
    }

    @Override
    public void run() {

        while(true){

            //System.out.println("ProductorMessages- Run" + this.messageList.size());
            int cont = 0;
            while(this.messageList.size() > 0){
               this.monitor.apilar(this.messageList.get(cont));
               System.out.println(" " + this.messageList.get(cont));
                this.messageList.remove(cont);
                //cont++;
            }
            try{//Da una chance al hilo consumidor

                   sleep((int)(Math.random()*200));
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                    System.out.println(ProductorMessages.class +" -- "+ e.getMessage());
                    break;
            }

//            for(String msg : this.messageList){
//
//                this.monitor.apilar(msg);
//                System.out.println(" " + msg);
//
//                try{//Da una chance al hilo consumidor
//
//                   sleep((int)(Math.random()*200));
//                }catch(InterruptedException e){
//                    Thread.currentThread().interrupt();
//                    System.out.println(ProductorMessages.class +" -- "+ e.getMessage());
//                    break;
//                }
//            }
//
//
//            this.monitor.finProd();
        }
        
        
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public MessageMonitor getMonitor() {
        return monitor;
    }

    public boolean getLanzar() {
        return lanzar;
    }

    public void setLanzar(boolean lanzar) {
        this.lanzar = lanzar;
    }

    


}
