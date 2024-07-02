public class SearchOutput {
    String comp;
    String job;
    
    @Override
    public String toString() {
        return "SearchOutput [comp=" + comp + ", job=" + job + "]";
    }
    static public SearchOutput createObj(Jobpost job){
        SearchOutput s1= new SearchOutput();
        s1.comp=job.getComp();
        s1.job=job.getName();
        return s1;
    }

}
