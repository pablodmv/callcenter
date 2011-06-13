/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appCliente.services;

/**
 *
 * @author Gustavo Leites
 */
public class BusinessException extends Exception{

    
    public BusinessException(Throwable cause){
        super(cause);
    }
    
    public BusinessException(String message, Throwable cause){
        super(message,cause);
    }

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(){
        
    }

}
