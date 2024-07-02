package date0207;

public class JobSearch {
    public String JobName;
    public String CompanyName;
   // public JobPost res;
    JobSearch(JobPost res){
        this.CompanyName = res.companyName; 
        this.JobName = res.jobName;
    }
    @Override
    public String toString() {
        return "JobSearch [JobName=" + JobName + ", CompanyName=" + CompanyName + "]";
    }
    
}
