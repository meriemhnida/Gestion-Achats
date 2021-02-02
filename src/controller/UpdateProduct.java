package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ConnectBD;
import model.Produit;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
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
		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		ConnectBD cnx= new ConnectBD();
		
		boolean result= false;
		try {
			result=cnx.updateProduct(new Produit(idProduit,nomProduit, prixProduit,idFournisseur));
			String msg;
			if(result==true)
			{
				msg= "SUCCESS";
				
			}
			else
			{
				msg ="Erreur";
				
			}
			
			request.setAttribute("msgupdate",msg);
			request.getRequestDispatcher("/produit.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
