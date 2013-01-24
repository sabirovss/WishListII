package javaguru.app;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
    private static final SessionFactory sessionFactory;
    	    static {
    	      try {
    	        sessionFactory = new Configuration().configure().buildSessionFactory();;  
    	  
      } catch (Exception ex) {
        System.err.println("SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }
    

    public static SessionFactory getSessionFactory() {
      return sessionFactory;
    }
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
