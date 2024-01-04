
package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SesionesBBDD {
    public static Session session;
    public static SessionFactory miFactory;
    
    
    public static void iniciarOperacion(){
        // Configura y abre una nueva sesión de Hibernate
        miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Citas.class).buildSessionFactory();
        session = miFactory.openSession();
        // Inicia una nueva transacción
        session.beginTransaction();
    }

    public static void terminarOperacion(){
        // Confirma y cierra la transacción actual
        session.getTransaction().commit();
        // Cierra la sesión de Hibernate
        session.close();
    }
}
