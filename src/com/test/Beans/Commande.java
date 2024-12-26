package com.test.Beans;

import java.time.LocalDate;

public class Commande {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private double total; 
    private LocalDate date_commande; 
    

    public Commande() {
		super();
	}

	public Commande(String nom, String prenom, String adresse, double total, LocalDate dateCommande) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.total = total;
		this.date_commande = dateCommande;
	}

	public Commande(String nom, String prenom, String adresse, double prix) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.total = prix;
	}

	public int getId() {
        return id;
    }

    public void setIdCommande(int idCommande) {
        this.id = idCommande;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public double getPrix() {
        return total;
    }

    public void setPrix(double prix) {
        this.total = prix;
    }

    public LocalDate getDateCommande() {
        return date_commande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.date_commande = dateCommande;
    }

	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", total="
				+ total + ", date_commande=" + date_commande + "]";
	}

  
}
