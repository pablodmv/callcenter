/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package applicationa.emulatorMessages;

/**
 *
 * @author gustavo
 */
public class MessageMonitor {


    public static final int maxMessage= 1;
    private String buffer[] = new String[this.maxMessage];
    private int siguiente = 0;

    //Flags para saber el estado del buffer
    private boolean estaLlena = false;
    private boolean estaVacia = true;
    private boolean esperanza = true; // De producción


     public static void encabe(){

        System.out.println("Prod. cons.");
    }

    /**
     * Método para consumir
     * @return
     */
    public synchronized String sacar(){

        //Espero para consumir
        while(this.estaVacia){

            try{
                wait();
            }catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }

        }

        //se puede consumir, entonces

        this.siguiente--;// decrementamos, vamos a consumir

        if(this.siguiente == 0){ //Fue la ultima ya no quedan mas letras
            this.estaVacia = true;
        }
        // Como acabamos de consumir, ya no se encuentra mas llena.
        this.estaLlena = false;
        notify();

        return(this.buffer[this.siguiente]);

    }

     public synchronized void apilar(String msg){

        //producir

        while(this.estaLlena){ //Ciclo de espera por sitio donde almacenar la nueva produccion.

            try{ //Habrá cuando el método sacar() cambie la bandera 'this.estaLlena' a false.
                wait();
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        }

        this.buffer[this.siguiente++]= msg;

        if(this.siguiente == this.maxMessage){//Comprobamos si el buffer esta lleno
            this.estaLlena = true;

        }
        this.estaVacia = false;
        notify();

    }

    public synchronized void finProd(){
        this.esperanza = false;
    }

    public synchronized boolean hayProd(){
        return this.esperanza;
    }

    public synchronized boolean hayStock(){
        return !this.estaVacia;
    }
    

}
