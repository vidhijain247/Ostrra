import java.util.*;
import java.text.SimpleDateFormat;

class College {
    private String name;
    private String website;
    private String mobile;
    private String founder;
    private int numberOfDepts;
    private String location;
    private Date startingDate;

    public College(String name, String website, String mobile, String founder, int numberOfDepts, String location, Date startingDate) {
        this.name = name;
        this.website = website;
        this.mobile = mobile;
        this.founder = founder;
        this.numberOfDepts = numberOfDepts;
        this.location = location;
        this.startingDate = startingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int getNumberOfDepts() {
        return numberOfDepts;
    }

    public void setNumberOfDepts(int numberOfDepts) {
        this.numberOfDepts = numberOfDepts;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public static College fromCSV(String csv) {
        String[] values = csv.split(",");
        String name = values[0];
        String website = values[1];
        String mobile = values[2];
        String founder = values[3];
        int numberOfDepts = Integer.parseInt(values[4]);
        String location = values[5];
        Date startingDate = null;

        try {
            startingDate = new SimpleDateFormat("yyyy-MM-dd").parse(values[6]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new College(name, website, mobile, founder, numberOfDepts, location, startingDate);
    }
}