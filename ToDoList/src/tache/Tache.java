package utilisateur_authentification.ToDoList.src.tache;

import utilisateur_authentification.Liste;
import utilisateur_authentification.Type;

public class Tache {
    private int idTask;
    private String taskName;
    private String taskDesc;
    private boolean est_realise;

    public Tache(int idTache, String nom, String description, boolean estRealise, Liste liste, Type type) {
        this.idTask = idTache;
        this.taskName = nom;
        this.taskDesc = description;
        this.est_realise = estRealise;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public void setEst_realise(boolean est_realise) {
        this.est_realise = est_realise;
    }

    public int getIdTask() {
        return idTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public boolean isEst_realise() {
        return est_realise;
    }
    // jsp si on rejoute les clef etrangères //

    public Liste getListe() {
        return null;
    }

    public Type getType() {
        return null;
    }
}
