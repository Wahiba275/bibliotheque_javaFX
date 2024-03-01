package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.entities.Adherent;
import ma.enset.jdbc.dao.entities.Emprunte;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdherentDaoImpl implements  AdherentDAO{
    @Override
    public List<Adherent> search(String mCle) {
        List<Adherent> adherents = new ArrayList<>();
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from  adherent " +
                    "where NOM like ?");
            pstm.setString(1,"%"+mCle+"%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Adherent adherent = new Adherent();
                adherent.setId(rs.getInt("ID"));
                adherent.setNom(rs.getString("NOM"));
                adherent.setPrenom(rs.getString("PRENOM"));
                adherent.setCin(rs.getString("CIN"));
                adherent.setTelephone(rs.getString("TELEPHONE"));
                adherent.setEmail(rs.getString("EMAIL"));
                adherent.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
                adherents.add(adherent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adherents;
    }

    @Override
    public List<Emprunte> emprunteList() {
        return null;
    }

    @Override
    public List<Adherent> findAll() {
        List<Adherent> adherents = new ArrayList<>();
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from adherent");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Adherent adherent = new Adherent();
                adherent.setId(rs.getInt("ID"));
                adherent.setNom(rs.getString("NOM"));
                adherent.setPrenom(rs.getString("PRENOM"));
                adherent.setCin(rs.getString("CIN"));
                adherent.setTelephone(rs.getString("TELEPHONE"));
                adherent.setEmail(rs.getString("EMAIL"));
                adherent.setDate_naissance(rs.getDate("DATE_NAISSANCE"));
                adherents.add(adherent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adherents;
    }

    @Override
    public Adherent save(Adherent o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("insert into adherent(NOM , " +
                    "PRENOM, CIN , TELEPHONE,EMAIL,DATE_NAISSANCE) values(?,?,?,?,?,?)");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getPrenom());
            pstm.setString(3,o.getCin());
            pstm.setString(4,o.getTelephone());
            pstm.setString(5,o.getEmail());
            pstm.setDate(6,o.getDate_naissance());
            pstm.executeUpdate();
            return  o ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Adherent findById(int id) throws SQLException {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from adherent where ID = ?");
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            Adherent ad = new Adherent();
            while (rs.next()){
                ad.setId(rs.getInt("ID"));
                ad.setNom(rs.getString("NOM"));
                ad.setPrenom(rs.getString("PRENOM"));
                ad.setCin(rs.getString("CIN"));
                ad.setTelephone(rs.getString("TELEPHONE"));
                ad.setEmail(rs.getString("EMAIL"));
                ad.setDate_naissance(rs.getDate("DATE_NAISSANCE"));

            }
        return  ad ;
    }


    @Override
    public boolean delete(Adherent o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("delete from adherent where ID = ?");
            pstm.setInt(1,o.getId());
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Adherent update(Adherent o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("update  adherent set NOM = ? , " +
                    "PRENOM =? , CIN = ? , TELEPHONE = ?, EMAIL=? , DATE_NAISSANCE=? where ID = ?");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getPrenom());
            pstm.setString(3,o.getCin());
            pstm.setString(4,o.getTelephone());
            pstm.setString(5,o.getEmail());
            pstm.setDate(6,o.getDate_naissance());
            pstm.executeUpdate();
            return  o;
        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }
}
