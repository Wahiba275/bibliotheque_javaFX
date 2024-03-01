package ma.enset.jdbc.dao.entities;

import java.io.Serializable;
import java.sql.Date;

public class Emprunte implements Serializable {
    private int id ;
    private Date dateEmprunt , dateRetour;
    private Adherent adherent;
    private Livre livre;

    public Emprunte() {
    }

    public Emprunte(Date dateEmprunt, Date dateRetour, Adherent adherent, Livre livre) {
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.adherent = adherent;
        this.livre = livre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
