package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConnectBD {
	
	String url= "jdbc:mysql://localhost:3306/gestionachats";
	String login= "root";
	String password="";
	
	public boolean addProduct(Produit p) throws SQLException, ClassNotFoundException
	{
	boolean result=false;
    Class.forName("com.mysql.jdbc.Driver");
	Connection cnx= (Connection) DriverManager.getConnection(url,login,password);
	String sql= "INSERT INTO produit ( nomProduit, prixProduit, idFournisseur) VALUES (?, ?, ?)";
	PreparedStatement stm= (PreparedStatement) cnx.prepareCall(sql);
	stm.setString(1, p.getNomProduit());
	stm.setDouble(2, p.getPrixProduit());
	stm.setInt(3, p.getIdFournisseur());
	int rows=stm.executeUpdate();
	if (rows>0)
		result=true;
	stm.close();
	cnx.close();
	
	return result;
	}
	
	public ArrayList<Produit> AllProducts() throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection cnx= (Connection) DriverManager.getConnection(url,login,password);
	ArrayList<Produit> liste= new ArrayList<Produit>();
	Statement stm= (Statement) cnx.createStatement();
	String sql= "select * from produit";
	ResultSet rs= stm.executeQuery(sql);
	while(rs.next())
	{
		liste.add(new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
	}
	
		return liste;
		
	}
	
	public Produit FindProduct(int idProduit) throws ClassNotFoundException, SQLException
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection cnx= (Connection) DriverManager.getConnection(url,login,password);
	Produit p= null;
	Statement stm= (Statement) cnx.createStatement();
	String sql= "select * from produit where idProduit="+idProduit;
	ResultSet rs= stm.executeQuery(sql);
	while(rs.next())
	{
		p= new Produit(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
	}
	
		return p;
		
	}
  public boolean deleteProduct(int idProduit) throws ClassNotFoundException, SQLException
  {
		boolean result=false;
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection cnx= (Connection) DriverManager.getConnection(url,login,password);
	  PreparedStatement stm= (PreparedStatement) cnx.prepareStatement("DELETE from produit where idProduit= ?");
	  stm.setInt(1, idProduit);
	  int rows=stm.executeUpdate();
	  if (rows>0)
			result=true;
		stm.close();
		cnx.close();
		
		return result;

  }
  
  public boolean updateProduct(Produit p) throws ClassNotFoundException, SQLException
  {
  boolean result=false;
  Class.forName("com.mysql.jdbc.Driver");
  Connection cnx= (Connection) DriverManager.getConnection(url,login,password);
  PreparedStatement stm= (PreparedStatement) cnx.prepareStatement("UPDATE produit set  nomProduit = ? , prixProduit= ? , idFournisseur= ?  where idProduit= ? ");
  stm.setString(1, p.getNomProduit());
  stm.setDouble(2, p.getPrixProduit());
  stm.setInt(3, p.getIdFournisseur());
  stm.setInt(4, p.getIdProduit());
  
  int rows=stm.executeUpdate();
  System.out.println(rows);
  if (rows>0)
		result=true;
	stm.close();
	cnx.close();
	
	return result;
	  
  }
}
