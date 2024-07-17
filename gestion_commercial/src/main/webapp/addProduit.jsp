<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ajouter un produit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" ></script>
</head>
<body>

<div style="width:100% ; margin-top:180px; display:flex; justify-content:center; align-content: center ">
<form style = "width: 500px; border:1px solid black ; padding:20px;" >
<h3><strong>Add Product</strong></h3>
  <div class="form-group">
    <label for="exampleFormControlInput1">Designation</label>
    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="nom du produit">
  </div>
  
  
  <div class="form-group">
    <label for="exampleFormControlSelect1">select intitule :</label>
    <select class="form-control" id="exampleFormControlSelect1">
      <option>1</option>
    
    </select>
  </div>

   <div class="form-group">
    <label for="exampleFormControlInput1">Stock in Vente :</label>
    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="stk in vente">
  </div>
  
   <div class="form-group">
    <label for="exampleFormControlInput1">Stock Actual :</label>
    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="stk acual">
  </div>
  
   <div class="form-group">
    <label for="exampleFormControlInput1">Prix UHT :</label>
    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="prix uht">
  </div>
  
  <div class="form-group">
    <label for="exampleFormControlInput1">Photo du Produit :</label>
    <input type="file" class="form-control" id="exampleFormControlInput1" >
  </div>
  
 
   <button type="submit" style="width:100%; padding:5px; margin-top:10px; 
   background-color:black; color:white;">Add Product</button>
 
  
  

</form>
</div>

</body>
</html>