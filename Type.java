public class Type {
    private int id;
    private String label;
    private String colorCode;

    private int idType;

    public Type(int id) {
        this.id = id;
        this.label = label;
        this.colorCode = colorCode;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public int getidType() {
        return this.getId();
    }

    public void setidType(int idType) {
        this.idType = idType;
    }
}