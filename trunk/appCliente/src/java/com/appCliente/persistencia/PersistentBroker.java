/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appCliente.persistencia;

import java.util.ArrayList;
import java.util.List;
import objVirtual.PersistenceObj;
import objVirtual.Proveedor;
import objVirtual.Servicio;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

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

    /**
     * Obtiene el proveedor por el id del ususario con que se logueo.
     * @param id
     * @return
     */
    public List<Proveedor> getAllProveedores(){
        Transaction tx = null;

        List<Proveedor> listProveedores = new ArrayList<Proveedor>();
        try{
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            
            Query q = session.createQuery("From objVirtual.Proveedor as Prov");
            listProveedores = q.list();

            tx.commit();
            session.disconnect();

        }catch(HibernateException hibEx){
            tx.rollback();
            System.out.println(hibEx.getMessage());
        }

        return listProveedores;
    }

    public Proveedor getProveedorById(Long id){

        Proveedor prov = null;
        try{

            Session session = sessionFactory.openSession();
            prov = (Proveedor)session.createQuery("From objVirtual.Proveedor as Prov where Prov.id= :idProv")
                            .setParameter("idProv", id).uniqueResult();

            session.disconnect();

        }catch(HibernateException hibEx){
            
            System.out.println(hibEx.getMessage());
        }

        return prov;
    }


    public List<Servicio> getServiciosByProveedor(Proveedor prov){

        List<Servicio> listServicios = new ArrayList<Servicio>();

        try{
            Session session = sessionFactory.openSession();
            listServicios = session.createQuery("From objVirtual.Servicio as Servicio where Servicio.idProveedor= :idProv")
                            .setParameter("idProv", prov.getId()).list();

            session.disconnect();


        }catch(HibernateException hibEx){
            System.out.println(hibEx.getMessage());
        }

        return listServicios;

    }

}
