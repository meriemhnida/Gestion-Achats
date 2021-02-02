<%@page import="java.util.ArrayList"%>
<%@page import="model.ConnectBD"%>
<%@page import="model.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Gestion d'Achat</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>
  
</head>
<body>
<%! String msg=null; %>
<div class="container">
  <h2>Nouveau produit</h2>
  <form action="/GestionAchats/AddProduct">
    <div class="form-group">
      <label">Nom Produit:</label>
      <input type="text" class="form-control" placeholder="saisir Nom du produit" name="nomProduit">
    </div>
    <div class="form-group">
      <label>Prix:</label>
      <input type="text" class="form-control"  placeholder="saisir prix" name="prixProduit">
    </div>
     <div class="form-group">
      <label>Id Fournisseur:</label>
      <input type="text" class="form-control" placeholder="saisir fournisseur" name="idFournisseur">
    </div>
    <button type="submit" class="btn btn-primary">Enregistrer le produit dans la base de données</button>
  </form>

 <% msg= (String)request.getAttribute("msg");
 String msgUpdate= (String)request.getAttribute("msgupdate");

 if (msg!=null)
 {
	if (msg=="SUCCESS"){
		msg= " Le Produit  a été ajouté à la base de données";
		%>	 
	
	
	 <p style="color:green;"><%=msg %></p>
 <% } else  {
	 msg ="Erreur lors de l'insertion du produit ";
 %>
 	 <p style="color:red;"><%=msg %></p>
 
<% }
 }
 %>	
 
 <% 
 
  if (msgUpdate!=null)
 {
	if (msgUpdate=="SUCCESS"){
		msg= " Le Produit  a été modifié avec succès";
		%>	 
	
	
	 <p style="color:green;"><%=msg %></p>
 <% } else  {
	 msg ="Erreur lors de la modification du produit ";
 %>
 	 <p style="color:red;"><%=msg %></p>
 
<% }
 }
 %>	
</div>
<% ConnectBD cnx= new ConnectBD();
ArrayList<Produit> liste= cnx.AllProducts();%>

<div class="container">

          
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Produit</th>
        <th>Prix</th>
        <th>Fournisseur</th>
        <th>Supprimer</th>
          <th>Modifier</th>
      </tr>
    </thead>
    <tbody>
    <% for (Produit p : liste) {%>
      <tr>
        <td><%=p.getNomProduit() %></td>
        <td><%=p.getPrixProduit()%></td>
        <td><%=p.getIdFournisseur() %></td>

<td><a href="/GestionAchats/DeleteProduct?idProduct=<%=p.getIdProduit()%>"><i class="fas fa-trash-alt"></i></a></td>
<td><a href="/GestionAchats/UpdateProduct.jsp?idProduct=<%=p.getIdProduit()%>"><i class="fas fa-edit"></a></i>
</td>
      </tr>
  <% }%>
    </tbody>
  </table>
</div>
</body>
</html>
