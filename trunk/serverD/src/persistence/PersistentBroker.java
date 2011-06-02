package persistence;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author pablo
 */
public class PersistentBroker {
    private static  SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        try {
            if(sessionFactory == null)
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

            return sessionFactory;
        }
        catch(Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
//    static {
//        try {
//            // Create the SessionFactory from standard (hibernate.cfg.xml)
//            // config file.
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            // Log the exception.
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    /**
     * Para salvar objetos
     *
     * @param persistent
     * @throws PersistentException
     */
    public void saveObject(Object persistent) throws Exception {
//        Transaction tx = null;
//        Session session = sessionFactory.openSession();
//        try {
//
//
//
//
//            tx = session.beginTransaction();
//            session.saveOrUpdate(persistent);
//            session.flush();
//            tx.commit();
//            //session.close();
//
//
//        }
//        catch(HibernateException hbex) {
//            tx.rollback();
//            throw new Exception(hbex.getMessage());
//        }
         Transaction tx = null;
        try {
            Session session = PersistentBroker.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(persistent);
            session.flush();
            //session.refresh(persistent);
            tx.commit();
            session.disconnect();
            
           
        }
        catch(HibernateException hbex) {
            tx.rollback();
            throw new Exception(hbex.getMessage());
        }
    }



}
