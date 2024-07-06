class Company{
    String companyId;
    String companyName;
   private float comapnyProfit=10000.0f;
	
    void displayCompanyDetails()
    {
        System.out.println(companyId);
        System.out.println(companyName);
        System.out.println(comapnyProfit);
		    }
    

}
public class Profit{
public static void main(String[] args){
	  
   Company c = new Company();
    c.companyId="eng101";
    c.companyName="OSTTRA";
   
    

    c.displayCompanyDetails();

}
}