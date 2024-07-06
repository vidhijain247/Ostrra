public class Jobpost {
    String name;
    String loc;
    int id;
    public Jobpost(String name, String loc, int id) {
        this.name = name;
        this.loc = loc;
        this.id = id;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Jobpost{");
        sb.append("name=").append(name);
        sb.append(", loc=").append(loc);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
    
}