package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.entities.Adherent;
import ma.enset.jdbc.dao.entities.Emprunte;

import java.sql.SQLException;
import java.util.List;

public interface AdherentDAO extends Dao<Adherent> {
    List<Adherent> search(String mCle);
    List<Emprunte> emprunteList();
    Adherent findById(int id) throws SQLException;
    Adherent update(Adherent o);
}
