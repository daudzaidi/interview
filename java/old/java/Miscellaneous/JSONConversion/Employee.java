package old.java.Miscellaneous.JSONConversion;

/**
 * Created by pandita on 11/15/2015.
 */
public class Employee {

    private String empName;
    private String empID;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    Employee(String name, String id){
        this.empName=name;

        this.empID=id;
    }

    public void showEmpDetail(){
        System.out.println("Employee ID : "+this.empID);
        System.out.println("Employee Name: " + this.empName);
    }

    public Employee(){
    }
}
