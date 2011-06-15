/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appProveedor.persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import vo.Cliente;
import vo.Credenciales;
import vo.Pedido;
import vo.PersistenceObj;
import vo.Proveedor;
import vo.Servicio;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Gustavo Leites
 */
public class PersistentBroker {

    //private static Configuration cfg = null;
    private SessionFactory sessionFactory;


    public PersistentBroker(){

//        if(cfg == null){
//            cfg = new Configuration();
//            cfg.configure(new File("C:/Users/Gustavo Leites/ORT/Semestre 6/Arq.Software/obligatorio/appProveedor/src/java/hibernate.cfg.xml"));
//            this.sessionFactory = cfg.buildSessionFactory();
//        }
        try {
            if(sessionFactory == null)
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        }
        catch(Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     *
     * @param perObj
     */
    public void saveObject(PersistenceObj perObj){

       Transaction tx = null;

       try{
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            session.saveOrUpdate(perObj);
            session.flush();
            tx.commit();
            session.disconnect();

       }catch(HibernateException hibEx){
            tx.rollback();
            System.out.println(hibEx.getMessage());
       }


    }

    public Credenciales getCredencialByUsr(String usr){

        Transaction tx = null;

        Credenciales cred = new Credenciales();
        cred.setLogin(usr);
        try{
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Query q = session.createQuery("From vo.Credenciales as Cred Where Cred.login='" +
                    usr + "'");
            cred = (Credenciales)q.uniqueResult();
            tx.commit();
            session.disconnect();
        }catch(HibernateException hibEx){
            tx.rollback();
            System.out.println(hibEx.getMessage());
        }

        return cred;

    }
    

    /**
     * Obtiene el proveedor por el id del ususario con que se logueo.
     * @param id
     * @return
     */
    public Proveedor getProveedorByCredId(Long id){
        Transaction tx = null;

        Proveedor prov = null;
        try{
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            Query q = session.createQuery("From vo.Proveedor as Prov where Prov.credenciales.id=" + id);
            prov = (Proveedor)q.uniqueResult();

            tx.commit();
            session.disconnect();

        }catch(HibernateException hibEx){
            tx.rollback();
            System.out.println(hibEx.getMessage());
        }

        return prov;
    }


    public List<Servicio> getServiciosByProveedor(Proveedor prov){

        List<Servicio> listServicios = new ArrayList<Servicio>();

        try{
            Session session = sessionFactory.openSession();
            listServicios = session.createQuery("From vo.Servicio as Servicio where Servicio.idProveedor= :idProv")
                            .setParameter("idProv", prov.getId()).list();

            session.disconnect();


        }catch(HibernateException hibEx){
            System.out.println(hibEx.getMessage());
        }

        return listServicios;

    }


    public List<Pedido> getPedidosByProveedor(Proveedor prov){

        List<Pedido> listPedidos = new ArrayList<Pedido>();
        try{
            Session session = sessionFactory.openSession();
            listPedidos = session.createQuery("From vo.Pedido as Pedido where Pedido.idProveedor= :idProv and Pedido.estado= :estado")
                          .setParameter("idProv", prov.getId())
                          .setParameter("estado", Boolean.TRUE).list();

            session.disconnect();
        }catch(HibernateException hibEx){
            System.out.println(hibEx.getMessage());
        }


        return listPedidos;
    }


    public Cliente getClienteByPedido(Pedido ped){

        Cliente cli = null;

        try{

            Session session = sessionFactory.openSession();
            cli = (Cliente)session.createQuery("From vo.Cliente as Cliente Where Cliente.id= :idCli")
                  .setParameter("idCli",ped.getIdCliente()).uniqueResult();

            session.disconnect();
        }catch(HibernateException hibEx){
            System.out.println(hibEx.getMessage());
        }

        return cli;

    }


    public Pedido getPedidoById(Long id){

        Pedido pedido = null;

        try{

            Session session = sessionFactory.openSession();
            pedido = (Pedido)session.createQuery("From vo.Pedido as Pedido Where Pedido.id= :idPed")
                  .setParameter("idPed",id).uniqueResult();

            session.disconnect();
        }catch(HibernateException hibEx){
            System.out.println(hibEx.getMessage());
        }

        return pedido;

    }




}
