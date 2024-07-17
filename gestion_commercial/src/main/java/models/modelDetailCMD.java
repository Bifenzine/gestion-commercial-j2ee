package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.ClassDetailCMD;
import Classes.DatabaseConnection;

public class modelDetailCMD {

  

    public void addDetailCMD(ClassDetailCMD detailCMD) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO detailcmd (IDProduit, QT, prixVT) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, detailCMD.getIDProduit());
            preparedStatement.setInt(2, detailCMD.getQT());
            preparedStatement.setInt(3, detailCMD.getPrixVT());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClassDetailCMD> getAllDetailCMDs() throws ClassNotFoundException {
        List<ClassDetailCMD> detailCMDs = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM detailcmd";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ClassDetailCMD detailCMD = new ClassDetailCMD();
                detailCMD.setIDLigneCMD(resultSet.getInt("IDLigneCMD"));
                detailCMD.setIDProduit(resultSet.getInt("IDProduit"));
                detailCMD.setQT(resultSet.getInt("QT"));
                detailCMD.setPrixVT(resultSet.getInt("prixVT"));
                detailCMDs.add(detailCMD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailCMDs;
    }

    public void updateDetailCMD(ClassDetailCMD detailCMD) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE detailcmd SET IDProduit=?, QT=?, prixVT=? WHERE IDLigneCMD=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, detailCMD.getIDProduit());
            preparedStatement.setInt(2, detailCMD.getQT());
            preparedStatement.setInt(3, detailCMD.getPrixVT());
            preparedStatement.setInt(4, detailCMD.getIDLigneCMD());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDetailCMD(int IDLigneCMD) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM detailcmd WHERE IDLigneCMD=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, IDLigneCMD);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

