package tache;

public class Tache {
    private int idTask;
    private String taskName;
    private String taskDesc;
    private boolean est_realise;

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

}
