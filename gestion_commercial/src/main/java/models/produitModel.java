package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.ClassProduits;
import Classes.DatabaseConnection;

public class produitModel {



    public produitModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addProduit(ClassProduits produit) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO produits (IDFAM, designation, stkinvent, stkactual, prixuht, photo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, produit.getIDFAM());
            preparedStatement.setString(2, produit.getDesignation());
            preparedStatement.setInt(3, produit.getStkinvent());
            preparedStatement.setInt(4, produit.getStkactual());
            preparedStatement.setInt(5, produit.getPrixuht());
            preparedStatement.setString(6, produit.getPhoto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public List<ClassProduits> getAllProduits() throws ClassNotFoundException {
	    List<ClassProduits> produits = new ArrayList<>();
	    try (Connection connection = DatabaseConnection.getConnection()) {
	        String query = "SELECT produits.IDProduit, produits.IDFAM, produits.designation, produits.stkinvent, "
	        		+ "produits.stkactual, produits.prixuht, produits.photo, "
	        		+ "familes.intitule FROM produits JOIN familes ON produits.IDFAM = familes.IDFAM";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            ClassProduits produit = new ClassProduits();
	            produit.setIDProduit(resultSet.getInt("IDProduit"));
	            produit.setIDFAM(resultSet.getInt("IDFAM"));
	            produit.setDesignation(resultSet.getString("designation"));
	            produit.setStkinvent(resultSet.getInt("stkinvent"));
	            produit.setStkactual(resultSet.getInt("stkactual"));
	            produit.setPrixuht(resultSet.getInt("prixuht"));
	            produit.setIntitule(resultSet.getString("intitule"));
	            produit.setPhoto(resultSet.getString("photo"));
	            produits.add(produit);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return produits;
	}

    
	public static void updateProduit(ClassProduits produit) throws SQLException, ClassNotFoundException {
	    try (Connection connection = DatabaseConnection.getConnection()) {
	        String query = "UPDATE produits  SET produits.IDFAM= ?, "
	        		+ "produits.designation=?, produits.stkinvent=?, produits.stkactual=?, produits.prixuht=?, "
	        		+ "produits.photo=?  WHERE produits.IDProduit=?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, produit.getIDFAM());
	            preparedStatement.setString(2, produit.getDesignation());
	            preparedStatement.setInt(3, produit.getStkinvent());
	            preparedStatement.setInt(4, produit.getStkactual());
	            preparedStatement.setInt(5, produit.getPrixuht());
	            preparedStatement.setString(6, produit.getPhoto());
	         //   preparedStatement.setString(7, produit.getIntitule());
	            preparedStatement.setInt(7, produit.getIDProduit());
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected == 0) {
	                // No rows were updated, handle the situation accordingly
	                System.out.println("No rows were updated for product with ID " + produit.getIDProduit());
	            } else {
	                System.out.println("Product with ID " + produit.getIDProduit() + " updated successfully.");
	            }
	        }
	    }
	}

    public static void deleteProduit(int IDProduit) throws ClassNotFoundException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM produits WHERE IDProduit=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, IDProduit);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ClassProduits getProduitById(int productId) throws SQLException, ClassNotFoundException {
        ClassProduits produit = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT p.*, f.intitule FROM produits p JOIN familes f ON p.IDFAM = f.IDFAM WHERE p.IDProduit=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                produit = new ClassProduits();
                produit.setIDProduit(resultSet.getInt("IDProduit"));
                produit.setIDFAM(resultSet.getInt("IDFAM"));
                produit.setDesignation(resultSet.getString("designation"));
                produit.setStkinvent(resultSet.getInt("stkinvent"));
                produit.setStkactual(resultSet.getInt("stkactual"));
                produit.setPrixuht(resultSet.getInt("prixuht"));
                produit.setPhoto(resultSet.getString("photo"));
                produit.setIntitule(resultSet.getString("intitule"));
            }
        }
        return produit;
    }

    
}
