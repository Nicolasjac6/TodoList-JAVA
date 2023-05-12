package com.example.todolistjavafxml.todolistjavafxml;

import java.util.List;

public class Liste {
    private int idListe;
    private String nom;
    private String nomListe;
    private String description;
    private String descriptionListe;
    private List<Tache> taches;

    public Liste(int idListe) {
        {
            this.idListe = idListe;
            this.nom = nom;
            this.description = description;
        }
    }

    public Liste(String nomListe, String descriptionListe) {
        this.nomListe = nomListe;
        this.descriptionListe = descriptionListe;
    }

    public Liste(String nom, String description, Object utilisateur) {
    }

    public int getIdListe() {
        return idListe;
    }

    public void setIdListe(int idListe) {
        this.idListe = idListe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tache> getTask() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public void ajouterTache(Tache tache) {
        taches.add(tache);
    }

    public void supprimerTache(Tache tache) {
        taches.remove(tache);
    }

    public void setUtilisateur(Utilisateur utilisateur) {
    }

    public String getId() {
        return null;
    }
}