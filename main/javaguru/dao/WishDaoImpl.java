package javaguru.dao;


import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import javaguru.app.HibernateUtil;
import javaguru.app.Wish;
import javaguru.dao.WishDao;

import javax.swing.*;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;


public class WishDaoImpl implements WishDao {

	  public void addWish(Wish wish) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.save(wish);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on paste of Wish", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {

		        session.close();
		      }
		    }
		  }
	  

	  public void updateWish(Integer ID, Wish wish) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.update(wish);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on update of Wish", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
	  
	  public Wish getWishById(Integer ID) throws SQLException {
		    Session session = null;
		    Wish wish = null;
		    try {
		      SessionFactory fly = HibernateUtil.getSessionFactory();
		      session = fly.openSession();
		      wish = (Wish) session.get(Wish.class, ID);
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getWishById", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return wish;
		  }
	  
	  @SuppressWarnings("rawtypes")
	public Collection getAllWishes() throws SQLException {
		    Session session = null;
		    List wishes = new ArrayList<Wish>();
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      wishes = session.createCriteria(Wish.class).list();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getAllWishes", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return wishes;
		  }
	  
	  public void deleteWish(Wish wish) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(wish);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on deleteWish", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
}
