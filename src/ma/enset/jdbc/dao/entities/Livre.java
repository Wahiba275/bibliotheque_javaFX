package ma.enset.jdbc.dao.entities;

import java.io.Serializable;
import java.sql.Date;

public class Livre implements Serializable {
    private int id ;
    private String titre ;
    private String isbn;
    private Date dateEdition;

    public Livre() {
    }

    public Livre(String titre, String isbn, Date dateEdition) {
        this.titre = titre;
        this.isbn = isbn;
        this.dateEdition = dateEdition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", isbn='" + isbn + '\'' +
                ", dateEdition=" + dateEdition +
                '}';
    }
}
