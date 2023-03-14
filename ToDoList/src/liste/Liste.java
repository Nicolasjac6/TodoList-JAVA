package liste;

public class Liste {
    private int idList;
    private String listName;
    private String ListDesc;

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setListDesc(String listDesc) {
        ListDesc = listDesc;
    }

    public int getIdList() {
        return idList;
    }

    public String getListName() {
        return listName;
    }

    public String getListDesc() {
        return ListDesc;
    }
    // private int idUserr;

}
