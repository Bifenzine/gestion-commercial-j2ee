<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="width:100%; border:1px solid gray;">
    <!-- Input fields for editing product details -->
    <form action="update.php" method="post">
        <input type="hidden" id="editProduitId" name="produit_id" value="<%= request.getAttribute("produitId") %>">
        <div>
            <label for="designation">Designation:</label>
            <input type="text" id="designation" name="designation" value="<%= request.getAttribute("designation") %>">
        </div>
        <div>
            <label for="stkinvent">Stock In Vente:</label>
            <input type="text" id="stkinvent" name="stkinvent" value="<%= request.getAttribute("stkinvent") %>">
        </div>
        <div>
            <label for="stkactual">Stock Actual:</label>
            <input type="text" id="stkactual" name="stkactual" value="<%= request.getAttribute("stkactual") %>">
        </div>
        <div>
            <label for="prixuht">Prix UHT:</label>
            <input type="text" id="prixuht" name="prixuht" value="<%= request.getAttribute("prixuht") %>">
        </div>
         <div>
            <label for="prixuht">intitule:</label>
            <select id="intitule" name="intitule">
            <option value="<%= request.getAttribute("idfamille") %>" selected=true>
           <%= request.getAttribute("intitule") %>
            </option>
             
              <c:forEach items="${familles}" var="p">
              	<option value="${p.IDFAM}" >
           			<c:out value="${p.intitule}"/>
            	</option>
              </c:forEach>
             
            </select>        
    
        </div>
        <button type="submit">Update</button>
    </form>
</div>

</body>
</html>
