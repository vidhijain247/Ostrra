 class Employee{

    String empId;
    String empName;
    String empDept;
    float empSalary;

    void displayEmployeeDetails()
    {
        System.out.println(empId);
        System.out.println(empName);
        System.out.println(emDept);
        System.out.println(empSalary);
    }
    

}
public class Main{
public static void main(String[] args){
    Employee e = new Employee ();
    e.empId="eng101";
    e.empName="English";
    e.empDept="IT";
    e.empSalary=10000.0f;

    e.displayEmployeeDetails();

}
}

		