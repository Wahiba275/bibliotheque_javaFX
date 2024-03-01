package ma.enset.jdbc.services;

import ma.enset.jdbc.dao.AdherentDaoImpl;
import ma.enset.jdbc.dao.EmpruntDAO;
import ma.enset.jdbc.dao.entities.Adherent;
import ma.enset.jdbc.dao.entities.Emprunte;
import ma.enset.jdbc.dao.entities.Livre;

import java.sql.SQLException;
import java.util.List;

public interface IBibliothequeMetier {
    List<Adherent> findAllAdherent();
    Adherent saveAdherent(Adherent o);
    boolean deleteAdherent(Adherent o);
    Adherent findByIdAdherent(int id) ;
    Adherent updateAdherent(Adherent o);
    List<Adherent> searchAdherent(String mCle);
    List<Livre> findAllLivre();
    Livre saveLivre(Livre o);
    boolean deleteLivre(Livre o);
    Livre findByIdLivre(int id) throws SQLException;
    Livre updateLivre(Livre o);
    List<Emprunte> findAllEmprunte();
    Emprunte saveEmprunte(Emprunte o);
    boolean deleteEmprunte(Emprunte o);
}
