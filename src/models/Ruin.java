package models;


public class Ruin {
    private String name;
    private String address;
    private String type;
    private String recogyear;
    private static int count = 0;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public void setRecogyear(String recogyear) {
        this.recogyear = recogyear;
    }
    public String getAddress() {
        return address;
    }
    public String getType() {
        return type;
    }
    public String getRecogyear() {
        return recogyear;
    }
    public Ruin(String name, String address, String type, String recogyear) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.recogyear = recogyear;
        count++;
    }
    public Ruin() {
        count++;
    }
  
}
