package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.ClassCommandes;
import Classes.DatabaseConnection;

public class modelCommandes {

  

    public void addCommande(ClassCommandes commande) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO commandes (IDClient, dteCmd, commentaires, etatCMD) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, commande.getIDClient());
            preparedStatement.setString(2, commande.getDteCmd());
            preparedStatement.setString(3, commande.getCommentaires());
            preparedStatement.setString(4, commande.getEtatCMD());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClassCommandes> getAllCommandes() throws ClassNotFoundException {
        List<ClassCommandes> commandes = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM commandes";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ClassCommandes commande = new ClassCommandes();
                commande.setNumCMD(resultSet.getInt("NumCMD"));
                commande.setIDClient(resultSet.getInt("IDClient"));
                commande.setDteCmd(resultSet.getString("dteCmd"));
                commande.setCommentaires(resultSet.getString("commentaires"));
                commande.setEtatCMD(resultSet.getString("etatCMD"));
                commandes.add(commande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }

    public void updateCommande(ClassCommandes commande) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE commandes SET IDClient=?, dteCmd=?, commentaires=?, etatCMD=? WHERE NumCMD=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, commande.getIDClient());
            preparedStatement.setString(2, commande.getDteCmd());
            preparedStatement.setString(3, commande.getCommentaires());
            preparedStatement.setString(4, commande.getEtatCMD());
            preparedStatement.setInt(5, commande.getNumCMD());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCommande(int NumCMD) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM commandes WHERE NumCMD=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, NumCMD);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
