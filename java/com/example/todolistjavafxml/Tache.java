package com.example.todolistjavafxml.todolistjavafxml;

import com.example.todolistjavafxml.todolistjavafxml.Liste;
import com.example.todolistjavafxml.todolistjavafxml.Type;

public class Tache {
        private int id;
        private String nom;
        private String description;
        private boolean estRealise;
        private Liste liste;
        private Type type;

        // Constructeur
        public Tache(int id, String nom, String description, boolean estRealise, Liste liste, Type type) {
            this.id = id;
            this.nom = nom;
            this.description = description;
            this.estRealise = estRealise;
            this.liste = liste;
            this.type = type;
        }

        // Getters et setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public boolean isEst_realise() {
            return estRealise;
        }

        public void setEst_realise(boolean estRealise) {
            this.estRealise = estRealise;
        }

        public Liste getListe() {
            return liste;
        }

        public void setListe(Liste liste) {
            this.liste = liste;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

    public int getIdTask() {
    return type.getId();
    }

    public void setIdTask(Type idTache ) {
        this.type = idTache;

    }

    public String getTaskName() {
            return this.nom;
    }

    public String getTaskDesc() {
            return this.description;
    }
}
