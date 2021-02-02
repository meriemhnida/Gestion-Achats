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
<% ConnectBD cnx= new ConnectBD();
int idProduit= Integer.parseInt(request.getParameter("idProduct"));
Produit p= cnx.FindProduct(idProduit);
if (p!=null) {%>
<div class="container">
  <h2>Editer produit</h2>
  <form action="/GestionAchats/UpdateProduct">
    <div class="form-group">
      <label">Nom Produit:</label>
      <input type="text" class="form-control" placeholder="saisir Nom du produit" name="nomProduit" value=<%=p.getNomProduit() %> >
    </div>
    <div class="form-group">
      <label>Prix:</label>
      <input type="text" class="form-control"  placeholder="saisir prix" name="prixProduit" value=<%=p.getPrixProduit() %>>
    </div>
     <div class="form-group">
      <label>Id Fournisseur:</label>
      <input type="text" class="form-control" placeholder="saisir fournisseur" name="idFournisseur" value=<%=p.getIdFournisseur() %>>
        <input type="hidden" class="form-control" placeholder="saisir Nom du produit" name="idProduit" value=<%=p.getIdProduit() %> >
    </div>
    <button type="submit" class="btn btn-primary">Mettre à jour les données</button>
  </form>
<% }%>
 <% msg= (String)request.getAttribute("msg");
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
</div>


</div>
</body>
</html>
