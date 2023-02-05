package models;

public class King {
    private String Name;
    private String NienHieu;
    private String Year;
    private static int count = 0;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getNienHieu() {
        return NienHieu;
    }
    public void setNienHieu(String nienHieu) {
        NienHieu = nienHieu;
    }
    public String getYear() {
        return Year;
    }
    public void setYear(String year) {
        Year = year;
    }
    public King() {
        count++;
    }
    public King(String name, String nienHieu, String year) {

        Name = name;
        NienHieu = nienHieu;
        Year = year;
        count++;
    }

    
}
