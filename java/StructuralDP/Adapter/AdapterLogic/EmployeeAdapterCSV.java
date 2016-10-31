package StructuralDP.Adapter.AdapterLogic;

import StructuralDP.Adapter.Employee;
import StructuralDP.Adapter.EmployeeSource.EmployeeCSV;

/**
 * Created by shalvi on 03/04/16.
 */
public class EmployeeAdapterCSV implements Employee {

    private EmployeeCSV instance;

    public EmployeeAdapterCSV(EmployeeCSV employeeFromCSV) {
        this.instance = employeeFromCSV;
    }

    @Override
    public String getId() {
        return instance.getId()+"";
    }

    @Override
    public String getFirstName() {
        return instance.getFirstName();
    }

    @Override
    public String getLastName() {
        return instance.getLastName();
    }

    @Override
    public String getEmail() {
        return instance.getEmailAddress();
    }

    public String toString(){
        return "ID: "+getId()+"|  Firsname: "+getFirstName()+ " |  Lastname: "+getLastName()+" |  email: "+getEmail();
    }
}
