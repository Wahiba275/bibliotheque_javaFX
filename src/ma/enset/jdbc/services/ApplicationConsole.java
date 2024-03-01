package ma.enset.jdbc.services;

import ma.enset.jdbc.dao.*;
import ma.enset.jdbc.dao.entities.Adherent;
import ma.enset.jdbc.dao.entities.Emprunte;
import ma.enset.jdbc.dao.entities.Livre;

import java.sql.Date;
import java.util.List;

public class ApplicationConsole {
    public static void main(String[] args) {
        AdherentDAO adherentDAO= new AdherentDaoImpl();
        LivreDao livreDao = new LivreDaoImpl();
        Adherent adherent = new Adherent("wahiba","bouzyan","pb271027","0614582258","ouahiba@gmail.com",new Date(2001,01,13));
        Livre livre = new Livre("titre","abcd12345" , new Date(2020,01,14));
        /*adherentDAO.save(adherent);
        livreDao.save(livre);
        List<Adherent> adherentList = adherentDAO.findAll();
        List<Livre> livreList = livreDao.findAll();
        for(Adherent adherent1 :adherentList ){
            adherent1.toString();
        }
        for(Livre livre1 : livreList){
            livre1.toString();
        }
        EmpruntDAO empruntDAO =new EmpruntDaoImpl();
        Emprunte emprunte = new Emprunte(new Date(2023,01,13) , new Date(2023,01,20) , adherent,livre);
        empruntDAO.save(emprunte);
*/

    }
}
