package models;



public class Festival {
    private String Name;
    private String Date;
    private String Place;
    private String FirstHeldYear;
    private String RelFigure;
    private static int count = 0;

    public String getRelFigure() {
        return RelFigure;
    }
    
    public void setRelFigure(String relFigure) {
        RelFigure = relFigure;
    }

    public Festival() {
        count++;
    }
    public Festival(String Name, String Date, String Place, String FirstHeldYear) {
        this.Name = Name;
        this.Date = Date;
        this.Place = Place;
        this.FirstHeldYear = FirstHeldYear;
        count++;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }
    public void setPlace(String Place) {
        this.Place = Place;
    }
    public void setFirstHeldYear(String FirstHeldYear) {
        this.FirstHeldYear = FirstHeldYear;
    }
   
    public String getName() {
        return Name;
    }
    public String getDate() {
        return Date;
    }
    public String getPlace() {
        return Place;
    }
    public String getFirstHeldYear() {
        return FirstHeldYear;
    }
   
}
