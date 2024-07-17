package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.ClassFamilles;
import Classes.DatabaseConnection;

public class modelFamilles {

   

    public void addFamille(ClassFamilles famille) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO familes (intitule) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, famille.getIntitule());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ClassFamilles> getAllFamilles() throws ClassNotFoundException {
        List<ClassFamilles> familles = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM familes";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ClassFamilles famille = new ClassFamilles();
                famille.setIDFAM(resultSet.getInt("IDFAM"));
                famille.setIntitule(resultSet.getString("intitule"));
                familles.add(famille);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return familles;
    }
    
    public static ClassFamilles getAllIdFamilles(int id) throws ClassNotFoundException {
  ClassFamilles famille = new ClassFamilles();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM familes where IDFAM=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              
                famille.setIDFAM(resultSet.getInt("IDFAM"));
                famille.setIntitule(resultSet.getString("intitule"));
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return famille;
    }

    public void updateFamille(ClassFamilles famille) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE familes SET intitule=? WHERE IDFAM=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, famille.getIntitule());
            preparedStatement.setInt(2, famille.getIDFAM());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFamille(int IDFAM) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM familes WHERE IDFAM=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, IDFAM);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
