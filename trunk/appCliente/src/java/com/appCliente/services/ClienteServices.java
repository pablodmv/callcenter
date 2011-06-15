/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appCliente.services;

import com.appCliente.persistencia.PersistentBroker;
import vo.Cliente;
import vo.Credenciales;
import vo.Pedido;

/**
 *
 * @author Gustavo Leites
 */
public class ClienteServices {


    public static Cliente salvarCliente(Cliente cli)throws BusinessException{

        try{
            
            PersistentBroker broker = new PersistentBroker();
            broker.saveObject(cli);

        }catch(Exception ex){
            System.out.println("ClienteServices " + ex.getMessage());
        }
        return cli;

    }


    public static Credenciales salvarCredencial(Credenciales cred)throws BusinessException{

        try{

            PersistentBroker broker = new PersistentBroker();
            broker.saveObject(cred);

        }catch(Exception ex){
            System.out.println("ClienteServices " + ex.getMessage());
        }
        return cred;

    }
    

}
