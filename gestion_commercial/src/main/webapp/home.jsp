<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" ></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light " style="border-bottom:2px solid gray; border-radius:30px">
  <div class="container">
    <a class="navbar-brand" href="#">Navbar</a>
  </div>
  <div class="" style="display:flex;justify-content:justify-cnter; align-items:center; border:1px solid black; border-radius:50px; padding:8px 8px;margin-right:3rem;">
    <span style="padding-left:8px; border-right:1px solid black; padding-right:8px;"><%= request.getAttribute("username") %></span>
    <img style="width:2rem; margin-right:8px; margin-left:8px; height:2rem; border-radius:50px; border: 2px solid black;" src="" alt="o"/>
  </div>
</nav>

<div style="width:100%; border:1px solid gray; margin-top:7rem; padding-top:2rem; padding-bottom:2rem; padding-left: 6rem;padding-right: 6rem;">
<div style="width:100%; border:1px solid gray;">
<div style="position: relative; display:flex; align-items:center;">
    <input style="width:100%; outline:none; padding:1rem; border:1px solid gray;" type='text' placeholder="Search Products ..." />
    
   
   <form action="ajouter.php" method="post" style="display: inline;">
   	<button type="submit" onclick="redirectToAjouter()" style="position:absolute; align-items:center; background-color: white; padding: 7px; border-radius: 5px; right:10px;">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2"/>
    </svg>
</button>
</form>


    </div>
    <div style="width:100%; border:1px solid gray;display:flex; justify-content: center; align-items:center;">
        <div style="width:100%;padding: 1rem;border-right: 1px solid black; ">ID Produit</div>
        <div style="width:100%;padding: 1rem; border-right: 1px solid black; ">Designation</div>
        <div style="width:100%;padding: 1rem;border-right: 1px solid black; ">StkInvent</div>
        <div style="width:100%;padding: 1rem;border-right: 1px solid black; ">StkActual</div>
        <div style="width:100%;padding: 1rem;border-right: 1px solid black; ">Prix UHT</div>
        <div style="width:100%;padding: 1rem;border-right: 1px solid black; ">Intitule</div>
        <div style="width:100%;padding: 1rem; ">Functions</div>
    </div>
    
    <c:forEach items="${produits}" var="p">
        <div style="width:100%; border:1px solid gray;display:flex; justify-content: center; ">
            <div style="width:100%;padding: 1rem;border-right: 1px solid black; "><c:out value="${p.IDProduit}"/></div>
            <div style="width:100%;padding: 1rem; border-right: 1px solid black; "><c:out value="${p.designation}"/></div>
            <div style="width:100%;padding: 1rem;border-right: 1px solid black; "><c:out value="${p.stkinvent}"/></div>
            <div style="width:100%;padding: 1rem;border-right: 1px solid black; "><c:out value="${p.stkactual}"/></div>
            <div style="width:100%;padding: 1rem;border-right: 1px solid black; "><c:out value="${p.prixuht}"/></div>
            <div style="width:100%;padding: 1rem;border-right: 1px solid black; "><c:out value="${p.intitule}"/></div>
            <div style="display:flex; justify-content:center; gap:1rem; align-items: center; width:100%;padding: 1rem; "  >
                <form action="delete.php" method="post" onsubmit="return confirmDelete()" style="display: inline;">
                    <input type="hidden" name="produit_id" value="${p.IDProduit}">
                    
                    <button type="submit" style="color:white; background-color: gray; height:2rem; width:2rem; border:1px solid gray; border-radius:30px;">x</button>
                </form>

                <form action="edit.php" method="post" style="display: inline;">
                    <input type="hidden" name="operation" value="edit">
                    <input type="hidden" name="produit_id" value="${p.IDProduit}">
                    <input type="hidden" name="famid" value="${p.IDFAM}">
                    <button type="submit" style="color:white ;background-color: green;height:2rem; width:2rem; border:1px solid gray; border-radius:30px;">Edit</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>

</div>

<script>
    function confirmDelete() {
        return confirm("Are you sure you want to delete this product?");
    }
    
</script>


</body>
</html>
