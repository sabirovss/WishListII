package javaguru.dao;

public class Factory {
		  
		  private static WishDao wishDao = null;
		  private static Factory instance = null;

		  public static synchronized Factory getInstance(){
		    if (instance == null){
		      instance = new Factory();
		    }
		    return instance;
		  }

		  public WishDao getWishDao(){
		    if (wishDao == null){
		    	wishDao = new WishDaoImpl();
		    }
		    return wishDao;
		  }

		}
