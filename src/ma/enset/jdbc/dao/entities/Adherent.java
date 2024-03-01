package ma.enset.jdbc.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Adherent implements Serializable {
    private int id;
    private String nom , prenom ;
    private String cin ;
    private String telephone;
    private String email;
    private Date date_naissance;
    private List<Emprunte> empruntes;

    public Adherent() {
    }

    public Adherent(String nom, String prenom, String cin, String telephone, String email, Date date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.telephone = telephone;
        this.email = email;
        this.date_naissance = date_naissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public List<Emprunte> getEmpruntes() {
        return empruntes;
    }

    public void setEmpruntes(List<Emprunte> empruntes) {
        this.empruntes = empruntes;
    }

    @Override
    public String toString() {
        return "Adherent{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", date_naissance=" + date_naissance +
                ", empruntes=" + empruntes +
                '}';
    }
}
