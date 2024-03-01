package ma.enset.jdbc.dao;

import ma.enset.jdbc.dao.LivreDao;
import ma.enset.jdbc.dao.entities.Adherent;
import ma.enset.jdbc.dao.entities.Livre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreDaoImpl implements LivreDao {
    @Override
    public List<Livre> findAll() {
        List<Livre> livres = new ArrayList<>();
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("select * from livre");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Livre livre = new Livre();
                livre.setId(rs.getInt("ID"));
                livre.setTitre(rs.getString("TITRE"));
                livre.setIsbn(rs.getString("ISBN"));
                livre.setDateEdition(rs.getDate("DATE_EDITION"));

                livres.add(livre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return livres;
    }

    @Override
    public Livre save(Livre o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("insert into livre(TITRE,ISBN,DATE_EDITION) values(?,?,?)");
            pstm.setString(1,o.getTitre());
            pstm.setString(2,o.getIsbn());
            pstm.setDate(3,o.getDateEdition());
            pstm.executeUpdate();
            return  o ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Livre findById(int id) throws SQLException {
        Connection connection = SingletonConnexionDB.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from livre where ID = ?");
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        Livre livre = new Livre();
        while (rs.next()) {
            livre.setId(rs.getInt("ID"));
            livre.setTitre(rs.getString("TITRE"));
            livre.setIsbn(rs.getString("ISBN"));
            livre.setDateEdition(rs.getDate("DATE_EDITION"));

        }
        return  livre ;
    }

    @Override
    public boolean delete(Livre o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("delete from livre where ID = ?");
            pstm.setInt(1,o.getId());
            pstm.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Livre update(Livre o) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement pstm = connection.prepareStatement("update livre set TITRE=?,ISBN=?,DATE_EDITION=? where ID=?");
            pstm.setString(1,o.getTitre());
            pstm.setString(2,o.getIsbn());
            pstm.setDate(3,o.getDateEdition());
            pstm.setInt(4,o.getId());
            pstm.executeUpdate();
            return  o;
        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }
}
