public class sTache {
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

        public boolean isEstRealise() {
            return estRealise;
        }

        public void setEstRealise(boolean estRealise) {
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

    public int getIdTache() {
    return type.getId();
    }

    public void setIdTache(Type idTache ) {
        this.type = idTache;

    }

}
