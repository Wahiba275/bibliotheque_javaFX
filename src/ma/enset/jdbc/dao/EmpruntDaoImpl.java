package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.entities.Adherent;
import ma.enset.jdbc.dao.entities.Emprunte;
import ma.enset.jdbc.dao.entities.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpruntDaoImpl implements  EmpruntDAO{
    @Override
    public List<Emprunte> findAll() {
        List<Emprunte> empruntes = new ArrayList<>();
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pStm = connection.prepareStatement("select  * from emprunt");
            ResultSet rs = pStm.executeQuery();
            while(rs.next()){
                Emprunte e = new Emprunte();
                e.setId(rs.getInt("ID"));
                e.setDateEmprunt(rs.getDate("DATE_EMPRUNT"));
                e.setDateRetour(rs.getDate("DATE_RETOUR"));
                Adherent ad=new Adherent();
                Livre livre=new Livre();
                PreparedStatement pstm1 = connection.prepareStatement("select * from adherent where ID=?");
                pstm1.setInt(1,rs.getInt("ID"));
                ResultSet rs1= pstm1.executeQuery();
                while(rs1.next()){
                    ad.setId(rs1.getInt("ID"));
                    ad.setNom(rs1.getString("NOM"));
                    ad.setPrenom(rs1.getString("PRENOM"));
                    ad.setCin(rs1.getString("CIN"));
                    ad.setTelephone(rs1.getString("TELEPHONE"));
                    ad.setEmail(rs1.getString("EMAIL"));
                    ad.setDate_naissance(rs1.getDate("DATE_NAISSANCE"));
                }
                PreparedStatement pstm2=connection.prepareStatement("select * from livre where ID=?");
                pstm2.setInt(1,rs.getInt("ID_PATIENT"));
                ResultSet rs2 = pstm2.executeQuery();
                while(rs2.next()){
                    livre.setId(rs2.getInt("ID"));
                    livre.setTitre(rs2.getString("TITRE"));
                    livre.setIsbn(rs2.getString("ISBN"));
                    livre.setDateEdition(rs2.getDate("DATE_EDITION"));
                }
                e.setAdherent(ad);
                e.setLivre(livre);
                empruntes.add(e);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return empruntes;
    }

    @Override
    public Emprunte save(Emprunte o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("insert into emprunt(DATE_EMPRUNT,DATE_RETOUR,ID_ADHERENT,ID_LIVRE) values(?,?,?,?)");
            pstm.setDate(1,o.getDateEmprunt());
            pstm.setDate(2,o.getDateRetour());
            pstm.setInt(3,o.getAdherent().getId());
            pstm.setInt(4,o.getLivre().getId());
            pstm.executeUpdate();
            return  o ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(Emprunte o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("delete from emprunte where ID = ?");
            pstm.setInt(1,o.getId());
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
