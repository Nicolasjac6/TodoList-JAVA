package utilisateur;

public class Utilisateur {
    private int idU;
    private String nameU;
    private String prenomU;
    private String login;
    private String mdp;

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    public void setPrenomU(String prenomU) {
        this.prenomU = prenomU;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public int getIdU() {
        return idU;
    }

    public String getNameU() {
        return nameU;
    }

    public String getPrenomU() {
        return prenomU;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }


}
