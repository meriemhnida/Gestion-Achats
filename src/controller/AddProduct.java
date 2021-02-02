package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ConnectBD;
import model.Produit;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nomProduit=request.getParameter("nomProduit");
		double prixProduit= Double.parseDouble(request.getParameter("prixProduit"));
		int idFournisseur= Integer.parseInt(request.getParameter("idFournisseur"));
		ConnectBD cnx= new ConnectBD();
	 try {
		boolean result= cnx.addProduct(new Produit(nomProduit, prixProduit, idFournisseur));
		String msg;
		if(result==true)
		{
			msg= "SUCCESS";
			
		}
		else
		{
			msg ="Erreur";
			
		}
		
		request.setAttribute("msg",msg);
		request.getRequestDispatcher("/produit.jsp").forward(request, response);
		
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
