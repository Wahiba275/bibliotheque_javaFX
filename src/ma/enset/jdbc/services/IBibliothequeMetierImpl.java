package ma.enset.jdbc.services;

import ma.enset.jdbc.dao.AdherentDAO;
import ma.enset.jdbc.dao.EmpruntDAO;
import ma.enset.jdbc.dao.LivreDao;
import ma.enset.jdbc.dao.entities.Adherent;
import ma.enset.jdbc.dao.entities.Emprunte;
import ma.enset.jdbc.dao.entities.Livre;

import java.sql.SQLException;
import java.util.List;

public class IBibliothequeMetierImpl implements IBibliothequeMetier{
    private AdherentDAO adherentDAO;
    private LivreDao livreDao;
    private EmpruntDAO empruntDAO;

    public IBibliothequeMetierImpl(AdherentDAO adherentDAO, LivreDao livreDao, EmpruntDAO empruntDAO) {
        this.adherentDAO = adherentDAO;
        this.livreDao = livreDao;
        this.empruntDAO = empruntDAO;
    }

    @Override
    public List<Adherent> findAllAdherent() {
        return adherentDAO.findAll();
    }

    @Override
    public Adherent saveAdherent(Adherent o) {
        return adherentDAO.save(o);
    }

    @Override
    public boolean deleteAdherent(Adherent o) {
        return adherentDAO.delete(o);
    }

    @Override
    public Adherent findByIdAdherent(int id) {
        return findByIdAdherent(id);
    }

    @Override
    public Adherent updateAdherent(Adherent o) {
        return adherentDAO.update(o);
    }

    @Override
    public List<Adherent> searchAdherent(String mCle) {
        return adherentDAO.search(mCle);
    }

    @Override
    public List<Livre> findAllLivre() {
        return livreDao.findAll();
    }

    @Override
    public Livre saveLivre(Livre o) {
        return livreDao.save(o);
    }

    @Override
    public boolean deleteLivre(Livre o) {
        return livreDao.delete(o);
    }

    @Override
    public Livre findByIdLivre(int id) throws SQLException {
        return livreDao.findById(id);
    }

    @Override
    public Livre updateLivre(Livre o) {
        return livreDao.update(o);
    }

    @Override
    public List<Emprunte> findAllEmprunte() {
        return empruntDAO.findAll();
    }

    @Override
    public Emprunte saveEmprunte(Emprunte o) {
        return empruntDAO.save(o);
    }

    @Override
    public boolean deleteEmprunte(Emprunte o) {
        return empruntDAO.delete(o);
    }
}
