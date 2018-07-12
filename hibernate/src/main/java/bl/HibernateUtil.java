package bl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = biildSessionFactory();

    private static SessionFactory biildSessionFactory(){
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }


}
