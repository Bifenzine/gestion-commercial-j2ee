package models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.ClientClass;
import Classes.DatabaseConnection;

public class modelClient {



    public void addClient(ClientClass client) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO clients (nom, adresse, cp, ville) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getAdresse());
            preparedStatement.setInt(3, client.getCp());
            preparedStatement.setString(4, client.getVille());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClientClass> getAllClients() throws ClassNotFoundException {
        List<ClientClass> clients = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM clients";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ClientClass client = new ClientClass();
                client.setIDClient(resultSet.getInt("IDClient"));
                client.setNom(resultSet.getString("nom"));
                client.setAdresse(resultSet.getString("adresse"));
                client.setCp(resultSet.getInt("cp"));
                client.setVille(resultSet.getString("ville"));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void updateClient(ClientClass client) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE clients SET nom=?, adresse=?, cp=?, ville=? WHERE IDClient=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getAdresse());
            preparedStatement.setInt(3, client.getCp());
            preparedStatement.setString(4, client.getVille());
            preparedStatement.setInt(5, client.getIDClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int IDClient) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM clients WHERE IDClient=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, IDClient);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
