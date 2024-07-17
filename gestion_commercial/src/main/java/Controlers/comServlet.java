package Controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.ClassFamilles;
import Classes.ClassProduits;
import Classes.DatabaseConnection;
import models.modelFamilles;
import models.produitModel;
import org.json.simple.JSONObject;

@WebServlet(name="cs", urlPatterns= {"/comServlet","*.php"})
public class comServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public comServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/login.php")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            String SQL_VERIFY_ADMIN = "SELECT * FROM admin WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(SQL_VERIFY_ADMIN)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    request.setAttribute("username", username);
                    System.out.println(username);
                    
                    produitModel model = new produitModel();
                    List<ClassProduits> produits = model.getAllProduits();
                    request.setAttribute("produits", produits);
                    //System.out.println(produits);
                    
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                } else {
                    System.out.println("Login failed. Redirecting to index.html");
                    response.sendRedirect("index.html");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL Exception occurred: " + e.getMessage());
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
                System.out.println("ClassNotFoundException occurred: " + e1.getMessage());
            } finally {
                DatabaseConnection.closeConnection();
            }
        } else if (path.equals("/delete.php")) {
            String productIdParam = request.getParameter("produit_id");
            if (productIdParam != null && !productIdParam.isEmpty()) {
                try {
                    int productId = Integer.parseInt(productIdParam);
                    produitModel model = new produitModel();
                    produitModel.deleteProduit(productId);

                    List<ClassProduits> produits = model.getAllProduits();
                    request.setAttribute("produits", produits);
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("NumberFormatException occurred: " + e.getMessage());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Product ID parameter is null or empty");
            }
        } else if (path.equals("/edit.php")) {
            String productIdParam = request.getParameter("produit_id");
            if (productIdParam != null && !productIdParam.isEmpty()) {   
                int productId = Integer.parseInt(productIdParam);
                produitModel model = new produitModel();
                ClassProduits produit = null;
				try {
					produit = model.getProduitById(productId);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                if (produit != null) {
                    //System.out.println("Retrieved product details:");
                    //System.out.println("ID: " + produit.getIDProduit());
                    //System.out.println("Designation: " + produit.getDesignation());
                    //System.out.println("Stock In Vente: " + produit.getStkinvent());
                    //System.out.println("Stock Actual: " + produit.getStkactual());
                    //System.out.println("Prix UHT: " + produit.getPrixuht());
                    //System.out.println("Intitule : " + produit.getIntitule());
                    //System.out.println("fam id: " + produit.getIDFAM());

                    new modelFamilles();
                    try {
                        produit.setFamilles(modelFamilles.getAllFamilles());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    request.setAttribute("produitId", produit.getIDProduit());
                    request.setAttribute("designation", produit.getDesignation());
                    request.setAttribute("stkinvent", produit.getStkinvent());
                    request.setAttribute("stkactual", produit.getStkactual());
                    request.setAttribute("prixuht", produit.getPrixuht());
                    request.setAttribute("intitule", produit.getIntitule());
                    request.setAttribute("idfamille", produit.getIDFAM());
                    request.setAttribute("produit", produit);
                    
                    modelFamilles modelfam = new modelFamilles();
                    List<ClassFamilles> familles = null;
					try {
						familles = modelFamilles.getAllFamilles();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    request.setAttribute("familles", familles);
                    //System.out.println(familles);
                    
                    request.getRequestDispatcher("edit.jsp").forward(request, response);
                } else {
                    System.out.println("Product with ID " + productId + " not found");
                    response.sendRedirect("home.jsp");
                }
            }
        } else if (path.equals("/update.php")) {
            int produitId = Integer.parseInt(request.getParameter("produit_id"));
            String designation = request.getParameter("designation");
            int stkinvent = Integer.parseInt(request.getParameter("stkinvent"));
            int stkactual = Integer.parseInt(request.getParameter("stkactual"));
            int prixuht = Integer.parseInt(request.getParameter("prixuht"));
            int intitule = Integer.parseInt(request.getParameter("intitule"));

            ClassProduits p = new ClassProduits();
            p.setIDProduit(produitId);
            p.setDesignation(designation);
            p.setStkinvent(stkinvent);
            p.setStkactual(stkactual);
            p.setPrixuht(prixuht);
            p.setIDFAM(intitule);

            try {
                // Update the product
                produitModel.updateProduit(p);

                // Reload the products
                produitModel model = new produitModel();
                List<ClassProduits> produits = model.getAllProduits();
                request.setAttribute("produits", produits);

                // Forward the request to home.jsp
                request.getRequestDispatcher("home.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else if (path.equals("/ajouter.php")) {
        	    // Redirect to addProduit.jsp
        	    //response.sendRedirect("addProduit.jsp");
        	                   
                    request.getRequestDispatcher("addProduit.jsp").forward(request, response);
                    response.sendRedirect("home.jsp");
               
        }
    
    }}      
