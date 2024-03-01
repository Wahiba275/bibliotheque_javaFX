package ma.enset.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao <T>{
    List<T> findAll();
    T save(T o);
    boolean delete(T o);



}
