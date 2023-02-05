package models;

public class Dynasty {
    private String name;
    private String label;
    private String lunaryear;
    private String year;
    private static int count = 0;
    public Dynasty(String name, String label, String lunaryear, String year) {
        if (name.contains(".")) this.name = name.split("\\.",2)[1];
        else this.name = name;
        this.label = label;
        this.lunaryear = lunaryear;
        this.year = year;
        count++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.contains(".")) this.name = name.split("\\.",2)[1];
        else this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLunaryear() {
        return lunaryear;
    }

    public void setLunaryear(String lunaryear) {
        this.lunaryear = lunaryear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

   

   
}