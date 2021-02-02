package model;

public class Produit {

	
	private int idProduit;
	private String nomProduit;
	private double prixProduit;
	private int idFournisseur;
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public double getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}
	public int getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public Produit(int idProduit, String nomProduit, double prixProduit, int idFournisseur) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.idFournisseur = idFournisseur;
	}
	public Produit(String nomProduit, double prixProduit, int idFournisseur) {
		super();
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
		this.idFournisseur = idFournisseur;
	}
	public Produit() {
		super();
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
				+ ", idFournisseur=" + idFournisseur + "]";
	}
	
	
}
