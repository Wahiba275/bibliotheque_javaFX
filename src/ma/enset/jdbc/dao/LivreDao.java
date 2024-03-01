package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.entities.Livre;

import java.sql.SQLException;

public interface LivreDao extends  Dao<Livre> {
    Livre findById(int id) throws SQLException;
    Livre update(Livre o);
}
