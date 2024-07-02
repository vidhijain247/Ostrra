public class Jobpost {
    String name;
    String loc;
    String company;
    int id;
    public Jobpost(String name, String loc, int id,String company) {
        this.name = name;
        this.loc = loc;
        this.id = id;
        this.company=company;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLoc() {
        return loc;
    }
    public String getComp() {
        return company;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Jobpost [name=" + name + ", loc=" + loc + ", company=" + company;
    }


   
    
}
