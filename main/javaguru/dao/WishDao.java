package javaguru.dao;


import java.util.Collection;
import java.sql.SQLException;

import javaguru.app.Wish;

public interface WishDao {
  public void addWish(Wish wish) throws SQLException;
  public void updateWish(Integer ID, Wish wish) throws SQLException;
  public Wish getWishById(Integer ID) throws SQLException;
  @SuppressWarnings("rawtypes")
  public Collection getAllWishes() throws SQLException;
  public void deleteWish(Wish wish) throws SQLException;
}
